import { Component, ViewChild } from '@angular/core';
import { MovieService } from '../movie.service'
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss']
})
export class MovieListComponent {

  movies: Array<any>;
  displayedColumns: string[] = ['movieId', 'title', 'status', 'popularity', 'runtime', 'voteAverage', 'voteCount'];
  dataSource;

  constructor(private movieService: MovieService) {
    this.movieService.getAll().subscribe(data => {
      this.movies = data;
      this.dataSource = new MatTableDataSource(this.movies);
    });
  }

}
