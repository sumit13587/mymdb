package org.sumits.mymdbapi.repository;

import org.springframework.data.jpa.domain.Specification;
import org.sumits.mymdbapi.entity.Movie;

public final class MovieSpecifications {
    private MovieSpecifications() { }

    public static Specification<Movie> hasActor(int personId) {
        return (root, query, cb) -> cb.equal(root.joinList("movieCasts").get("person")
                .get("personId"), personId);
    }
}
