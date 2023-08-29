BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('landlord','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('renter','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');


INSERT INTO landlord (user_id, landlord_first_name, landlord_last_name, landlord_phone, landlord_email) VALUES(3, 'landlordfirst', 'landlordlast', '555-123-4561', 'landlordfirst@email.com');

INSERT INTO renter (user_id, renter_first_name, renter_last_name, renter_phone, renter_email) VALUES(4, 'renterfirst', 'renterlast', '555-852-9639', 'renterfirst@email.com');



INSERT INTO property (landlord_id, renter_id, bedrooms, bathrooms, price, address, availability, property_desc, property_img) VALUES (1, 1, 1, 1, 1000, '123 main street', true, 'Nice one bedroom and 1 bath apartment', 'https://images.unsplash.com/photo-1613575831056-0acd5da8f085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');
INSERT INTO property (landlord_id, bedrooms, bathrooms, price, address, availability, property_desc, property_img) VALUES (1, 1, 1, 1000, '124 main ave', false, 'Nice one bedroom and 1 bath apartment', 'https://images.unsplash.com/photo-1613575831056-0acd5da8f085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');
INSERT INTO property (landlord_id, bedrooms, bathrooms, price, address, availability, property_desc, property_img) VALUES (1, 1, 2, 1500, '123 second street', true, 'Nice one bedroom and 1 bath apartment', 'https://images.unsplash.com/photo-1613575831056-0acd5da8f085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');
INSERT INTO property (landlord_id, bedrooms, bathrooms, price, address, availability, property_desc, property_img) VALUES (1, 2, 1, 2000,  '183 third street', true,'Nice one bedroom and 1 bath apartment', 'https://images.unsplash.com/photo-1613575831056-0acd5da8f085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');
INSERT INTO property (landlord_id, bedrooms, bathrooms, price, address, availability, property_desc, property_img) VALUES (1, 2, 2, 2500, '200 long street', false, 'Nice one bedroom and 1 bath apartment', 'https://images.unsplash.com/photo-1613575831056-0acd5da8f085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');
INSERT INTO property (landlord_id, bedrooms, bathrooms, price, address, availability, property_desc, property_img) VALUES (1, 2, 3, 3000, '457 short street',false, 'Nice one bedroom and 1 bath apartment', 'https://images.unsplash.com/photo-1613575831056-0acd5da8f085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');
INSERT INTO property (landlord_id, bedrooms, bathrooms, price, address, availability, property_desc, property_img) VALUES (1, 3, 3, 3500, '235 orange avenue', true, 'Nice one bedroom and 1 bath apartment', 'https://images.unsplash.com/photo-1613575831056-0acd5da8f085?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80');






COMMIT TRANSACTION;
