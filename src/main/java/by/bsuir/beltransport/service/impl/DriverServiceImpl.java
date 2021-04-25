package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Vehicle;
import by.bsuir.beltransport.persistance.DriverRepository;
import by.bsuir.beltransport.persistance.VehicleRepository;
import by.bsuir.beltransport.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

  private DriverRepository driverRepository;
  private VehicleRepository vehicleRepository;

  @Autowired
  public DriverServiceImpl(DriverRepository driverRepository, VehicleRepository vehicleRepository) {
    this.driverRepository = driverRepository;
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public Driver save(Driver driver) {
    return driverRepository.save(driver);
  }
}
