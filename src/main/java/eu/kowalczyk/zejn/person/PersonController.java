package eu.kowalczyk.zejn.person;

import eu.kowalczyk.zejn.person.domain.PersonFacade;
import eu.kowalczyk.zejn.person.dto.PersonDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
@RestController
@Api(tags = {"Person API"}, description = "Services for persons")
@RequestMapping("/api/persons")
class PersonController {

    @Autowired
    private PersonFacade personFacade;

    @GetMapping("/{id}")
    @ApiOperation(value = "Find by id")
    PersonDTO findById(@PathVariable Long id) {
        return personFacade.findOne(id);
    }

    @PostMapping
    @ApiOperation(value = "Save personId")
    PersonDTO save(@RequestBody PersonDTO personDTO) {
        return personFacade.save(personDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete by id")
    void delete(@PathVariable Long id) {
        personFacade.delete(id);
    }

}
