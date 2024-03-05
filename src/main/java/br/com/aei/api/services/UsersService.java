package br.com.aei.api.services;

import java.util.List;

import br.com.aei.api.domain.Users;
import br.com.aei.api.domain.dto.UsersDTO;

public interface UsersService {

    Users findById(Integer id);
    List<Users> findAll();
    Users create(UsersDTO obj);
    Users update(UsersDTO obj);
    void delete(Integer id);
}
