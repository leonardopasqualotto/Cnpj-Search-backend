package com.example.cnpjsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cnpjsearch.entity.Cnae;

public interface CnaeRepository extends JpaRepository<Cnae, Integer> {
}