CREATE DATABASE LojaVirtual;

USE LojaVirtual;

CREATE TABLE Cliente (
	cpf 	VARCHAR(20) PRIMARY KEY,
	nome	VARCHAR(255),
	email	VARCHAR(255)
);

CREATE TABLE Curso (
	curso 	VARCHAR(20) PRIMARY KEY,
	nome	VARCHAR(255),
	valor	VARCHAR(255),
    site	VARCHAR(255)
);

CREATE TABLE Pagamento (
	pgId	VARCHAR(275),
	cpf 	VARCHAR(20),
	curso	VARCHAR(255),
	dtInscricao	VARCHAR(255),
    PRIMARY KEY(pgId)
);