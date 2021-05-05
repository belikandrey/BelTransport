package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.Payment;
import by.bsuir.beltransport.entity.PaymentType;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.exception.NotEnoughSitesException;
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
    return rideRepository.findAllByStartDateAfterAndLandingSidesGreaterThanOrderByStartDate(
        Timestamp.valueOf(LocalDateTime.now().minusMinutes(30)), 0);
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
  public void createOrder(Integer ride_id, String payment_type, Integer sites, Client client)
          throws EntityNotFoundException, NotEnoughSitesException {
    final Order order = new Order();
    final Optional<Ride> rideOptional = rideRepository.findById(ride_id);
    if (rideOptional.isEmpty()) {
      throw new EntityNotFoundException("Ride with id : " + ride_id + " not found");
    }
    final Ride ride = rideOptional.get();
    if(ride.getLandingSides()<sites){
      throw new NotEnoughSitesException("You ordered too many seats. Count of free sites : "+ride.getLandingSides()+". ");
    }
    order.setRide(ride);
    order.setClient(client);
    Payment payment = new Payment();
    payment.setPrice(ride.getPrice());
    payment.setPaymentDate(Timestamp.valueOf(LocalDateTime.now()));
    PaymentType paymentType = getPaymentType(payment_type);
    payment.setType(paymentType);
    order.setCountOfSeats(sites);
    order.setPayment(payment);
    orderRepository.save(order);
    ride.setLandingSides(ride.getLandingSides() - sites);
    rideRepository.save(ride);
  }

  private PaymentType getPaymentType(String paymentType) {
    final String payment = paymentType.substring(13);
    if (payment.equalsIgnoreCase("cash")) {
      return PaymentType.CASH;
    }
    return PaymentType.BANK_CARD;
  }
}
