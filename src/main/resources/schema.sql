create table if not exists netology.CUSTOMERS(
    id SERIAL primary key,
    name varchar (255) not null,
    surname varchar (255),
    age int,
    phone_number varchar (255)
);

create table if not exists netology.ORDERS(
    id SERIAL primary key,
    date varchar (255) not null,
    customer_id int not null,
    product_name varchar (255) not null,
    amount int not null,
    foreign key (customer_id) references netology.customers (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

