DROP TABLE IF EXISTS commons_schema.municipio;
DROP TABLE IF EXISTS commons_schema.bairro;
DROP TABLE IF EXISTS commons_schema.cep;

DROP VIEW IF EXISTS commons_schema.municipio;
DROP VIEW IF EXISTS commons_schema.bairro;
DROP VIEW IF EXISTS commons_schema.cep;

CREATE VIEW commons_schema.municipio AS SELECT municipio.id, municipio.version, municipio.situacao, municipio.nome, municipio.ibge_id, municipio.uf FROM localidade_schema.municipio;
CREATE VIEW commons_schema.bairro AS SELECT bairro.id, bairro.version, bairro.situacao, bairro.nome, bairro.municipio_id FROM localidade_schema.bairro;
CREATE VIEW commons_schema.cep AS SELECT cep.id, cep.version, cep.logradouro, cep.numero, cep.bairro_id, cep.municipio_id FROM localidade_schema.cep;