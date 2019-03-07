
/*ALTER TABLE commons_schema.feriado ADD CONSTRAINT feriado_uq1 UNIQUE (objeto_id, operacao_id);
*/

CREATE UNIQUE INDEX feriado_uq_idx1 ON commons_schema.feriado (LOWER(feriado.nome), tipo_feriado);




