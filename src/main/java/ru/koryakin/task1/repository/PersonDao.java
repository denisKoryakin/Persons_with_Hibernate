package ru.koryakin.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.koryakin.task1.entity.Person;
import ru.koryakin.task1.entity.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person, PersonId> {

    List<Person> findPersonByCityOfLivingIgnoreCase(String city);

    List<Person> findPersonByPersonIdAgeBeforeOrderByPersonIdAgeAsc(int age);

    Optional<Person> findPersonByPersonIdNameIgnoreCaseAndPersonIdSurnameIgnoreCase(String name, String surname);
}

