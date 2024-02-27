package br.com.aei.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aei.api.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

    Optional<Users> findByEmail(String email);
    
}
