CREATE TABLE Organizador(
	ORG_CPFCNPJ int,
	ORG_NOME varchar(100),
	ORG_EMAIL varchar(100),
	ORG_TELEFONE int,
	primary key(ORG_CPFCNPJ)
);

CREATE TABLE Evento(
	EVE_ID int,
	EVE_NOME varchar(100),
	EVE_DESCRICAO varchar(250),
	EVE_DATA varchar(30),
	EVE_LOCAL varchar (60),
	FK_ORG_CPFCNPJ int,
	foreign key(FK_ORG_CPFCNPJ) references Organizador(ORG_CPFCNPJ),
	primary key(EVE_ID)
);


