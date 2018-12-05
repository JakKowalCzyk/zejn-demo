package eu.kowalczyk.zejn.person.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by JKowalczyk on 2018-12-05.
 */
public class PersonRepositoryTest implements PersonRepository {

    private Map<Long, Person> personMap = new HashMap<>();
    private Long id = 0L;

    @Override
    public <S extends Person> S save(S s) {
        if (s.getId() == null) {
            s.setId(id);
            personMap.put(s.getId(), s);
            id++;
        }
        return s;
    }


    @Override
    public <S extends Person> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Person> findById(Long aLong) {
        return Optional.ofNullable(personMap.get(aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return personMap.containsKey(aLong);
    }

    @Override
    public Iterable<Person> findAll() {
        return personMap.values();
    }

    @Override
    public Iterable<Person> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        personMap.remove(aLong);
    }

    @Override
    public void delete(Person person) {
        personMap.remove(person.getId());
    }

    @Override
    public void deleteAll(Iterable<? extends Person> iterable) {
        personMap.clear();
    }

    @Override
    public void deleteAll() {
        personMap.clear();
    }
}
