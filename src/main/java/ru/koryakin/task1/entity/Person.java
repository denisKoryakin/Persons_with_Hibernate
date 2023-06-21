package ru.koryakin.task1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class Person {

    @EmbeddedId
    PersonId personId;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "city_of_living")
    String cityOfLiving;
}
