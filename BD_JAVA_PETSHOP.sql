
/*CREATE DATABASE petshop;*/
USE petshop;

-- Tabela para informações básicas dos pets
CREATE TABLE Cadastro_Pets (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nomePet VARCHAR(60) NOT NULL,
    especie VARCHAR(15) NOT NULL,
    raca VARCHAR(20),
    sexo VARCHAR(5) NOT NULL,
    idade CHAR(7),
    cor VARCHAR(30),
    peso VARCHAR(5),
    caracteristicas VARCHAR(70),
    nomeTutor VARCHAR(60) NOT NULL,
    contato VARCHAR(15) NOT NULL,
    num_cpf VARCHAR(15) UNIQUE NOT NULL,
    endereco VARCHAR(50),
    historico_vacinacao VARCHAR(100),
    medicamentos_uso VARCHAR(100),
    alergias VARCHAR(100),
    hist_doencas_cond_medicas VARCHAR(100)
);

ALTER TABLE Cadastro_Pets AUTO_INCREMENT = 1000;
SELECT * FROM Cadastro_Pets;
DROP TABLE Cadastro_Pets;

ALTER TABLE Info_Tutores_Pet AUTO_INCREMENT = 1000;

-- Tabela para informações básicas dos pets
CREATE TABLE Cadastro_Pets (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nomePet VARCHAR(60) NOT NULL,
    especie VARCHAR(15) NOT NULL,
    raca VARCHAR(7),
    sexo VARCHAR(5) NOT NULL,
    idade CHAR(7),
    cor VARCHAR(10),
    peso VARCHAR(5),
    caracteristicas VARCHAR(70),
    tutor_id INT NOT NULL
);

-- Tabela para informações de saúde dos pets
CREATE TABLE Info_Saude_Pet (
    pet_id INT NOT NULL,
    historico_vacinacao VARCHAR(100),
    medicamentos_uso VARCHAR(100),
    alergias VARCHAR(100),
    hist_doencas_cond_medicas VARCHAR(100)
);

-- Tabela para informações dos tutores
CREATE TABLE Info_Tutores_Pet (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nomeTutor VARCHAR(60) NOT NULL,
    contato VARCHAR(15) NOT NULL,
    num_cpf VARCHAR(15) UNIQUE NOT NULL,
    endereco VARCHAR(50),
    pet_id INT NOT NULL
);


ALTER TABLE Cadastro_Pets ADD CONSTRAINT `C_TUTORES_FK` FOREIGN KEY (tutor_id) REFERENCES Info_Tutores_Pet(id) ;
ALTER TABLE Info_Saude_Pet ADD CONSTRAINT `C_PETS_MEDIC_FK` FOREIGN KEY (pet_id) REFERENCES Cadastro_Pets (id);
ALTER TABLE Info_Tutores_Pet ADD CONSTRAINT `C_PETS_FK` FOREIGN KEY (pet_id) REFERENCES Cadastro_Pets (id);

use petshop;
SELECT * FROM Cadastro_Pets;
SELECT * FROM Info_Saude_Pet;
SELECT * FROM Info_Tutores_Pet;

DROP TABLE Cadastro_Pets;
DROP TABLE Info_Saude_Pet;
DROP TABLE Info_Tutores_Pet;
ALTER TABLE Cadastro_Pets DROP FOREIGN KEY NOME_FOREIGN_KEY;
