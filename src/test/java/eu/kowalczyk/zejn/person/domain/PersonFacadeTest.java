package eu.kowalczyk.zejn.person.domain;

import eu.kowalczyk.zejn.person.dto.PersonAddressDTO;
import eu.kowalczyk.zejn.person.dto.PersonContactDTO;
import eu.kowalczyk.zejn.person.dto.PersonDTO;
import eu.kowalczyk.zejn.person.dto.PersonNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import static eu.kowalczyk.zejn.TestUtils.getPersonDTOTest;

/**
 * Created by JKowalczyk on 2018-12-05.
 */
public class PersonFacadeTest {

    @Test
    public void save() {
        PersonFacade personFacade = new PersonFacade(new PersonRepositoryTest());

        PersonDTO personDTO = getPersonDTOTest("test", "testsur", "48601", "street", "postCode", "country", "pz", "pl");

        PersonDTO savedPersonDTO = personFacade.save(personDTO);
        Assert.assertNotNull(savedPersonDTO.getId());
        Assert.assertEquals(personDTO.getName(), savedPersonDTO.getName());
        Assert.assertEquals(personDTO.getSurname(), savedPersonDTO.getSurname());
        Assert.assertEquals(personDTO.getPersonContactDTO().getPhoneNumber(), savedPersonDTO.getPersonContactDTO().getPhoneNumber());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getCity(), savedPersonDTO.getPersonAddressDTO().getCity());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getCountry(), personDTO.getPersonAddressDTO().getCountry());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getPostCode(), savedPersonDTO.getPersonAddressDTO().getPostCode());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getStreet(), savedPersonDTO.getPersonAddressDTO().getStreet());
        Assert.assertEquals(personDTO.getPersonAddressDTO().getStreetNumber(), savedPersonDTO.getPersonAddressDTO().getStreetNumber());

        Assert.assertNotNull(personFacade.findOne(savedPersonDTO.getId()));
        Assert.assertEquals(personFacade.findOne(savedPersonDTO.getId()).getName(), savedPersonDTO.getName());
    }

    @Test(expected = PersonNotFoundException.class)
    public void findOne() {
        PersonFacade personFacade = new PersonFacade(new PersonRepositoryTest());

        PersonDTO personDTO = getPersonDTOTest("test", "testsur", "48601", "street", "postCode", "country", "pz", "pl");

        PersonDTO savedPersonDTO = personFacade.save(personDTO);
        Assert.assertNotNull(savedPersonDTO.getId());
        Assert.assertNotNull(personFacade.findOne(savedPersonDTO.getId()));

        personFacade.findOne(savedPersonDTO.getId() + 100);
    }

    @Test(expected = PersonNotFoundException.class)
    public void delete() {
        PersonFacade personFacade = new PersonFacade(new PersonRepositoryTest());

        PersonDTO personDTO = getPersonDTOTest("test", "testsur", "48601", "street", "postCode", "country", "pz", "pl");

        PersonDTO savedPersonDTO = personFacade.save(personDTO);
        Assert.assertNotNull(savedPersonDTO.getId());
        Assert.assertNotNull(personFacade.findOne(savedPersonDTO.getId()));

        personFacade.delete(savedPersonDTO.getId());

        personFacade.findOne(savedPersonDTO.getId());
    }


}