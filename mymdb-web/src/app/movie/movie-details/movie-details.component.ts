import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie.service'

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.scss']
})
export class MovieDetailsComponent implements OnInit {

  movieDetails;

  constructor(private route: ActivatedRoute, private movieService: MovieService) { }

  ngOnInit(): void {
      this.movieService.getMovieDetails(this.route.snapshot.params.movieId).subscribe(data => {
      this.movieDetails = data;
    });
  }

}
