1. CREATE DATABASE HotelManagement;

2. CREATE TABLE HOTEL (hotel_id INT NOT NULL AUTO_INCREMENT , hotel_name VARCHAR(50) NOT NULL , city VARCHAR(30) NOT NULL 
, number_of_rooms INT NOT NULL , tariff INT NOT NULL , PRIMARY KEY(hotel_id));

3. CREATE TABLE HOTEL_BOOKING (hotel_id INT NOT NULL, checkin_date DATE NOT NULL, checkout_date DATE NOT NULL , rooms_booked INT NOT NULL, 
   booking_ref_number VARCHAR(30) NOT NULL , booking_date DATE,  amount_tobe_paid INT, 
   booking_id INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(booking_id), FOREIGN KEY (hotel_id) REFERENCES HOTEL (hotel_id));

4. 

INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('The Oberoi', 10 ,  'Bangalore' ,10890);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('JW Marriott',10  ,          'Bangalore'  ,        12100);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Fairfield by Marriott',10   ,         'Bangalore'   ,        5200);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Iris',  5     ,       'Bangalore'     ,       5064);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Vivanta by Taj' ,  8     ,       'Bangalore'     ,       9600);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('DoubleTree Suites' ,10      ,      'Bangalore'      ,      6920);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Hyatt Bangalore',6       ,     'Bangalore'       ,     6650);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('The Leela', 10       ,    'Bangalore'        ,    8400);

INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Metropolis',10,            'Mumbai' ,              5260);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Trident Nariman Point',10 ,           'Mumbai'  ,             12901);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Ecotel The Orchid' ,10  ,          'Mumbai'   ,             5731);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Treebo Archana Residency', 6   ,         'Mumbai'    ,            3086);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Parle International', 5    ,        'Mumbai'     ,           3229);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Courtyard'      ,10     ,       'Mumbai'      ,          8200);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Treebo Seven' ,  8       ,      'Mumbai'       ,         3300);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('The Regenza' ,  10       ,     'Mumbai'        ,        4086);
INSERT INTO HOTEL (hotel_name, number_of_rooms, city,  tariff) VALUES ('Sofitel'    ,  10        ,    'Mumbai'         ,       10000);

commit;

6. 



