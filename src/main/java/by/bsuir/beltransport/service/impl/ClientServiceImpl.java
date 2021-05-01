package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.Payment;
import by.bsuir.beltransport.entity.PaymentType;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.persistance.ClientRepository;
import by.bsuir.beltransport.persistance.OrderRepository;
import by.bsuir.beltransport.persistance.RideRepository;
import by.bsuir.beltransport.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

  @Override
  public Ride getRideById(Integer rideId) throws EntityNotFoundException {
    final Optional<Ride> ride = rideRepository.findById(rideId);
    if (ride.isEmpty()) {
      throw new EntityNotFoundException("Ride with id : " + rideId + " not found");
    }
    return ride.get();
  }

  @Override
  public void createOrder(Integer ride_id, String payment_type, Client client)
      throws EntityNotFoundException {
    final Order order = new Order();
    final Optional<Ride> ride = rideRepository.findById(ride_id);
    if (ride.isEmpty()) {
      throw new EntityNotFoundException("ride with id : " + ride_id + " not found");
    }
    order.setRide(ride.get());
    order.setClient(client);
    Payment payment = new Payment();
    payment.setPrice(ride.get().getPrice());
    payment.setPaymentDate(Timestamp.valueOf(LocalDateTime.now()));
    PaymentType paymentType;
    if(payment_type.equalsIgnoreCase("cash")){
      paymentType = PaymentType.CASH;
    }else{
      paymentType = PaymentType.BANK_CARD;
    }
    payment.setType(paymentType);
    order.setPayment(payment);
    orderRepository.save(order);
    final Ride ride1 = ride.get();
    ride1.setLandingSides(ride1.getLandingSides()-1);
    rideRepository.save(ride1);
  }
}
