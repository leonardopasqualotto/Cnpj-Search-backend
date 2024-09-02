package com.example.cnpjsearch.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name= "simples")
@Entity(name="simples")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="cnpj_basico")

public class Simples implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cnpj_basico;
    private String opcao_pelo_simples;
    private String data_opcao_simples;
    private String data_exclusao_simples;
    private String opcao_mei;
    private String data_opcao_mei;
    private String data_exclusao_mei;   
    
}
