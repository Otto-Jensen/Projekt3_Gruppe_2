DROP DATABASE IF EXISTS Biludlejning;

CREATE DATABASE Biludlejning;

USE Biludlejning;

CREATE TABLE costumer(
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         costumer_name VARCHAR(255),
                         phoneNumber INT,
                         Email VARCHAR(255)
);


CREATE TABLE damageReport(
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             inspection_date DATE,
                             priceTotal INT
);

CREATE TABLE damage(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       damageDescription VARCHAR(255),
                       price INT,
                       damageReport_id INT,
                       FOREIGN KEY (damageReport_id) REFERENCES damageReport(id)
);

CREATE TABLE rentalAgreement(
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                startDate DATE,
                                endDate DATE,
                                pice INT,
                                pickup VARCHAR(255),
                                costumer_id INT,
                                FOREIGN KEY (costumer_id) REFERENCES costumer(id)
);

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

INSERT INTO car (cartNumber, vin, brand, model, color, car_status, rentalAgreement_id, damageReport_id)
VALUES ('CD67890', 'VIN0987654321', 'Ford', 'Focus', 'Blue', 'AVAILABLE', NULL, NULL),
       ('AB12345', 'VIN1234567890', 'Toyota', 'Yaris', 'Red', 'AVAILABLE', NULL, NULL);