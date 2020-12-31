import { Component, ViewChild, OnInit } from '@angular/core';
import { MovieService } from '../movie.service'
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import {Location, LocationStrategy, PathLocationStrategy} from '@angular/common';
import { MovieInterface } from 'src/app/types/movie.interface';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss'],
  providers: [Location, {provide: LocationStrategy, useClass: PathLocationStrategy}]
})
export class MovieListComponent {

  movies: MovieInterface[];
  actorNameToSearch: string = '';
  displayedColumns: string[] = ['movieId', 'title', 'status', 'popularity', 'runtime', 'voteAverage', 'voteCount', 'linkToDetails', 'deleteLink'];
  dataSource: MatTableDataSource<MovieInterface>;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private movieService: MovieService, private location: Location) { }

  ngOnInit() {
    this.listAllMovies();
  }

  listAllMovies() {
    this.movieService.listAll().subscribe(data => {
      this.movies = <MovieInterface[]>data;
      this.dataSource = new MatTableDataSource<MovieInterface>(this.movies);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.dataSource.filterPredicate = this.filterStrategy;
    });
  }

  filterStrategy(data: MovieInterface, filter: string): boolean {
    return String(data.movieId) === filter ||
                  data.title.toLowerCase().includes(filter) ||
                  data.movieStatus.toLowerCase() === filter ||
                  String(data.runtime) === filter ||
                  String(data.voteAverage) === filter ||
                  String(data.voteCount) == filter ||
                  String(data.popularity) === filter;
  }

  applyFilter(filterText: string) {
    this.dataSource.filter = filterText.trim().toLowerCase();
  }

  findByActor(): void {
    this.movieService.findByActor(this.actorNameToSearch).subscribe(data => {
      this.dataSource = new MatTableDataSource<MovieInterface>(data);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.dataSource.filterPredicate = this.filterStrategy;
    });
  }

  resetSearch() {
    this.actorNameToSearch = '';
    this.listAllMovies();
  }

  async deleteMovie(movieId: number) {
    const result = await this.movieService.deleteMovie(movieId);
    if(result) {
      alert("Movie deleted successfully");
      this.listAllMovies();
    } else {
      alert("Failed to delete movie");
    }
  }

}
