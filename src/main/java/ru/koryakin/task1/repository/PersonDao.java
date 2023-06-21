package ru.koryakin.task1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    public List<?> getPersonsByCity(String city) {
        return manager.createQuery("SELECT p from Person p where p.cityOfLiving = ?1")
                .setParameter(1, city)
                .getResultList();
    }
}
