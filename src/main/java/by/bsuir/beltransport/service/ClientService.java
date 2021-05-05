package by.bsuir.beltransport.service;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.exception.ImpossibleToCancelOrderException;
import by.bsuir.beltransport.exception.NotEnoughSitesException;

import java.util.List;

public interface ClientService extends AbstractService{

    List<Order> getAllClientOrders(Integer id);

    List<Ride> getAvailableRides();

    void update(Client client);

    Ride getRideById(Integer rideId) throws EntityNotFoundException;

    void createOrder(Integer ride_id, String payment_type, Integer sites, Client client) throws EntityNotFoundException, NotEnoughSitesException;

    void deleteOrder(Client client, Integer orderId) throws EntityNotFoundException;

    List<Order> getOrdersForDelete(Integer clientId);
}
