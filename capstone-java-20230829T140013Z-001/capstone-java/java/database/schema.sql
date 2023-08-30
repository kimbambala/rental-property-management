BEGIN TRANSACTION;

DROP TABLE IF EXISTS  property, renter, landlord, users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE landlord (
    landlord_id SERIAL,
    user_id int NOT NULL,
    landlord_first_name varchar(50) NOT NULL,
    landlord_last_name varchar(50) NOT NULL,
    landlord_phone varchar(50) NOT NULL,
    landlord_email varchar(50) NOT NULL,
    CONSTRAINT PK_landlord PRIMARY KEY (landlord_id),
    CONSTRAINT FK_landlord FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE renter(
    renter_id SERIAL,
    user_id int NOT NULL,
    renter_first_name varchar(50) NOT NULL,
    renter_last_name varchar(50) NOT NULL,
    renter_phone varchar(50) NOT NULL,
    renter_email varchar(50) NOT NULL,
    CONSTRAINT PK_renter PRIMARY KEY (renter_id),
    CONSTRAINT FK_renter FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE property (
    property_id SERIAL,
    landlord_id int NOT NULL,
    renter_id int,
    bedrooms int NOT NULL,
    bathrooms int NOT NULL,
    property_type varchar(20) NOT NULL,
    price int  NOT NULL,
    address varchar(100) NOT NULL,
    availability boolean NOT NULL,
    property_desc varchar(2000) NOT NULL,
    property_img varchar(500) NOT NULL,
    CONSTRAINT PK_property PRIMARY KEY (property_id),
    CONSTRAINT FK_landlord FOREIGN KEY (landlord_id) REFERENCES landlord(landlord_id)
);



COMMIT TRANSACTION;