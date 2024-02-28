package br.com.aei.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    private static final String ID = "/{id}";

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UsersService service;

    @GetMapping(value = ID)
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
            ServletUriComponentsBuilder.fromCurrentRequest().path("/f{id}").buildAndExpand(service.create(obj).getId()).toUri()).build();
    }

    @PutMapping(value = ID)
    public ResponseEntity<UsersDTO> update(@PathVariable Integer id, @RequestBody UsersDTO obj){
        obj.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(obj), UsersDTO.class));
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<UsersDTO> delete(@PathVariable Integer id){
        findById(id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
