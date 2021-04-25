package by.bsuir.beltransport.service;

import by.bsuir.beltransport.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByLoginAndPassword(User user);

    User save(User user);
}
