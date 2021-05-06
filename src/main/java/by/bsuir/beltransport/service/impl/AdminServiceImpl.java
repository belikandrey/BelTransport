package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.OrderResult;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.persistance.ClientRepository;
import by.bsuir.beltransport.persistance.DriverRepository;
import by.bsuir.beltransport.persistance.OrderRepository;
import by.bsuir.beltransport.persistance.RideRepository;
import by.bsuir.beltransport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

  private RideRepository rideRepository;
  private DriverRepository driverRepository;
  private OrderRepository orderRepository;
  private ClientRepository clientRepository;

  @Autowired
  public AdminServiceImpl(
      RideRepository rideRepository,
      DriverRepository driverRepository,
      OrderRepository orderRepository,
      ClientRepository clientRepository) {
    this.rideRepository = rideRepository;
    this.driverRepository = driverRepository;
    this.orderRepository = orderRepository;
    this.clientRepository = clientRepository;
  }

  @Override
  public void createRide(Ride ride, String start_date, String end_date, String driver_id)
      throws EntityNotFoundException {
    final Timestamp startDate = Timestamp.valueOf(LocalDateTime.parse(start_date));
    final Timestamp endDate = Timestamp.valueOf(LocalDateTime.parse(end_date));
    Integer driverId = Integer.parseInt(driver_id);
    final Optional<Driver> driverOptional = driverRepository.findById(driverId);
    if (driverOptional.isEmpty()) {
      throw new EntityNotFoundException("Driver with id : " + driver_id + " not found");
    }
    ride.setStartDate(startDate);
    ride.setEndDate(endDate);
    ride.setDriverByDriverId(driverOptional.get());
    rideRepository.save(ride);
  }



  @Override
  public List<Client> findClientsByOrderResults(OrderResult result) {
    return clientRepository.findAll();
  }
}
