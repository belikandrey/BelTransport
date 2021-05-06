package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.OrderResult;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.entity.Status;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.persistance.DriverRepository;
import by.bsuir.beltransport.persistance.OrderRepository;
import by.bsuir.beltransport.persistance.RideRepository;
import by.bsuir.beltransport.persistance.VehicleRepository;
import by.bsuir.beltransport.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

  private DriverRepository driverRepository;
  private VehicleRepository vehicleRepository;
  private RideRepository rideRepository;
  private OrderRepository orderRepository;

  @Autowired
  public DriverServiceImpl(
      DriverRepository driverRepository,
      VehicleRepository vehicleRepository,
      RideRepository rideRepository,
      OrderRepository orderRepository) {
    this.driverRepository = driverRepository;
    this.vehicleRepository = vehicleRepository;
    this.rideRepository = rideRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public Driver save(Driver driver) {
    return driverRepository.save(driver);
  }

  @Override
  public Driver update(Driver driver) {
    return driverRepository.save(driver);
  }

  @Override
  public List<Ride> getAllRides(Integer driverId) {
    return rideRepository.findAllByDriverByDriverId_Id(driverId);
  }

  @Override
  public List<Ride> getNextRides(Integer id) {
    return rideRepository.findAllByDriverByDriverId_IdAndStartDateAfterOrderByStartDate(
        id, Timestamp.valueOf(LocalDateTime.now()));
  }

  @Override
  public Double findSummaryRevenue(Integer driverId) {
    final Double sumOfRevenue = driverRepository.findSumOfRevenue(driverId);
    return sumOfRevenue == null ? 0 : sumOfRevenue;
  }

  @Override
  public void update(Integer driverId, Status status) throws EntityNotFoundException {
    final Driver driver = findById(driverId);
    driver.setStatus(status);
    save(driver);
  }

  @Override
  public Ride getRideById(Integer rideId) throws EntityNotFoundException {
    final Optional<Ride> rideOptional = rideRepository.findById(rideId);
    if (rideOptional.isEmpty()) {
      throw new EntityNotFoundException("Ride with id : " + rideId + " not found");
    }
    return rideOptional.get();
  }

  @Override
  public List<Order> getOrdersForRide(Integer ride_id) {
    return orderRepository.findAllByRide_IdAndResult(ride_id, OrderResult.UNDEFINED);
  }

  @Override
  public void editStatus(OrderResult result, Integer order_id) throws EntityNotFoundException {
    final Optional<Order> orderOptional = orderRepository.findById(order_id);
    if (orderOptional.isEmpty()) {
      throw new EntityNotFoundException("Order with id : " + order_id + " not found");
    }
    final Order order = orderOptional.get();
    order.setResult(result);
    orderRepository.save(order);
  }

  @Override
  public List<Driver> findAll() {
    return driverRepository.findAll();
  }

  @Override
  public Driver findById(Integer id) throws EntityNotFoundException {
    return driverRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Driver with id : " + id + " not found"));
  }
}
