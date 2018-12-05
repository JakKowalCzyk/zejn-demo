package eu.kowalczyk.zejn.person.domain;

import eu.kowalczyk.zejn.person.dto.PersonAddressDTO;
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
class PersonAddress {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String city;
    private String country;
    private String postCode;
    private String street;
    private String streetNumber;


    public PersonAddress() {
    }

    public PersonAddress(Long id, String city, String country, String postCode, String street, String streetNumber) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    PersonAddressDTO dto() {
        return PersonAddressDTO.builder()
                .id(this.id)
                .city(this.city)
                .country(this.country)
                .postCode(this.postCode)
                .street(this.street)
                .streetNumber(this.streetNumber)
                .build();
    }
}
