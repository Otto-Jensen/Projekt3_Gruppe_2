DROP DATABASE IF EXISTS Biludlejning;

CREATE DATABASE Biludlejning;

USE Biludlejning;

CREATE TABLE costumer(
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         costumer_name VARCHAR(255),
                         phoneNumber INT,
                         Email VARCHAR(255)
);
INSERT INTO costumer (costumer_name, phoneNumber, Email) VALUES ('Anders Jensen', 12345678, 'anders@gmail.com');
INSERT INTO costumer (costumer_name, phoneNumber, Email) VALUES ('Maria Nielsen', 87654321, 'maria@gmail.com');

CREATE TABLE damageReport(
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             inspection_date DATE,
                             priceTotal INT
);

INSERT INTO damageReport (inspection_date, priceTotal) VALUES ('2026-01-15', 5000);
INSERT INTO damageReport (inspection_date, priceTotal) VALUES ('2026-02-20', 12000);
INSERT INTO damageReport (inspection_date, priceTotal) VALUES ('2026-03-10', 3500);

CREATE TABLE damage(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       damageDescription VARCHAR(255),
                       price INT,
                       damageReport_id INT,
                       FOREIGN KEY (damageReport_id) REFERENCES damageReport(id)
);

INSERT INTO damage (damageDescription, price, damageReport_id) VALUES ('Ridse på førerdør', 1500, 1);
INSERT INTO damage (damageDescription, price, damageReport_id) VALUES ('Knust bagspejl', 3500, 1);
INSERT INTO damage (damageDescription, price, damageReport_id) VALUES ('Bulet kofanger', 8000, 2);
INSERT INTO damage (damageDescription, price, damageReport_id) VALUES ('Ridse på motorhjelm', 4000, 2);
INSERT INTO damage (damageDescription, price, damageReport_id) VALUES ('Sprækket forrude', 3500, 3);

CREATE TABLE rentalAgreement(
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                startDate DATE,
                                endDate DATE,
                                price INT,
                                pickup VARCHAR(255),
                                costumer_id INT,
                                FOREIGN KEY (costumer_id) REFERENCES costumer(id)
);

INSERT INTO rentalAgreement (startDate, endDate, price, pickup, costumer_id) VALUES ('2026-01-01', '2026-01-08', 2099, 'ADRESS1', 1);
INSERT INTO rentalAgreement (startDate, endDate, price, pickup, costumer_id) VALUES ('2026-02-15', '2026-03-15', 6499, 'ADRESS2', 2);

CREATE TABLE car(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    cartNumber VARCHAR(200) NOT NULL,
                    vin VARCHAR(200) NOT NULL,
                    brand VARCHAR(200) NOT NULL,
                    model VARCHAR (200) NOT NULL,
                    color VARCHAR (100) NOT NULL,
                    car_status  VARCHAR(20),
                    rentalAgreement_id INT,
                    FOREIGN KEY (rentalAgreement_id) references rentalAgreement(id),
                    damageReport_id INT,
                    FOREIGN KEY (damageReport_id) references damageReport(id)
);

INSERT INTO car (id, cartNumber, vin, brand, model, color, car_status, rentalAgreement_id, damageReport_id)
VALUES (1, 'CD67890', 'VIN0987654321', 'Ford', 'Focus', 'Blue', 'AVAILABLE', NULL, NULL),
       (2, 'AB12345', 'VIN1234567890', 'Toyota', 'Yaris', 'Red', 'AVAILABLE', NULL, NULL);

UPDATE car SET rentalAgreement_id = 1, car_status = 'RENTED' WHERE id = 1;
UPDATE car SET rentalAgreement_id = 2, damageReport_id = 1, car_status = 'RENTED' WHERE id = 2;