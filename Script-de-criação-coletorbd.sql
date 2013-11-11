--
-- PostgreSQL database coletorbd
--

SET statement_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

DROP TABLE IF EXISTS aeroporto CASCADE;
DROP TABLE IF EXISTS aeronave CASCADE;
DROP TABLE IF EXISTS rota CASCADE;
DROP TABLE IF EXISTS rota_has_aeroporto CASCADE;
DROP TABLE IF EXISTS observacao CASCADE;

CREATE TABLE aeroporto (
                prefixo VARCHAR,
                nome VARCHAR,
                cidade VARCHAR,
                pais VARCHAR,
                latitude DOUBLE PRECISION,
                longitude DOUBLE PRECISION,
                altitude DOUBLE PRECISION,
                CONSTRAINT prefixo PRIMARY KEY (prefixo)
);


CREATE TABLE aeronave (
                hex VARCHAR,
                companhia VARCHAR,
                modelo_aeronave VARCHAR,
                CONSTRAINT hex PRIMARY KEY (hex)
);


CREATE TABLE rota (
                id_rota VARCHAR,
                hex VARCHAR,
                prefixo_aeroporto_saida VARCHAR,
                prefixo_aeroporto_chegada VARCHAR,
                CONSTRAINT id_rota PRIMARY KEY (id_rota, hex)
);


CREATE TABLE rota_has_aeroporto (
                id_rota VARCHAR,
                hex VARCHAR,
                prefixo VARCHAR,
                sequencial INTEGER,
                CONSTRAINT rota_id_rota PRIMARY KEY (id_rota, hex, prefixo)
);


CREATE TABLE observacao (
                id_observacao INTEGER,
                radar VARCHAR,
                latitude DOUBLE PRECISION,
                longitude DOUBLE PRECISION,
                altitude DOUBLE PRECISION,
                velocidade INTEGER,
                angulo INTEGER,
                hora TIMESTAMP,
                id_rota VARCHAR,
                hex VARCHAR,
                CONSTRAINT id_observacao PRIMARY KEY (id_observacao)
);


ALTER TABLE rota ADD CONSTRAINT aeroporto_rota_fk
FOREIGN KEY (prefixo_aeroporto_saida)
REFERENCES aeroporto (prefixo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE rota ADD CONSTRAINT aeroporto_rota_fk1
FOREIGN KEY (prefixo_aeroporto_chegada)
REFERENCES aeroporto (prefixo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE rota_has_aeroporto ADD CONSTRAINT aeroporto_rota_has_aeroporto_fk
FOREIGN KEY (prefixo)
REFERENCES aeroporto (prefixo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE rota ADD CONSTRAINT aeronave_rota_fk
FOREIGN KEY (hex)
REFERENCES aeronave (hex)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE observacao ADD CONSTRAINT rota_observacao_fk
FOREIGN KEY (id_rota, hex)
REFERENCES rota (id_rota, hex)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE rota_has_aeroporto ADD CONSTRAINT rota_rota_has_aeroporto_fk
FOREIGN KEY (id_rota, hex)
REFERENCES rota (id_rota, hex)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

CREATE SEQUENCE id_observacao_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE id_observacao_seq OWNED BY observacao.id_observacao;
ALTER TABLE ONLY observacao ALTER COLUMN id_observacao SET DEFAULT nextval('id_observacao_seq'::regclass);
SELECT pg_catalog.setval('id_observacao_seq', 0, false);
