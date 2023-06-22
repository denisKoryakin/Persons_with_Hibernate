package ru.koryakin.dbwithmigration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    int id;

    String date;

    @Column(name = "customer_id")
    int customerId;

    @Column(name = "product_name")
    String productName;

    int amount;
}
