import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MovieListComponent } from './movie/movie-list/movie-list.component';
import { MovieDetailsComponent } from './movie/movie-details/movie-details.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component'

const appRoutes: Routes = [
  {
    path: 'movies/list',
    component: MovieListComponent
  },
  {
    path: 'movies/details/:movieId',
    component: MovieDetailsComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: false, // <-- debugging purposes only
      }
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
