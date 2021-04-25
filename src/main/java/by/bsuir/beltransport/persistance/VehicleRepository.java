package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
