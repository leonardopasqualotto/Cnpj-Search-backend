package com.example.cnpjsearch.dto;

import java.util.List;

import com.example.cnpjsearch.entity.Cnae;
import com.example.cnpjsearch.entity.Estabelecimento;

import lombok.Getter;

@Getter

public class EstabelecimentoDTO {
    private Estabelecimento e;
    private List<Cnae> cnaes;


    public EstabelecimentoDTO(Estabelecimento e, List<Cnae> cnaes){
        this.e = e;
        this.cnaes = cnaes;
    }
    public EstabelecimentoDTO(Estabelecimento e){
        this.e = e;
    }
}
