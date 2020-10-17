package org.sumits.mymdbapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.sumits.mymdbapi.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {}
