package eu.kowalczyk.zejn.person.domain;

import eu.kowalczyk.zejn.person.dto.PersonContactDTO;
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
class PersonContact {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String phoneNumber;


    public PersonContact() {
    }

    public PersonContact(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    PersonContactDTO dto() {
        return PersonContactDTO.builder()
                .id(this.id)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
