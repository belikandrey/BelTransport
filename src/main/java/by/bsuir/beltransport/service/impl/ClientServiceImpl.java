package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.persistance.ClientRepository;
import by.bsuir.beltransport.persistance.OrderRepository;
import by.bsuir.beltransport.persistance.RideRepository;
import by.bsuir.beltransport.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

  private RideRepository rideRepository;

  private OrderRepository orderRepository;

  private ClientRepository clientRepository;

  @Autowired
  public ClientServiceImpl(
      RideRepository rideRepository,
      OrderRepository orderRepository,
      ClientRepository clientRepository) {
    this.rideRepository = rideRepository;
    this.orderRepository = orderRepository;
    this.clientRepository = clientRepository;
  }

  @Override
  public List<Order> getAllClientOrders(Integer id) {
    return orderRepository.findAllByClient_Id(id);
  }

  @Override
  public List<Ride> getAvailableRides() {
    return rideRepository.findAllByStartDateAfterOrderByStartDate(
        Timestamp.valueOf(LocalDateTime.now().minusMinutes(30)));
  }

  @Override
  public void update(Client client) {
    clientRepository.save(client);
  }
}
