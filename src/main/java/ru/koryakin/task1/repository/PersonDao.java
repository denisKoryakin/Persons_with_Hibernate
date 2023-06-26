package ru.koryakin.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.koryakin.task1.entity.Person;
import ru.koryakin.task1.entity.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person, PersonId> {

    @Query(value = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) LIKE LOWER(?1)")
    List<Person> findPersonByCityOfLivingIgnoreCase(String city);

    @Query(value = "SELECT p FROM Person p WHERE p.personId.age < ?1 ORDER BY p.personId.age")
    List<Person> findPersonByPersonIdAgeBeforeOrderByPersonIdAgeAsc(int age);

    @Query(value = "SELECT p FROM Person p WHERE LOWER(p.personId.name) LIKE LOWER(?1) AND LOWER(p.personId.surname) LIKE LOWER(?2)")
    Optional<Person> findPersonByPersonIdNameIgnoreCaseAndPersonIdSurnameIgnoreCase(String name, String surname);
}

