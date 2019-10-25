CREATE TABLE Universidade (
	id INTEGER PRIMARY KEY auto_increment,
	nome_fantasia VARCHAR(120) not null,
    sigla VARCHAR(7) not null,
    campus VARCHAR(20) not null,
    cnpj VARCHAR(15) not null,
    endereco VARCHAR(300) not null
);

CREATE TABLE Curso (
	id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    duracao INTEGER NOT NULL
);

CREATE TABLE Turma (
	id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(15) NOT NULL,
    id_universidade INTEGER NOT NULL,
    id_curso INTEGER NOT NULL,
    CONSTRAINT fk_universidade FOREIGN KEY(id_universidade) REFERENCES Universidade(id),
    CONSTRAINT fk_curso FOREIGN KEY(id_curso) REFERENCES Curso(id) 
);

CREATE TABLE Login (
	id INTEGER PRIMARY KEY auto_increment,
    email VARCHAR(50) not null,
    senha VARCHAR(15) not null,
    tipo_acesso INTEGER not null -- 1 - PROF, 2 - ALUNO, 3 - ADMIN
);

CREATE TABLE Professor (
	id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(100) not null,
    rap VARCHAR(15) not null unique,
    email VARCHAR(30) not null unique,
    id_login INTEGER NOT NULL,
    CONSTRAINT fk_login_prof FOREIGN KEY(id_login) REFERENCES Login(id)
);

CREATE TABLE Token_chamada (
	id INTEGER PRIMARY KEY auto_increment,
    token VARCHAR(10) unique,
    ativo boolean
);


CREATE TABLE Materia (
	id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(50) NOT NULL,
    sala VARCHAR(6) NOT NULL,
    id_turma INTEGER NOT NULL,
    id_professor INTEGER NOT NULL,
	CONSTRAINT fk_turma FOREIGN KEY(id_turma) REFERENCES Turma(id),
    CONSTRAINT fk_professor_materia FOREIGN KEY(id_professor) REFERENCES Professor(id)
);

CREATE TABLE Token_materia (
	id INTEGER PRIMARY KEY auto_increment,
    token VARCHAR(10) unique,
    ativo boolean,
    id_materia INTEGER NOT NULL, -- RECEBE MATERIA
     CONSTRAINT fk_materia_token FOREIGN KEY(id_materia) REFERENCES Materia(id)
);

CREATE TABLE Aluno (
	id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(100) not null,
    ra VARCHAR(15) not null unique,
    email VARCHAR(30) not null unique,
    id_login INTEGER NOT NULL,
    CONSTRAINT fk_login_aluno FOREIGN KEY(id_login) REFERENCES Login(id)
);

-- Insert Universidade
INSERT INTO Universidade (nome_fantasia, sigla, campus, cnpj, endereco) VALUES ('Universidade São Judas Tadeu', 'USJT', 'Mooca', '123456789101112', 'Rua Taquari - N° 153');
INSERT INTO Universidade (nome_fantasia, sigla, campus, cnpj, endereco) VALUES ('Universidade Nove de Julho', 'UNN', 'Barra funda', '123456781234567', 'Rua São paulo - N° 13');
INSERT INTO Universidade (nome_fantasia, sigla, campus, cnpj, endereco) VALUES ('Faculdade Metropolitana Unidas', 'FMU', 'Paraíso', '879865412365548', 'Av. Liberdade - N° 899');
INSERT INTO Universidade (nome_fantasia, sigla, campus, cnpj, endereco) VALUES ('Universidade Paulista', 'UNIP', 'Água Branca', '556478552474885', 'Rua Jose Augusto - N° 666');
INSERT INTO Universidade (nome_fantasia, sigla, campus, cnpj, endereco) VALUES ('Universidade Anhembi Morumbi', 'AMB', 'Mooca', '963258741236587', 'Rua Nao sei - N° 777');

-- Insert Curso
INSERT INTO Curso (nome, tipo, duracao) VALUES ('Sistemas de Informação', 'Bacharelado', 8);
INSERT INTO Curso (nome, tipo, duracao) VALUES ('Direito', 'Bacharelado', 10);
INSERT INTO Curso (nome, tipo, duracao) VALUES ('Medicina', 'Médico', 12);
INSERT INTO Curso (nome, tipo, duracao) VALUES ('Psicologia', 'Bacharelado', 8);
INSERT INTO Curso (nome, tipo, duracao) VALUES ('Ánalise e Desenvolvimento de Sistemas', 'Tecnólogo', 5);

-- Insert Turma
INSERT INTO Turma (nome, id_universidade, id_curso) VALUES ('SI1ANMCA1', 1, 1);
INSERT INTO Turma (nome, id_universidade, id_curso) VALUES ('DT2ANMCA2', 1, 2);
INSERT INTO Turma (nome, id_universidade, id_curso) VALUES ('MD3ANCMCA1', 2, 3);
INSERT INTO Turma (nome, id_universidade, id_curso) VALUES ('SI3ANMCA2', 2, 1);
INSERT INTO Turma (nome, id_universidade, id_curso) VALUES ('ADS2ANMCA1', 1, 5);


insert into Login (email,senha,tipo_acesso) values ('mgsantos@gmail.com','matheus', 1);
insert into Login (email,senha,tipo_acesso) values ('santosmg@gmail.com','matheus', 2);
insert into Login (email,senha,tipo_acesso) values ('gsantosm@gmail.com','matheus', 3);

insert into Professor (nome,rap,email,id_login) values ('Matheus Gonçalves', '818146687','mgsantos@gmail.com', 1);

insert into Materia (nome,sala,id_turma, id_professor) values ('matematica','101c',1,1);

