package com.example.cnpjsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.cnpjsearch.entity.User;

public interface UserRepository extends JpaRepository<User,String>{
    UserDetails findByLogin(String login);
}
