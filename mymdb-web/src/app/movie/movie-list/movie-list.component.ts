import { Component, ViewChild, OnInit } from '@angular/core';
import { MovieService } from '../movie.service'
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import {Location, LocationStrategy, PathLocationStrategy} from '@angular/common';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss'],
  providers: [Location, {provide: LocationStrategy, useClass: PathLocationStrategy}]
})
export class MovieListComponent {

  movies: Array<any>;
  displayedColumns: string[] = ['movieId', 'title', 'status', 'popularity', 'runtime', 'voteAverage', 'voteCount', 'linkToDetails', 'deleteLink'];
  dataSource;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private movieService: MovieService, private location: Location) { }

  ngOnInit() {
    this.movieService.listAll().subscribe(data => {
      this.movies = data;
      this.dataSource = new MatTableDataSource(this.movies);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.dataSource.filterPredicate = this.filterStrategy;
    });
  }

  filterStrategy(data, filter: string): boolean {
    return data.movieId === filter ||
                  data.title.toLowerCase().includes(filter) ||
                  data.movieStatus.toLowerCase() === filter ||
                  data.runtime.toString() === filter ||
                  data.voteAverage.toString() === filter ||
                  data.voteCount.toString() == filter ||
                  data.popularity.toString() === filter;
  }

  applyFilter(filterText: string) {
    this.dataSource.filter = filterText.trim().toLowerCase();
  }

  findByActor(actorName: string) {
    this.movieService.findByActor(actorName).subscribe(data => {
      this.movies = data;
    });
  }

  deleteMovie(movieId: number) {
    this.movieService.deleteMovie(movieId).subscribe(data => {
      console.log("Is the movie deleted?");
    });
  }

}
