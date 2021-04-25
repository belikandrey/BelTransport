package by.bsuir.beltransport.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "drivers")
public class Driver {
    private Integer id;
    private String phoneNumber;
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Driver driver = (Driver) o;
//        return Objects.equals(id, driver.id) && Objects.equals(phoneNumber, driver.phoneNumber);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, phoneNumber);
//    }
}
