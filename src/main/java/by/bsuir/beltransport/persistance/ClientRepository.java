package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
