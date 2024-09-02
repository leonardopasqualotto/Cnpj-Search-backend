package com.example.cnpjsearch.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="socios")
@Entity(name="socios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Socio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   
    private String cnpj_basico;
    private String identificador_socio;
    private String nome_socio_razao_social;
    private String cpf_cnpj_socio;
    private String data_entrada_sociedade;
    private String pais;
    private String representante_legal;
    private String nome_do_representante;
    private String faixa_etaria;
    
    @ManyToOne
    @JoinColumn(name = "qualificacao_representante_legal", referencedColumnName = "codigo")
    private QualificacaoResponsavel qualificacao_representante_legal;

    @ManyToOne
    @JoinColumn(name = "qualificacao_socio", referencedColumnName = "codigo")
    private QualificacaoResponsavel qualificacao_socio;

}
