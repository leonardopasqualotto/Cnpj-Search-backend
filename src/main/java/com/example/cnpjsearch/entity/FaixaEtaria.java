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

@Table(name= "faixa_etaria")
@Entity(name="faixa_etaria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="codigo")
public class FaixaEtaria implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String descricao;
}