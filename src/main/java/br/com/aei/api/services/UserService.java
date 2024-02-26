package br.com.aei.api.services;

import br.com.aei.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
