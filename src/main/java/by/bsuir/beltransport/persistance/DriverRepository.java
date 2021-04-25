package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
