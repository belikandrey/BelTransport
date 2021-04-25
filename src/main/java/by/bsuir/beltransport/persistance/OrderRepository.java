package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
