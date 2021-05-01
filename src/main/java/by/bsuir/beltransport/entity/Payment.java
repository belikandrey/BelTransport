package by.bsuir.beltransport.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payment {
  private Integer id;
  private Timestamp paymentDate;

  @Min(value = 1, message = "Price should be more than 1")
  private Double price;

  private PaymentType type;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "payment_date")
  public Timestamp getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Timestamp paymentDate) {
    this.paymentDate = paymentDate;
  }

  @Basic
  @Column(name = "price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  public PaymentType getType() {
    return type;
  }

  public void setType(PaymentType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Payment payment = (Payment) o;
    return Objects.equals(id, payment.id)
        && Objects.equals(paymentDate, payment.paymentDate)
        && Objects.equals(price, payment.price)
        && Objects.equals(type, payment.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, paymentDate, price, type);
  }
}
