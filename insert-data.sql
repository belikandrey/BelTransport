
#Vehicles
insert into vehicles (number, model, type)
values ('2677', 'Mark VIII', 'MINIBUS');
insert into vehicles (number, model, type)
values ('4729', 'Express 1500', 'MINIBUS');
insert into vehicles (number, model, type)
values ('1892', 'Savana 1500', 'BUS');
insert into vehicles (number, model, type)
values ('6931', 'Corvette', 'MINIBUS');
insert into vehicles (number, model, type)
values ('9274', 'Expedition', 'BUS');
insert into vehicles (number, model, type)
values ('1459', 'Ram Wagon B150', 'BUS');
insert into vehicles (number, model, type)
values ('3080', 'tC', 'MINIBUS');
insert into vehicles (number, model, type)
values ('3729', 'M5', 'MINIBUS');
insert into vehicles (number, model, type)
values ('4512', 'Wrangler', 'BUS');
insert into vehicles (number, model, type)
values ('4428', 'Silverado', 'BUS');


#Users/drivers
insert into users (login, password, role, status) values ('ajakobssen0', 'vKwmq3cy', 'DRIVER', 'ACTIVE');
insert into users (login, password,  role, status) values ('abanes1', '9SujAAlesR8v', 'DRIVER', 'ACTIVE');
insert into users (login, password,  role, status) values ('icasajuana2', 'peRw3sGV', 'DRIVER', 'ACTIVE');
insert into users (login, password, role, status) values ('rklammt3', '09SVqKWQD', 'DRIVER', 'ACTIVE');
insert into users (login, password, role, status) values ('ebusfield4', 'JMspDBX48A', 'DRIVER', 'ACTIVE');
insert into users (login, password, role, status) values ('gpomroy5', 'jHyfQCM', 'DRIVER', 'BANNED');
insert into users (login, password, role, status) values ('fdreinan6', 'Ce2TFuvR9', 'DRIVER', 'ACTIVE');
insert into users (login, password, role, status) values ('acamier7', '6qC7bqKDS2', 'DRIVER', 'ACTIVE');
insert into users (login, password, role, status) values ('ldelacroix8', '4s1CKh2itCvG', 'DRIVER', 'ACTIVE');
insert into users (login, password, role, status) values ('ntristram9', '0sedRxLg', 'DRIVER', 'ACTIVE');

#Drivers
insert into drivers (id, phone_number, vehicle_id) values (1, '+375334160090', 1);
insert into drivers (id, phone_number, vehicle_id) values (2, '+375334160091', 2);
insert into drivers (id, phone_number, vehicle_id) values (3, '+375334160092', 3);
insert into drivers (id, phone_number, vehicle_id) values (4, '+375334160093', 4);
insert into drivers (id, phone_number, vehicle_id) values (5, '+375334160094', 5);
insert into drivers (id, phone_number, vehicle_id) values (6, '+375334160095', 6);
insert into drivers (id, phone_number, vehicle_id) values (7, '+375334160096', 7);
insert into drivers (id, phone_number, vehicle_id) values (8, '+375334160097', 8);
insert into drivers (id, phone_number, vehicle_id) values (9, '+375334160098', 9);
insert into drivers (id, phone_number, vehicle_id) values (10, '+375334160099', 10);



#Users/clients
insert into users (login, password, role, status) values ('pcovila', 'FYzJbbLOG', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('hhowittb', 'br2xJ6s4B0Vb', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('scharlonc', 'r3k2nn3lkx', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('gmelloid', 'vl5RC2UvA8', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('kjacoxe', 'LJEVzN', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('cthompstonef', 'DcEnh6', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('mparellg', '9OwXVoMbvQ', 'CLIENT', 'BANNED');
insert into users (login, password, role, status) values ('oforsdikeh', '6fw7izq2Mvyp', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('lsolmani', 'KKn7OwXT', 'CLIENT', 'ACTIVE');
insert into users (login, password, role, status) values ('oliefj', '0fSmdk2cp', 'CLIENT', 'ACTIVE');


#Clients
insert into clients (id, name, surname, email, phone_number, bonus) values (11, 'Aymer', 'Felipe', 'afelipe0@blogs.com', '348-621-6445', 7);
insert into clients (id, name, surname, email, phone_number, bonus) values (12, 'Albina', 'Layburn', 'alayburn1@shinystat.com', '619-730-5311', 8);
insert into clients (id, name, surname, email, phone_number, bonus) values (13, 'Hillie', 'Twydell', 'htwydell2@imgur.com', '939-552-9575', 3);
insert into clients (id, name, surname, email, phone_number, bonus) values (14, 'Weylin', 'Tattershaw', 'wtattershaw3@imdb.com', '805-524-6246', 3);
insert into clients (id, name, surname, email, phone_number, bonus) values (15, 'Sim', 'Itscovitz', 'sitscovitz4@opensource.org', '779-577-7361', 3);
insert into clients (id, name, surname, email, phone_number, bonus) values (16, 'Danica', 'Tottie', 'dtottie5@de.vu', '989-211-3536', 1);
insert into clients (id, name, surname, email, phone_number, bonus) values (17, 'Edgardo', 'Benoi', 'ebenoi6@github.com', '965-600-7454', 6);
insert into clients (id, name, surname, email, phone_number, bonus) values (18, 'Delphinia', 'Whenman', 'dwhenman7@tripadvisor.com', '192-817-6509', 4);
insert into clients (id, name, surname, email, phone_number, bonus) values (19, 'Egon', 'Underdown', 'eunderdown8@phoca.cz', '279-634-4878', 2);
insert into clients (id, name, surname, email, phone_number, bonus) values (20, 'Sherman', 'Kimmins', 'skimmins9@mediafire.com', '247-231-0654', 3);


#User/admin
insert into users (login, password, role, status) values ('admin_main', 'admin_main', 'ADMIN', 'ACTIVE');


#Payment
insert into payment (payment_date, price, type) values ('2021-04-27 01:09:42', 54.87, 'CASH');
insert into payment (payment_date, price, type) values ('2021-03-04 06:23:16', 10.35, 'CASH');
insert into payment (payment_date, price, type) values ('2021-01-03 04:52:05', 89.32, 'CASH');
insert into payment (payment_date, price, type) values ('2020-06-05 01:26:24', 34.88, 'BANK_CARD');
insert into payment (payment_date, price, type) values ('2020-06-23 03:55:19', 19.01, 'BANK_CARD');
insert into payment (payment_date, price, type) values ('2020-08-21 06:17:36', 6.22, 'BANK_CARD');
insert into payment (payment_date, price, type) values ('2020-05-13 04:18:40', 19.27, 'BANK_CARD');
insert into payment (payment_date, price, type) values ('2020-07-29 17:11:43', 53.74, 'BANK_CARD');
insert into payment (payment_date, price, type) values ('2020-06-05 03:47:05', 39.11, 'CASH');
insert into payment (payment_date, price, type) values ('2020-09-13 00:16:10', 91.11, 'CASH');


#Ride
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (1, 'Zhenjiang', 'Ágios Spyrídon', '2020-10-26 08:18:01', '2020-12-06 19:03:53', 4, 11, 20);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (2, 'Santo Tomás', 'Richmond', '2020-11-29 02:59:52', '2020-07-08 22:00:09', 9, 7, 16);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (3, 'Huanggang', 'Porlamar', '2021-03-18 20:30:45', '2021-01-04 06:54:41', 8, 82, 20);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (4, 'Muleng', 'Dārāb', '2020-12-05 10:24:20', '2020-09-03 20:26:42', 1, 48, 20);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (5, 'Fengmu', 'Luchegorsk', '2020-06-20 19:33:06', '2020-07-22 12:24:19', 5, 40, 30);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (6, 'Esil', 'Okinawa', '2020-07-28 22:40:31', '2020-12-14 14:47:39', 9, 11, 16);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (7, 'Thị Trấn Yên Thịnh', 'Montenegro', '2021-03-26 13:47:22', '2021-02-16 01:34:20', 9, 40, 30);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (8, 'Yanmenkou', 'Itaparica', '2021-04-22 10:35:36', '2021-04-07 10:42:39', 1, 6, 28);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (9, 'Huangge', 'Nnewi', '2021-01-17 00:05:52', '2020-09-15 22:37:55', 5, 39, 26);
insert into rides (id, start_location, end_location, start_date, end_date, driver_id, price, landing_sites) values (10, 'Quiaios', 'Lidong', '2020-10-11 14:39:39', '2020-06-07 13:05:26', 4, 19, 22);


#Orders
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (1, 1, 20, 2, 8, 'CAME', '2020-08-04 12:38:36');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (2, 5, 14, 1, 14, 'CAME', '2020-08-17 23:50:04');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (3, 1, 11, 1, 16, 'CAME', '2021-04-29 02:14:39');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (4, 1, 19, 4, 14, 'CAME', '2020-12-24 13:56:42');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (5, 9, 19, 8, 5, 'DID_NOT_COME', '2020-11-12 07:57:12');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (6, 10, 11, 5, 14, 'DID_NOT_COME', '2020-05-20 15:04:46');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (7, 2, 13, 2, 18, 'DID_NOT_COME', '2021-02-21 03:13:51');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (8, 6, 15, 7, 17, 'UNDEFINED', '2020-09-10 03:12:56');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (9, 4, 11, 1, 5, 'UNDEFINED', '2021-04-05 14:01:17');
insert into orders (id, ride_id, client_id, payment_id, sites, result, create_date) values (10, 1, 15, 6, 11, 'CAME', '2020-10-13 06:31:44');
