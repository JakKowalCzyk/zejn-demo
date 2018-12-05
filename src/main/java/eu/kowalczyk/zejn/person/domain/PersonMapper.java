package eu.kowalczyk.zejn.person.domain;

import eu.kowalczyk.zejn.person.dto.PersonAddressDTO;
import eu.kowalczyk.zejn.person.dto.PersonDTO;

/**
 * Created by JKowalczyk on 2018-12-05.
 */
class PersonMapper {

    static Person mapPersonDtoToPerson(PersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .surname(personDTO.getSurname())
                .personAddress(mapPersonAddressDtoToPersonAddress(personDTO))
                .personContact(mapPersonContactDtoToPersonContact(personDTO))
                .build();
    }

    private static PersonAddress mapPersonAddressDtoToPersonAddress(PersonDTO personDTO) {
        PersonAddressDTO personAddressDTO = personDTO.getPersonAddressDTO();
        return PersonAddress.builder().
                city(personAddressDTO.getCity()).
                country(personAddressDTO.getCountry())
                .postCode(personAddressDTO.getPostCode())
                .street(personAddressDTO.getStreet())
                .streetNumber(personAddressDTO.getStreetNumber())
                .build();
    }

    private static PersonContact mapPersonContactDtoToPersonContact(PersonDTO personDTO) {
        return PersonContact.builder().phoneNumber(personDTO.getPersonContactDTO().getPhoneNumber()).build();
    }

}
