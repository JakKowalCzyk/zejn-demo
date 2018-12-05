package eu.kowalczyk.zejn.person.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by JKowalczyk on 2018-12-05.
 */
@ApiModel
@Getter
@Setter
@Builder
public class PersonContactDTO {

    private Long id;
    private String phoneNumber;

    public PersonContactDTO() {
    }

    public PersonContactDTO(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
}
