package eu.kowalczyk.zejn;

import eu.kowalczyk.zejn.person.dto.PersonAddressDTO;
import eu.kowalczyk.zejn.person.dto.PersonContactDTO;
import eu.kowalczyk.zejn.person.dto.PersonDTO;

/**
 * Created by JKowalczyk on 2018-12-05.
 */
public class TestUtils {

    public static PersonDTO getPersonDTOTest(String test, String testsur, String phoneNumber, String street, String postCode, String country, String city, String pl) {
        return PersonDTO.builder()
                .name(test)
                .surname(testsur)
                .personContactDTO(PersonContactDTO.builder().phoneNumber(phoneNumber).build())
                .personAddressDTO(getPersonAddressTest(street, postCode, country, city, pl))
                .build();
    }

    private static PersonAddressDTO getPersonAddressTest(String street, String postCode, String country, String city, String pl) {
        return PersonAddressDTO.builder()
                .street(street)
                .postCode(postCode)
                .country(country)
                .city(city)
                .country(pl)
                .build();
    }
}
