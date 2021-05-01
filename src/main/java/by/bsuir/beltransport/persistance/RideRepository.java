package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Integer> {
    List<Ride> findAllByStartDateAfterOrderByStartDate(Timestamp timestamp);
}
