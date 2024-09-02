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

@Table(name="estabelecimento_cnae_relacionamento") 
@Entity(name="estabelecimento_cnae_relacionamento")
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class EstabelecimentoCnaeRelacionamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne 
    @JoinColumn(name = "codigo_cnae", referencedColumnName = "codigo")
    private Cnae cnae;  
}
