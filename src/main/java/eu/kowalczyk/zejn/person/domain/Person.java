package eu.kowalczyk.zejn.person.domain;

import eu.kowalczyk.zejn.person.dto.PersonDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
@Entity
@Getter
@Setter
@Builder
class Person {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonAddress personAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private PersonContact personContact;

    public Person() {
    }

    public Person(Long id, String name, String surname, PersonAddress personAddress, PersonContact personContact) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personAddress = personAddress;
        this.personContact = personContact;
    }

    PersonDTO dto() {
        return PersonDTO.builder()
                .id(this.id)
                .name(this.name)
                .surname(this.surname)
                .personAddressDTO(this.personAddress.dto())
                .personContactDTO(this.personContact.dto())
                .build();

    }

}
