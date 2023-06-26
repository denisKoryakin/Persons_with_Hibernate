package ru.koryakin.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.koryakin.task1.entity.Person;
import ru.koryakin.task1.repository.PersonDao;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    PersonDao personDao;

    @GetMapping("/persons/byCity-{city}")
    public List<Person> personsToReturnByCity(@PathVariable String city) {
        return personDao.findPersonByCityOfLivingIgnoreCase(city);
    }

    @GetMapping("/persons/byAge-{age}")
    public List<Person> personsToReturnByAge(@PathVariable String age) {
        return personDao.findPersonByPersonIdAgeBeforeOrderByPersonIdAgeAsc(Integer.parseInt(age));
    }

    @GetMapping("/persons/byNameAndSurname-{NameAndSurname}")
    public Optional<Person> personsToReturnByNameAndSurname(@PathVariable String NameAndSurname) {
        String[] words = NameAndSurname.split(" ");
        return personDao.findPersonByPersonIdNameIgnoreCaseAndPersonIdSurnameIgnoreCase(words[0], words[1]);
    }
}
