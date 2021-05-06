package by.bsuir.beltransport.service;

import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;

public interface AdminService {
    void createRide(Ride ride, String start_date, String end_date, String driver_id) throws EntityNotFoundException;
}
