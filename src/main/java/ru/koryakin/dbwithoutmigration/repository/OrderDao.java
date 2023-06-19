package ru.koryakin.dbwithoutmigration.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.koryakin.dbwithoutmigration.entity.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    String sqlScript = read("readProductName.sql");

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        List<Order> orders = namedParameterJdbcTemplate.query(sqlScript, map, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String date = rs.getString("date");
                int customerId = rs.getInt("customer_id");
                String productName = rs.getString("product_name");
                int amount = rs.getInt("amount");
                return new Order(id, date, customerId, productName, amount);
            }
        });
        List<String> products = new ArrayList<>();
        for (Order order : orders) {
            products.add(order.productName);
        }
        return products;
    }
}
