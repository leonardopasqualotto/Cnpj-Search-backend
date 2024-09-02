package com.example.cnpjsearch.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cnpjsearch.entity.Empresa;
import com.example.cnpjsearch.entity.Estabelecimento;
import com.example.cnpjsearch.entity.Socio;
import com.example.cnpjsearch.exception.EstabelecimentoNotFoudException;
import com.example.cnpjsearch.repository.EstabelecimentoRepository;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/cnpj")

public class CnpjController {
    @Autowired
    private final EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping("/{cnpj}")
    public Estabelecimento getInformacoesPorCnpj( @PathVariable String cnpj){
        Estabelecimento estabelecimento =  estabelecimentoRepository.findById(cnpj).orElseThrow(()-> new EstabelecimentoNotFoudException(cnpj));
        Empresa empresa = estabelecimento.getEmpresa();
        List<Socio> socios = empresa.getSocios();

        if(estabelecimento.getSituacao_cadastral().equals("01"))estabelecimento.setSituacao_cadastral("Nula");
        if(estabelecimento.getSituacao_cadastral().equals("02"))estabelecimento.setSituacao_cadastral("Ativa");
        if(estabelecimento.getSituacao_cadastral().equals("03"))estabelecimento.setSituacao_cadastral("Suspensa");
        if(estabelecimento.getSituacao_cadastral().equals("04"))estabelecimento.setSituacao_cadastral("Inapta");
        if(estabelecimento.getSituacao_cadastral().equals("08"))estabelecimento.setSituacao_cadastral("Baixada");
        if(estabelecimento.getIdentificador_matriz_filial().equals("1"))estabelecimento.setIdentificador_matriz_filial("Matriz");
        if(estabelecimento.getIdentificador_matriz_filial().equals("2"))estabelecimento.setIdentificador_matriz_filial("Filial");
        if(empresa.getPorte_empresa().equals("01"))empresa.setPorte_empresa("Não Informado");
        if(empresa.getPorte_empresa().equals("02"))empresa.setPorte_empresa("Micro Empresa");
        if(empresa.getPorte_empresa().equals("03"))empresa.setPorte_empresa("Empresa de Pequeno Porte");
        if(empresa.getPorte_empresa().equals("05"))empresa.setPorte_empresa("Demais");
         for(int i=0;i<estabelecimento.getEmpresa().getSocios().size();i++){
            if(socios.get(i).getIdentificador_socio().equals("1"))socios.get(i).setIdentificador_socio("Pessoa Jurídica");
            if(socios.get(i).getIdentificador_socio().equals("2"))socios.get(i).setIdentificador_socio("Pessoa Física");
            if(socios.get(i).getIdentificador_socio().equals("3"))socios.get(i).setIdentificador_socio("Estrangeiro");
            String faixaEtaria = socios.get(i).getFaixa_etaria();
            if(faixaEtaria.equals("1"))socios.get(i).setFaixa_etaria("0 a 12 anos");
            if(faixaEtaria.equals("2"))socios.get(i).setFaixa_etaria("13 a 20 anos");
            if(faixaEtaria.equals("3"))socios.get(i).setFaixa_etaria("21 a 30 anos");
            if(faixaEtaria.equals("4"))socios.get(i).setFaixa_etaria("31 a 40 anos");
            if(faixaEtaria.equals("5"))socios.get(i).setFaixa_etaria("41 a 50 anos");
            if(faixaEtaria.equals("6"))socios.get(i).setFaixa_etaria("51 a 60 anos");
            if(faixaEtaria.equals("7"))socios.get(i).setFaixa_etaria("61 a 70 anos");
            if(faixaEtaria.equals("8"))socios.get(i).setFaixa_etaria("71 a 80 anos");
            if(faixaEtaria.equals("9"))socios.get(i).setFaixa_etaria("Maiores de 80 anos");
            if(faixaEtaria.equals("0"))socios.get(i).setFaixa_etaria("Não se aplica");
        }
 
        return estabelecimento;
    }   
}
