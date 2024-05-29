
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

/*
ALTER TABLE Cadastro_Pets AUTO_INCREMENT = 1000;
SELECT * FROM Cadastro_Pets;
DROP TABLE Cadastro_Pets;
*/
