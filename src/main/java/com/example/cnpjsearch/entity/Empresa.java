package com.example.cnpjsearch.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="empresa") 
@Entity(name="empresa")
@Getter @Setter
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(of="cnpj_basico")

public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cnpj_basico;

    @ManyToOne 
    @JoinColumn(name = "natureza_juridica", referencedColumnName = "codigo")
    private NaturezaJuridica natureza_juridica;

    @ManyToOne 
    @JoinColumn(name = "porte_empresa", referencedColumnName = "codigo")
    private PorteEmpresa porte_empresa;

    @ManyToOne 
    @JoinColumn(name = "qualificacao_responsavel", referencedColumnName = "codigo")
    private QualificacaoResponsavel qualificacao_responsavel;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpj_basico",referencedColumnName = "cnpj_basico")
    private List<Socio> socios;

    private String razao_social;
    private String ente_federativo_responsavel;
    private double capital_social;
}
