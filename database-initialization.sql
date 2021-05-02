create schema BelTransport;

create table vehicles
(
    id     int         not null primary key auto_increment,
    number varchar(30) not null,
    model  varchar(30) not null,
    type   varchar(15) not null
);

create table users
(
    id       int          not null primary key auto_increment,
    login    varchar(30)  not null unique,
    password varchar(150) not null,
    role     varchar(15)  not null default 'CLIENT',
    status   varchar(15)  not null default 'ACTIVE'
);

create table drivers
(
    id           int         not null primary key auto_increment,
    phone_number varchar(30) not null,
    vehicle_id   int         not null,
    foreign key (id)
        references users (id),
    foreign key (vehicle_id)
        references vehicles (id)
);

create table clients
(
    id           int         not null primary key auto_increment,
    name         varchar(30) not null,
    surname      varchar(35) not null,
    email        varchar(40) not null,
    phone_number varchar(25) not null,
    bonus        int         not null default 0
);

create table rides
(
    id             int          not null primary key auto_increment,
    start_location varchar(100) not null,
    end_location   varchar(100) not null,
    start_date     datetime              default now(),
    end_date       datetime,
    driver_id      int,
    price          double       not null,
    landing_sites  int          not null default 10,
    foreign key (driver_id)
        references drivers (id)
);

create table payment(
    id int not null primary key auto_increment,
    payment_date datetime default now(),
    price double not null ,
    type varchar(15) not null
);

create table orders(
    id int not null primary key auto_increment,
    ride_id int not null ,
    client_id int not null ,
    payment_id int not null
);