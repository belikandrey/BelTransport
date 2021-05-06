package by.bsuir.beltransport.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    private Integer id;
    private Client client;
    private Ride ride;
    private Payment payment;
    private Timestamp createDate;
    private Integer countOfSeats;
    private OrderResult result;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ride_id", referencedColumnName = "id", nullable = false)
    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Column(name = "result")
    @Enumerated(EnumType.STRING)
    public OrderResult getResult() {
        return result;
    }

    public void setResult(OrderResult result) {
        this.result = result;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "payment_id", referencedColumnName = "id", nullable = false)
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Column(name = "sites")
    public Integer getCountOfSeats() {
        return countOfSeats;
    }

    public void setCountOfSeats(Integer countOfSeats) {
        this.countOfSeats = countOfSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
