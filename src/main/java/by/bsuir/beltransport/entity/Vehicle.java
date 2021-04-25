package by.bsuir.beltransport.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "vehicles")
public class Vehicle {
  private Integer id;

  @NotBlank(message = "Number should be not blank")
  @Size(min = 3, max = 30, message = "Number length should be more than 3 and less than 30")
  private String number;

  @NotBlank(message = "Model should be not blank")
  @Size(min = 3, max = 30, message = "Model length should be more than 3 and less than 30")
  private String model;

  private VehicleType type;

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
  @Column(name = "number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  @Basic
  @Column(name = "model")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  public VehicleType getType() {
    return type;
  }

  public void setType(VehicleType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(id, vehicle.id)
        && Objects.equals(number, vehicle.number)
        && Objects.equals(model, vehicle.model)
        && Objects.equals(type, vehicle.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, model, type);
  }

  @Override
  public String toString() {
    return "Vehicle{" +
            "id=" + id +
            ", number='" + number + '\'' +
            ", model='" + model + '\'' +
            ", type=" + type +
            '}';
  }
}
