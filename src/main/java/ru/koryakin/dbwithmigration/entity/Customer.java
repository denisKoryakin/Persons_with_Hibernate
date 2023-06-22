package ru.koryakin.dbwithmigration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    int id;

    String name;

    String surname;

    int age;

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Order> orders;
}
