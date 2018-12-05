package eu.kowalczyk.zejn.person.dto;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id) {
        super(String.format("Person [%s] not found", id));
    }
}
