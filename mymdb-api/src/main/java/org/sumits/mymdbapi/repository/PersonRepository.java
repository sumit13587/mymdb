package org.sumits.mymdbapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.sumits.mymdbapi.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @RestResource(path = "byPersonName", rel = "customFindMethod")
    Person findByPersonName(@Param("personName") String personName);

}
