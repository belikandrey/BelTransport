package by.bsuir.beltransport.persistance;

import by.bsuir.beltransport.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
