package by.bsuir.beltransport.service;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;

import java.util.List;

public interface DriverService {
    Driver save(Driver driver);

    Driver update(Driver driver);

    List<Ride> getAllRides(Integer driverId);

    List<Ride> getNextRides(Integer id);

    Ride getRideById(Integer rideId) throws EntityNotFoundException;

    List<Order> getOrdersForRide(Integer ride_id);
}
