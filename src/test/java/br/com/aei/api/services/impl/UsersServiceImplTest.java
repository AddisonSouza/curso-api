package br.com.aei.api.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;
import br.com.aei.api.domain.Users;
import br.com.aei.api.domain.dto.UsersDTO;
import br.com.aei.api.repositories.UsersRepository;

@SpringBootTest
public class UsersServiceImplTest {

    private static final String PASSWORD = "123";
    private static final String EMAIL    = "valdir@email.com";
    private static final String NAME     = "valdir";
    private static final Integer ID      = 1;

    @InjectMocks    
    private UsersServiceImpl service;

    @Mock
    private UsersRepository repository;

    @Mock
    private ModelMapper mapper;

    private Users users;
    private UsersDTO usersDTO;
    private Optional<Users> optionalUser;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        Users response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Users.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void testCreate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testUpdate() {

    }

    private void startUser() {
        users = new Users(ID, NAME, EMAIL, PASSWORD);
        usersDTO = new UsersDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new Users(ID, NAME, EMAIL, PASSWORD)); 
    }
}
