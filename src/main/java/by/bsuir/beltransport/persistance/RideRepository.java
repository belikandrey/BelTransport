package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Integer> {
}
