import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClientHelper } from 'src/app/helpers/httpclient.helper'

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) {
  }

  listAll(): Observable<any> {
    return this.http.get(`${HttpClientHelper.baseURL}/movies/list`);
  }

  getMovieDetails(movieId: number): Observable<any> {
    return this.http.get(`${HttpClientHelper.baseURL}/movies/view?movieId=` + movieId);
  }

  findByActor(actorName: string): Observable<any> {
    return this.http.get(`${HttpClientHelper.baseURL}/movies/findByActor?personName=` + actorName);
  }

  async deleteMovie(movieId: number) {
    return await this.http.delete(`${HttpClientHelper.baseURL}/movies/delete?movieId=` + movieId).toPromise();
  }
}
