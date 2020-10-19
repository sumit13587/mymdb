import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) {
  }

  listAll(): Observable<any> {
    return this.http.get('//localhost:8080/movies/list');
  }

  getMovieDetails(movieId: number): Observable<any> {
    return this.http.get('//localhost:8080/movies/view?movieId=' + movieId);
  }

}
