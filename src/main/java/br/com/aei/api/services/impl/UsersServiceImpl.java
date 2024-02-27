package br.com.aei.api.services.impl;

import java.util.Optional;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aei.api.domain.Users;
import br.com.aei.api.domain.dto.UsersDTO;
import br.com.aei.api.repositories.UsersRepository;
import br.com.aei.api.services.UsersService;
import br.com.aei.api.services.exceptions.ObjectNotFoundException;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Users findById(Integer id) {
        Optional<Users> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users create(UsersDTO obj) {
       return repository.save(mapper.map(obj, Users.class));
    }   
    
}
