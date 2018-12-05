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
public class PersonDTO {

    private Long id;

    private String name;
    private String surname;

    private PersonAddressDTO personAddressDTO;
    private PersonContactDTO personContactDTO;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, String surname, PersonAddressDTO personAddressDTO, PersonContactDTO personContactDTO) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personAddressDTO = personAddressDTO;
        this.personContactDTO = personContactDTO;
    }
}
