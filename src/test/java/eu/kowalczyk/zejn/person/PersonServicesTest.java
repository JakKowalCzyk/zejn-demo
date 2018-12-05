package eu.kowalczyk.zejn.person;

import eu.kowalczyk.zejn.ZejnApplicationTests;
import eu.kowalczyk.zejn.person.dto.PersonDTO;
import eu.kowalczyk.zejn.person.dto.PersonNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static eu.kowalczyk.zejn.TestUtils.getPersonDTOTest;

/**
 * Created by JKowalczyk on 2018-12-05.
 */
public class PersonServicesTest extends ZejnApplicationTests {

    @Autowired
    private PersonController personController;


    @Test(expected = PersonNotFoundException.class)
    public void integrationPersonTest() {
        PersonDTO personDTO = getPersonDTOTest("test", "testsur", "48601", "street", "postCode", "country", "pz", "pl");

        PersonDTO savedPersonDTO = personController.save(personDTO);
        Assert.assertNotNull(savedPersonDTO.getId());
        Assert.assertNotNull(savedPersonDTO.getPersonContactDTO().getId());
        Assert.assertNotNull(savedPersonDTO.getPersonAddressDTO().getId());
        Assert.assertNotEquals(savedPersonDTO.getId(), savedPersonDTO.getPersonAddressDTO().getId());
        Assert.assertNotEquals(savedPersonDTO.getId(), savedPersonDTO.getPersonContactDTO().getId());
        Assert.assertNotEquals(savedPersonDTO.getPersonAddressDTO().getId(), savedPersonDTO.getPersonContactDTO().getId());
        Assert.assertEquals(personDTO.getName(), savedPersonDTO.getName());
        Assert.assertEquals(personDTO.getSurname(), savedPersonDTO.getSurname());
        Assert.assertEquals(personDTO.getPersonContactDTO().getPhoneNumber(), savedPersonDTO.getPersonContactDTO().getPhoneNumber());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getCity(), savedPersonDTO.getPersonAddressDTO().getCity());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getCountry(), personDTO.getPersonAddressDTO().getCountry());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getPostCode(), savedPersonDTO.getPersonAddressDTO().getPostCode());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getStreet(), savedPersonDTO.getPersonAddressDTO().getStreet());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getStreetNumber(), savedPersonDTO.getPersonAddressDTO().getStreetNumber());

        PersonDTO foundPersonDTO = personController.findById(savedPersonDTO.getId());
        Assert.assertNotNull(foundPersonDTO);
        Assert.assertEquals(foundPersonDTO.getName(), personDTO.getName());

        personController.delete(savedPersonDTO.getId());

        personController.findById(savedPersonDTO.getId());
    }

}
