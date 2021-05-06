package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query(
            value = "select sum(p.price) as sum from payment p join orders o on p.id = o.payment_id "
                    + " join rides r on o.ride_id = r.id "
                    + " where r.driver_id = ?1", nativeQuery = true)
    Double findSumOfRevenue(Integer driverId);
}
