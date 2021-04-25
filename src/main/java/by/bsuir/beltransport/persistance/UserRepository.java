package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
