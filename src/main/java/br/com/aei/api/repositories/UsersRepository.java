package br.com.aei.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aei.api.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    
}
