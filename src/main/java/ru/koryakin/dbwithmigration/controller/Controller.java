package ru.koryakin.dbwithmigration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.koryakin.dbwithmigration.repository.OrderDao;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    OrderDao orderDao;

    @GetMapping("/products/fetch-product")
    public Map<String, List<String>> getProducts(@RequestParam("name") String name) {
        return orderDao.getProductName(name);
    }
}
