package by.bsuir.beltransport.service;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.Ride;

import java.util.List;

public interface ClientService extends AbstractService{

    List<Order> getAllClientOrders(Integer id);

    List<Ride> getAvailableRides();

    void update(Client client);
}
