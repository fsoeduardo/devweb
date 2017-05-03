
Create Table Esporte (
id integer Not Null,
nome char(15),
Primary Key (id)
)

Create Table Tipo (
id integer Not Null,
nome char(15),
Primary Key (id)
)

Create table Usuario (
id integer Not Null,
nome  varchar(40) Not Null,
senha  varchar(40) Not Null,
email  varchar(40) Not Null,
status boolean Not Null,
localidade  varchar(40) Not Null,
qntvisitante integer,
esporte_id integer Not Null,
Primary Key (id),
FOREIGN KEY (esporte_id) REFERENCES esporte (id)
)


Create table AvaliacaoComposta (
id integer Not Null,
textohospedagem varchar(255) ,
textohospedero  varchar(255) ,
tipo integer Not Null,
nota integer Not Null,
status boolean Not Null,
hospedero_id integer Not Null,
hospedado_id integer Not Null,
Primary Key (id),
FOREIGN KEY (hospedero_id) REFERENCES usuario (id),
FOREIGN KEY (hospedado_id) REFERENCES usuario (id),
FOREIGN KEY (tipo) REFERENCES Tipo (id)
)

Create Table AMIZADE (
user_id integer Not Null,
amigo_id integer Not Null,
Primary Key (amigo_id, user_id)
)

Create table Avaliacao (
id integer Not Null,
text varchar(255) ,
tipo integer Not Null,
nota integer Not Null,
user_faz integer Not Null,
user_recebe integer Not Null,
Primary Key (id),
FOREIGN KEY (user_recebe) REFERENCES usuario (id),
FOREIGN KEY (user_faz) REFERENCES usuario (id),
FOREIGN KEY (tipo) REFERENCES Tipo (id)
)

