

ALTER TABLE IF EXISTS public.estabelecimento
    ADD COLUMN cnpj text;

UPDATE public.estabelecimento
    SET cnpj = cnpj_basico || cnpj_ordem || cnpj_dv;

ALTER TABLE estabelecimento
DROP COLUMN cnpj_ordem;

ALTER TABLE estabelecimento
DROP COLUMN cnpj_dv;

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelec_cnpj PRIMARY KEY (cnpj);