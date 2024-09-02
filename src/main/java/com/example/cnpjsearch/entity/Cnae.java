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

@Table(name= "cnae") 
@Entity(name="cnae") 
@Getter
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(of="codigo")

public class Cnae implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;
    private String descricao;
}
