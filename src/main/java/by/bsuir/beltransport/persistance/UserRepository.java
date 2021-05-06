package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByLoginAndPassword(String login, String password);
    Optional<User> findUserByLogin(String login);
}
