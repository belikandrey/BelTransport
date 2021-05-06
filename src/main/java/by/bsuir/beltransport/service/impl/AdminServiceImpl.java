package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.persistance.DriverRepository;
import by.bsuir.beltransport.persistance.RideRepository;
import by.bsuir.beltransport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private RideRepository rideRepository;
    private DriverRepository driverRepository;

    @Autowired
    public AdminServiceImpl(RideRepository rideRepository, DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void createRide(Ride ride, String start_date, String end_date, String driver_id) throws EntityNotFoundException {
        final Timestamp startDate = Timestamp.valueOf(LocalDateTime.parse(start_date));
        final Timestamp endDate = Timestamp.valueOf(LocalDateTime.parse(end_date));
        Integer driverId = Integer.parseInt(driver_id);
        final Optional<Driver> driverOptional = driverRepository.findById(driverId);
        if(driverOptional.isEmpty()){
            throw new EntityNotFoundException("Driver with id : "+driver_id+" not found");
        }
        ride.setStartDate(startDate);
        ride.setEndDate(endDate);
        ride.setDriverByDriverId(driverOptional.get());
        rideRepository.save(ride);
    }
}
