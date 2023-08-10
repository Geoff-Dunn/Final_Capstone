BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS volunteersignup;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE pets (
	pet_id SERIAL,
	pet_name varchar(50) NOT NULL UNIQUE,
	species varchar (10) NOT NULL,
	sex varchar (10) NOT NULL,
	age varchar (20) NOT NULL,
	spayed_neutered boolean NOT NULL,
	description varchar (200) NOT NULL,
	picture varchar (200) NOT NULL,
	adopted boolean NOT NULL
);

CREATE TABLE volunteersignup (
	volunteer_id SERIAL,
	name varchar (50) NOT NULL UNIQUE,
	age integer NOT NULL,
	phone_number integer NOT NULL,
	address varchar (50) NOT NULL,
	email varchar (50) NOT NULL,
	is_active boolean
	);

COMMIT TRANSACTION;
