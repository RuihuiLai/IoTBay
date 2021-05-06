/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Reyvaldo
 * Created: Apr 23, 2021
 */

INSERT INTO IOTUSER."USER"(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GENDER, ADDRESS, PHONENUMBER)
VALUES
    ('John', 'Smith', 'john.smith@gmail.com', 'password123', 'male', '15 Broadway Ultimo NSW 2007', '123456789')

INSERT INTO IOTUSER.PRODUCT ("NAME", CATEGORY, PRICE, DESCRIPTION, STOCK) 
    VALUES ('DHT11', 'temperature/humidity', 3.0, 'The DHT11 sensor can measure humidity as well as temperature. Only one GPIO is used. is only able to measure areas of 20-90% humidity and an error margin of 5%.', 5);
INSERT INTO IOTUSER.PRODUCT ("NAME", CATEGORY, PRICE, DESCRIPTION, STOCK) 
    VALUES ('DHT22', 'temperature/humidity', 4.0, 'The DHT22 sensor can measure humidity as well as temperature. Only one GPIO is used. is only able to measure all areas of humidity and an error margin of 2%.', 6 );
INSERT INTO IOTUSER.PRODUCT ("NAME", CATEGORY, PRICE, DESCRIPTION, STOCK) 
    VALUES ('DS18B20', 'temperature', 4.0, 'haha no',7 );
INSERT INTO IOTUSER.PRODUCT ("NAME", CATEGORY, PRICE, DESCRIPTION, STOCK) 
    VALUES ('DS18S20', 'temperature', 4.0, 'haha no', 5);
INSERT INTO IOTUSER.PRODUCT ("NAME", CATEGORY, PRICE, DESCRIPTION, STOCK) 
    VALUES ('BMP180 Barometer', 'air pressure/temperature', 6.0, 'haha no', 5);