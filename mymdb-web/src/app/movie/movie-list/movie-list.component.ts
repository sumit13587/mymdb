import { Component, ViewChild, OnInit } from '@angular/core';
import { MovieService } from '../movie.service'
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss']
})
export class MovieListComponent {

  movies: Array<any>;
  displayedColumns: string[] = ['movieId', 'title', 'status', 'popularity', 'runtime', 'voteAverage', 'voteCount'];
  dataSource;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.movieService.getAll().subscribe(data => {
      this.movies = data;
      this.dataSource = new MatTableDataSource(this.movies);
      this.dataSource.sort = this.sort;
    });
  }

}
