package by.bsuir.beltransport.controller;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.User;
import by.bsuir.beltransport.persistance.ClientRepository;
import by.bsuir.beltransport.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository repository;

    private ClientRepository clientRepository;
    @Autowired
    public UserController(UserRepository repository, ClientRepository clientRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<User> hello(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Client helloById(@PathVariable Integer id){
        return clientRepository.findById(id).get();
    }
}
