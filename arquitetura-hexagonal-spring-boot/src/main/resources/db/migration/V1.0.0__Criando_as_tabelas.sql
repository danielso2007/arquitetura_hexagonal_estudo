
-- SEQUENCE: public.endereco_id_seq

-- DROP SEQUENCE IF EXISTS public.endereco_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.endereco_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.endereco_id_seq
    OWNER TO postgres;

-- SEQUENCE: public.usuario_id_seq

-- DROP SEQUENCE IF EXISTS public.usuario_id_seq;

CREATE SEQUENCE IF NOT EXISTS public.usuario_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.usuario_id_seq
    OWNER TO postgres;

-- Table: public.endereco

-- DROP TABLE IF EXISTS public.endereco;

CREATE TABLE IF NOT EXISTS public.endereco
(
    id bigint NOT NULL DEFAULT nextval('endereco_id_seq'::regclass),
    bairro character varying(255) COLLATE pg_catalog."default",
    cep character varying(255) COLLATE pg_catalog."default",
    complemento character varying(255) COLLATE pg_catalog."default",
    ddd character varying(255) COLLATE pg_catalog."default",
    gia character varying(255) COLLATE pg_catalog."default",
    ibge character varying(255) COLLATE pg_catalog."default",
    localidade character varying(255) COLLATE pg_catalog."default",
    logradouro character varying(255) COLLATE pg_catalog."default",
    siafi character varying(255) COLLATE pg_catalog."default",
    uf character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT endereco_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.endereco
    OWNER to postgres;
-- Index: indexenderecocep

-- DROP INDEX IF EXISTS public.indexenderecocep;

CREATE INDEX IF NOT EXISTS indexenderecocep
    ON public.endereco USING btree
    (cep COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;

-- Table: public.usuario

-- DROP TABLE IF EXISTS public.usuario;

CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigint NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    instagram character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    endereco_id bigint,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_endereco FOREIGN KEY (endereco_id)
        REFERENCES public.endereco (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;
