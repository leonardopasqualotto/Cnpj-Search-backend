package com.example.cnpjsearch.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cnpjsearch.dto.EstabelecimentoDTO;
import com.example.cnpjsearch.entity.Cnae;
import com.example.cnpjsearch.entity.Estabelecimento;
import com.example.cnpjsearch.exception.EstabelecimentoNotFoudException;
import com.example.cnpjsearch.repository.CnaeRepository;
import com.example.cnpjsearch.repository.EstabelecimentoRepository;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/cnpj")

public class CnpjController {
    @Autowired
    private final EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private final CnaeRepository cnaeRepository;

    @GetMapping("/{cnpj}")
    public EstabelecimentoDTO getInformacoesPorCnpj( @PathVariable String cnpj){
        Estabelecimento estabelecimento =  estabelecimentoRepository.findById(cnpj).orElseThrow(()-> new EstabelecimentoNotFoudException(cnpj));
         
        if(estabelecimento.getCnae_fiscal_secundaria() != null){
            String[] cnaeCodes = estabelecimento.getCnae_fiscal_secundaria().split(",");
           
            List<Integer> codes = Arrays.stream(cnaeCodes).map(Integer::parseInt).collect(Collectors.toList());
            List<Cnae> cnaes = cnaeRepository.findAllById(codes); 
            EstabelecimentoDTO e = new EstabelecimentoDTO(estabelecimento,cnaes);
            return e;
        }
        return new EstabelecimentoDTO(estabelecimento); 
    }   

}
