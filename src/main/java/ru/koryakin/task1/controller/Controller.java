package ru.koryakin.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.koryakin.task1.entity.Person;
import ru.koryakin.task1.repository.PersonDao;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PersonDao personDao;

    @GetMapping("/persons/by-{city}")
    public List<?> personsToReturnByCity(@PathVariable String city) {
        return personDao.getPersonsByCity(city);
    }
}
