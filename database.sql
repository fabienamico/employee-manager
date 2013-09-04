/* CREATION DE LA BASE ET DES TABLES */

DROP DATABASE IF EXISTS employeemanager;

CREATE DATABASE employeemanager;

USE employeemanager;

CREATE TABLE Employe (
	id integer NOT NULL AUTO_INCREMENT,
	login varchar(255),
	nom varchar(255),
	password varchar(255),
	prenom varchar(255),
	equipe_id integer,
	PRIMARY KEY (id)
);

CREATE TABLE Departement (
	id integer NOT NULL AUTO_INCREMENT,
	nom varchar(255),
	responsable_id integer,
	PRIMARY KEY (id)
);

CREATE TABLE Equipe (
	id integer NOT NULL AUTO_INCREMENT,
	nom varchar(255),
	chef_id int(11),
	departement_id integer,
	PRIMARY KEY (id)
);

/* INSERTION DES DONNEES DE TEST */

INSERT INTO Employe VALUES (1,'t.benoit','Benoit','tioneb.t','thomas',2),
	(2,'c.norris','Norris','sirron.c','chuck',NULL),
	(3,'s.stallone','Stallone','enollats.s','sylvester',NULL);

INSERT INTO Departement VALUES (1,'Tartes dans la gueule',2);

INSERT INTO Equipe VALUES (2,'poing fermes',3,1);

/* 	AJOUT DES CLES ETRANGERES */

ALTER TABLE Employe ADD FOREIGN KEY (equipe_id) REFERENCES Equipe (id);
ALTER TABLE Departement ADD FOREIGN KEY (responsable_id) REFERENCES Employe (id);
ALTER TABLE Equipe ADD FOREIGN KEY (chef_id) REFERENCES Employe (id);
ALTER TABLE Equipe ADD FOREIGN KEY (departement_id) REFERENCES Departement (id);