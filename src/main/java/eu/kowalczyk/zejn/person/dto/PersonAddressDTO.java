package eu.kowalczyk.zejn.person.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
@ApiModel
@Getter
@Setter
@Builder
public class PersonAddressDTO {


    private Long id;
    private String city;
    private String country;
    private String postCode;
    private String street;
    private String streetNumber;


    public PersonAddressDTO() {
    }

    public PersonAddressDTO(Long id, String city, String country, String postCode, String street, String streetNumber) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.street = street;
        this.streetNumber = streetNumber;
    }
}
