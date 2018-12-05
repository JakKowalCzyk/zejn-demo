package eu.kowalczyk.zejn.person.domain;

import eu.kowalczyk.zejn.person.dto.PersonDTO;
import eu.kowalczyk.zejn.person.dto.PersonNotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
public class PersonFacade {

    private PersonRepository personRepository;

    public PersonFacade(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO save(PersonDTO personDTO) {
        return personRepository.save(PersonMapper.mapPersonDtoToPerson(personDTO)).dto();
    }

    @Cacheable(value = "personCacheById", key = "#id")
    public PersonDTO findOne(Long id) {
        return getById(id).dto();
    }

    @Caching(evict = {
            @CacheEvict(value = "personCacheById", key = "#id")
    })
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    private Person getById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }


}
