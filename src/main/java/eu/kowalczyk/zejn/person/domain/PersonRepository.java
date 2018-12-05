package eu.kowalczyk.zejn.person.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
@Repository
interface PersonRepository extends CrudRepository<Person, Long> {
}
