CREATE TABLE Cliente(
    nome varchar(100) NOT NULL,
    cpf char(14) NOT NULL,
    endereco varchar(50) NOT NULL,
    telefone char(14) NOT NULL,
    email varchar(50) NOT NULL,
    dataNascimento char(8) NOT NOT NULL,
    CONSTRAINT "ClientePK" PRIMARY KEY(cpf)

)