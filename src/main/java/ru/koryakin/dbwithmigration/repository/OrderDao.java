package ru.koryakin.dbwithmigration.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.koryakin.dbwithmigration.entity.Customer;
import ru.koryakin.dbwithmigration.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderDao {

    @PersistenceContext
    EntityManager manager;

    public Map<String, List<String>> getProductName(String name) {
        Map<String, List<String>> orders = new HashMap<>();

        List<Customer> customers = new ArrayList<>();
        customers = manager.createQuery("SELECT c from Customer c where lower(c.name) like lower(?1)")
                .setParameter(1, name)
                .getResultList();
        System.out.println(customers);

        for (Customer customer : customers) {
            List<String> orderNames = customer.getOrders().stream()
                    .map(Order::getProductName)
                    .collect(Collectors.toList());
            orders.put(customer.getName() + " " + customer.getSurname(), orderNames);
        }
        return orders;
    }
}
