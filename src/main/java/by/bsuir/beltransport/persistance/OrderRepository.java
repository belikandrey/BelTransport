package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.OrderResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByClient_IdOrderByCreateDateDesc(Integer id);
    List<Order> findAllByRide_IdAndResult(Integer ride_id, OrderResult result);
    List<Order> findAllByResult(OrderResult result);
    Integer countAllByClientAndResult(Client client, OrderResult result);
}
