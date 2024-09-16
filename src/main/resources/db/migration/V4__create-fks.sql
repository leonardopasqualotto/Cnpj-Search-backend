ALTER TABLE pais
ALTER COLUMN codigo TYPE text
USING codigo::text;

ALTER TABLE estabelecimento
ALTER COLUMN cnae_fiscal_principal TYPE text
USING cnae_fiscal_principal::text;

-- 1) Create FK cnae_fiscal_primario on table estabelecimento
ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_cnae_fiscal_primario_fk FOREIGN KEY (cnae_fiscal_principal)
    REFERENCES public.cnae (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_estabelecimento_cnae_fiscal_primario_fk
    ON public.estabelecimento(cnae_fiscal_principal);

-- 2) Create FK identificado_matriz_filial on table estabelecimento

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_identificado_matriz_filial_fk FOREIGN KEY (identificador_matriz_filial)
    REFERENCES public.identificado_matriz_filial (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_estabelecimento_identificado_matriz_filial_fk
    ON public.estabelecimento(identificador_matriz_filial);

-- 3) Create FK cnpj_basico on table estabelecimento

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_cnpj_basico_fk FOREIGN KEY (cnpj_basico)
    REFERENCES public.simples (cnpj_basico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_estabelecimento_cnpj_basico_fk
    ON public.estabelecimento(cnpj_basico);

-- 4) Create FK identificado_socios on table socios

ALTER TABLE IF EXISTS public.socios
    ADD CONSTRAINT socios_identificador_socios_fk FOREIGN KEY (identificador_socio)
    REFERENCES public.identificador_socio (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_i
    ON public.socios(identificador_socio);

-- 5) Create FK porte on table empresa

ALTER TABLE IF EXISTS public.empresa
    ADD CONSTRAINT empresa_porte_fk FOREIGN KEY (porte_empresa)
    REFERENCES public.porte (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_empresa_porte_fk
    ON public.empresa(porte_empresa);

-- 6) Create FK motivo on table estabelecimento

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_motivo_fk FOREIGN KEY (motivo_situacao_cadastral)
    REFERENCES public.moti (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_estabelecimento_motivo_fk
    ON public.estabelecimento(motivo_situacao_cadastral);

-- 7) Create FK situacao_cadastral on table estabelecimento

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_situacao_cadastral_fk FOREIGN KEY (situacao_cadastral)
    REFERENCES public.situ (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS estabelecimento_situacao_cadastral_fk
    ON public.estabelecimento(situacao_cadastral);

-- 8) Create FK faixa_etaria on table socios

ALTER TABLE IF EXISTS public.socios
    ADD CONSTRAINT socios_faixa_etaria_fk FOREIGN KEY (faixa_etaria)
    REFERENCES public.faixa_etaria (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_f
    ON public.socios(faixa_etaria);

-- 9) Create FK pais on table estabelecimento

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_pais_fk FOREIGN KEY (pais)
    REFERENCES public.pais (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_estabelecimento_pais_fk
    ON public.estabelecimento(pais);

-- 10) Create FK pais on municipio estabelecimento

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_municipio FOREIGN KEY (municipio)
    REFERENCES public.munic (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_m
    ON public.estabelecimento(municipio);

-- 11) Create FK cnpj_basico para empresa on table em estabelecimento

ALTER TABLE IF EXISTS public.estabelecimento
    ADD CONSTRAINT estabelecimento_cnpj_basico_empresa_fk FOREIGN KEY (cnpj_basico)
    REFERENCES public.empresa (cnpj_basico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_c
    ON public.estabelecimento(cnpj_basico);

-- 12) Create FK natureza_juridica on table empresa

ALTER TABLE IF EXISTS public.empresa
    ADD CONSTRAINT empresa_nature_juridica_fk FOREIGN KEY (natureza_juridica)
    REFERENCES public.natju (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_empresa_nature_juridica_fk
    ON public.empresa(natureza_juridica);

-- 13) Create FK qualificacao_responsavel on table empresa

ALTER TABLE IF EXISTS public.empresa
    ADD CONSTRAINT empresa_qualificacao_responsavel_fk FOREIGN KEY (qualificacao_responsavel)
    REFERENCES public.quals (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_empresa_qualificacao_responsavel_fk
    ON public.empresa(qualificacao_responsavel);

-- 14) Create FK cnpj_basico on table socios

ALTER TABLE IF EXISTS public.socios
    ADD CONSTRAINT socios_cnpj_basicos FOREIGN KEY (cnpj_basico)
    REFERENCES public.empresa (cnpj_basico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_c
    ON public.socios(cnpj_basico);

-- 15) Create FK qualificacao_socio on table socios

ALTER TABLE IF EXISTS public.socios
    ADD CONSTRAINT socios_qualificacao_socio FOREIGN KEY (qualificacao_socio)
    REFERENCES public.quals (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_socios_qualificacao_socio
    ON public.socios(qualificacao_socio);

-- 16) Create FK qualificacao_representante_legal on table socios

ALTER TABLE IF EXISTS public.socios
    ADD CONSTRAINT socios_qualificacao_representante_legal FOREIGN KEY (qualificacao_representante_legal)
    REFERENCES public.quals (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX IF NOT EXISTS fki_socios_qualificacao_representante_legal
    ON public.socios(qualificacao_representante_legal);