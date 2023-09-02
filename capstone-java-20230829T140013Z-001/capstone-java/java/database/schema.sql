BEGIN TRANSACTION;

DROP TABLE IF EXISTS  property, users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE property (
    property_id SERIAL,
    landlord_user_id int NOT NULL,
    renter_user_id int UNIQUE,
    bedrooms int NOT NULL,
    bathrooms int NOT NULL,
    property_type varchar(20) NOT NULL,
    price int  NOT NULL,
    address varchar(100) NOT NULL,
    availability boolean NOT NULL,
    property_desc varchar(2000) NOT NULL,
    property_img varchar(500) NOT NULL,
    CONSTRAINT PK_property PRIMARY KEY (property_id),
    CONSTRAINT FK_landlord_user_id FOREIGN KEY (landlord_user_id) REFERENCES users (user_id),
    CONSTRAINT FK_renter_user_id FOREIGN KEY (renter_user_id) REFERENCES users (user_id)
);




COMMIT TRANSACTION;