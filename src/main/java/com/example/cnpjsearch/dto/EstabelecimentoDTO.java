package com.example.cnpjsearch.dto;

import java.util.List;
import com.example.cnpjsearch.entity.Cnae;
import com.example.cnpjsearch.entity.Empresa;
import com.example.cnpjsearch.entity.EstabelecimentoCnaeRelacionamento;
import com.example.cnpjsearch.entity.Motivo;
import com.example.cnpjsearch.entity.Municipio;
import com.example.cnpjsearch.entity.Pais;
import com.example.cnpjsearch.entity.Simples;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EstabelecimentoDTO(
    @JsonProperty("_cnpj") String cnpj,
    String identificador_matriz_filial,
    String nome_fantasia,
    String situacao_cadastral,
    String data_situacao_cadastral,
    String nome_cidade_exterior,
    String data_inicio_atividade,
    String tipo_logradouro,
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    String cep,
    String uf,
    String ddd_1,
    String telefone_1,
    String ddd_2,
    String telefone_2,
    String ddd_fax,
    String fax,
    String correio_eletronico,
    String situacao_especial,
    String data_situacao_especial,
    Municipio municipio,
    Cnae cnae_fiscal_principal,
    List<EstabelecimentoCnaeRelacionamento> estabelecimento_cnae_relacionamento,
    Pais pais,
    Motivo motivo_situacao_cadastral,
    Empresa empresa,
    Simples simples) {
    
}
