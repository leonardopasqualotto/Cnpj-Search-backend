

ALTER TABLE IF EXISTS public.simples
    ADD CONSTRAINT simples_cnpj_basico PRIMARY KEY (cnpj_basico);

ALTER TABLE IF EXISTS public.moti
    ADD CONSTRAINT moti_codigo PRIMARY KEY (codigo);

ALTER TABLE IF EXISTS public.munic
    ADD CONSTRAINT munic_codigo PRIMARY KEY (codigo);

ALTER TABLE IF EXISTS public.pais
    ADD CONSTRAINT pais_codigo PRIMARY KEY (codigo);

ALTER TABLE IF EXISTS public.quals
    ADD CONSTRAINT quals_codigo PRIMARY KEY (codigo);

ALTER TABLE IF EXISTS public.natju
    ADD CONSTRAINT natju_codigo PRIMARY KEY (codigo);

ALTER TABLE IF EXISTS public.cnae
    ADD CONSTRAINT cnae_codigo PRIMARY KEY (codigo);

DELETE FROM public.empresa
	WHERE cnpj_basico = '07947717';

DELETE FROM public.empresa
	WHERE cnpj_basico = '08725575';

ALTER TABLE IF EXISTS public.socios
    ADD COLUMN id integer;

ALTER TABLE nome_da_tabela ADD COLUMN id SERIAL;

ALTER TABLE IF EXISTS public.socios
    ADD PRIMARY KEY (id);

ALTER TABLE IF EXISTS public.empresa
    ADD CONSTRAINT empresa_cnpj_basico PRIMARY KEY (cnpj_basico);