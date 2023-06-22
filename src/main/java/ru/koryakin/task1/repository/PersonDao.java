package ru.koryakin.task1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.koryakin.task1.entity.Person;

import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    public List<?> getPersonsByCity(String city) {
        return manager.createQuery("SELECT p from Person p where lower(p.cityOfLiving) like lower(?1)")
                .setParameter(1, city)
                .getResultList();
    }
}
