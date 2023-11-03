BEGIN TRANSACTION;

DROP TABLE IF EXISTS  property, rent, account, users;
DROP SEQUENCE IF EXISTS seq_account_id, seq_rent_id;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_account_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;

CREATE TABLE account (
	account_id int NOT NULL DEFAULT nextval('seq_account_id'),
	user_id int NOT NULL,
	balance decimal(13, 2) NOT NULL,
	CONSTRAINT PK_account PRIMARY KEY (account_id),
	CONSTRAINT FK_account_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE SEQUENCE seq_rent_id
  INCREMENT BY 1
  START WITH 3001
  NO MAXVALUE;

CREATE TABLE rent (
	rent_id int NOT NULL DEFAULT nextval('seq_rent_id'),
	account_from int NOT NULL,
	account_to int NOT NULL,
	amount decimal(13, 2) NOT NULL,
	CONSTRAINT PK_rent PRIMARY KEY (rent_id),
	CONSTRAINT FK_rent_account_from FOREIGN KEY (account_from) REFERENCES account (account_id),
	CONSTRAINT FK_rent_account_to FOREIGN KEY (account_to) REFERENCES account (account_id),
	CONSTRAINT CK_rent_not_same_account CHECK (account_from <> account_to),
	CONSTRAINT CK_rent_amount_gt_0 CHECK (amount > 0)
);


CREATE TABLE property (
    property_id SERIAL,
    landlord_user_id int NOT NULL,
    renter_user_id int UNIQUE,
    bedrooms int NOT NULL,
    bathrooms int NOT NULL,
    property_type varchar(20) NOT NULL,
    price decimal(13, 2) NOT NULL,
    address varchar(100) NOT NULL,
    availability boolean NOT NULL,
    property_desc varchar(2000) NOT NULL,
    property_img varchar(500) NOT NULL,
    CONSTRAINT PK_property PRIMARY KEY (property_id),
    CONSTRAINT FK_landlord_user_id FOREIGN KEY (landlord_user_id) REFERENCES users (user_id),
    CONSTRAINT FK_renter_user_id FOREIGN KEY (renter_user_id) REFERENCES users (user_id)
);




COMMIT TRANSACTION;