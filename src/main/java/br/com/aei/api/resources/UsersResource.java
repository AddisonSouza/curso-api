package br.com.aei.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import br.com.aei.api.domain.dto.UsersDTO;
import br.com.aei.api.services.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {
    
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UsersService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsersDTO> findById(@PathVariable Integer id) {

        return ResponseEntity.ok().body(mapper.map(service.findById(id), UsersDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UsersDTO>>findAll(){
        return ResponseEntity.ok()
                .body(service.findAll()
                        .stream().map(x -> mapper.map(x, UsersDTO.class)).collect(Collectors.toList()));
    }
    @PostMapping
    public ResponseEntity<UsersDTO> create(@RequestBody UsersDTO obj) {
        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri()).build();
    }
}
