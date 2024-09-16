-- 1) Create table Users

CREATE TABLE public.users
(
    id text,
    login text,
    password text,
    role text,
    CONSTRAINT users_id PRIMARY KEY (id),
    CONSTRAINT users_login UNIQUE (login)
);

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

-- 2) Create table Situ 

CREATE TABLE public.situ
(
    codigo integer,
    descricao text,
    CONSTRAINT estabelecimento_situacao_cadastral PRIMARY KEY (codigo)
);

ALTER TABLE IF EXISTS public.situ
    OWNER to postgres;

INSERT INTO public.situ(
	codigo, descricao)
	VALUES (1, 'Nula'),
	(2, 'Ativa'),
	(3, 'Suspensa'),
	(4, 'Inapta'),
	(5, 'Baixada');

-- 3) Create table Identificador Socio

CREATE TABLE public.identificador_socio
(
    codigo integer,
    descricao text,
    CONSTRAINT socios_identificador_fk PRIMARY KEY (codigo)
);

ALTER TABLE IF EXISTS public.identificador_socio
    OWNER to postgres;

INSERT INTO public.identificador_socio(
	codigo, descricao)
	VALUES (1, 'Pessoa Jurídica'),
	(2, 'Pessoa Física'),
	(3, 'Estrangeiro');

-- 4) Create table Porte

CREATE TABLE public.porte
(
    codigo integer,
    descricao text,
    CONSTRAINT empresa_porte_empresa PRIMARY KEY (codigo)
);

ALTER TABLE IF EXISTS public.porte
    OWNER to postgres;

INSERT INTO public.porte(
	codigo, descricao)
	VALUES (1, 'Não Informado'),
	(2, 'Micro Empresa'),
	(3, 'Empresa de Pequeno Porte'),
	(5, 'Demais');

-- 5) Create table Faixa Etária

CREATE TABLE public.faixa_etaria
(
    codigo integer,
    descricao text,
    CONSTRAINT faixa_etaria_codigo PRIMARY KEY (codigo)
);

ALTER TABLE IF EXISTS public.faixa_etaria
    OWNER to postgres;

INSERT INTO public.faixa_etaria(
	codigo, descricao)
	VALUES (1, '0 a 12 anos'),
	(2, '13 a 20 anos'),
	(3, '21 a 30 anos'),
	(4, '31 a 40 anos'),
	(5, '41 a 50 anos'),
	(6, '51 a 60 anos'),
	(7, '61 a 70 anos'),
	(8, '71 a 80 anos'),
	(9, 'Maiores de 80 anos'),
	(0, 'Não se aplica');

-- 6) Create table identificador Matriz Filial

CREATE TABLE public.identificado_matriz_filial
(
    codigo integer,
    descricao text,
    CONSTRAINT identificador_matriz_filial_codigo PRIMARY KEY (codigo)
);

ALTER TABLE IF EXISTS public.identificado_matriz_filial
    OWNER to postgres;

INSERT INTO public.identificado_matriz_filial(
	codigo, descricao)
	VALUES (1, 'Matriz'),
	(2, 'Filial');
