package by.bsuir.beltransport.service;

import by.bsuir.beltransport.entity.User;
import by.bsuir.beltransport.exception.EntityAlreadyExistsException;

import java.util.Optional;

public interface UserService {
    Optional<User> findByLoginAndPassword(User user);

    User save(User user) throws EntityAlreadyExistsException;
}
