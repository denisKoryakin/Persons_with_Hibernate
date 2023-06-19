package ru.koryakin.dbwithmigration.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {

    public int id;

    public String date;

    public int customerId;

    public String productName;

    public int amount;
}
