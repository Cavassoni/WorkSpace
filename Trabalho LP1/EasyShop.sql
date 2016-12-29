create table endereco(
	cod_endereco 	int 			not null,
    cod_cliente		int 			not null,
    bairro 			varchar(90)		not null,
    cidade 			varchar(90)		not null,
    estado 			varchar(90)		not null,
    numero			int				not null,
    complemento		varchar(200),
    primary key(cod_endereco)
);
create table cliente(
	cod_cliente		int 			not null 		primary key,
    cod_preferencia int,
    nome			varchar(90)		not null,
    idade 			int 			not null,
    sexo 			varchar(10)			not null,
	telefone		int 			not null,
    email			varchar(100)	not null,
    cpf				int				not null
);
create table preferencia(
	cod_preferencia	int 			primary key		not null,
    modelo			varchar(90)						not null,
    cor				varchar(30)						not null,
    marca			varchar(30)						not null,
    valor_ate		float
);
create table pedido(
	cod_pedido		int 			not null		primary key,
    cod_cliente		int 			not null,
    cod_produto		int 			not null,
    dt_pedido		date,
    valor_total		float
);
create table produto(
	cod_produto		int 			not null		primary key,
    nome_produto	varchar(90)		not null,
    qtd_estoque		int				not null,
    descricao		varchar(200)	not null,
    valor			float			not null,
    cor				float			not null,
    marca			varchar(30)		not null
);
create table encomenda(
	cod_encomenda	int 			not null		primary key,
    cod_cliente		int 			not null,
    descricao		varchar(200)	not null,
    valor			float			not null
);