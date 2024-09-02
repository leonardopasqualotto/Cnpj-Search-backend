package com.example.cnpjsearch.dto;

import com.example.cnpjsearch.user.UserRole;

public record RegisterDTO(String login,String password, UserRole role) {

}
