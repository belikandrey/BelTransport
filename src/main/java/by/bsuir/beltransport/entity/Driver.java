package by.bsuir.beltransport.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "drivers")
public class Driver extends User {
    @Pattern(
            regexp = "^\\+375(17|29|33|44)[0-9]{3}[0-9]{2}[0-9]{2}$",
            message = "Phone number should be like this : +375295054412")
    private String phoneNumber;
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(phoneNumber, driver.phoneNumber) && Objects.equals(vehicle, driver.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, vehicle);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
