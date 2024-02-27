package br.com.aei.api.services;

import java.util.List;

import br.com.aei.api.domain.Users;

public interface UsersService {

    Users findById(Integer id);
    List<Users> findAll();
}
