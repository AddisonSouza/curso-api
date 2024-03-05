package br.com.aei.api.config;

import br.com.aei.api.domain.Users;
import br.com.aei.api.repositories.UsersRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UsersRepository repository;

    @PostConstruct
    public void startDB() {
        Users u1 = new Users(null, "Valdir", "valdir@mail.com", "123");
        Users u2 = new Users(null, "Luiz", "luiz@mail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}