package by.bsuir.beltransport.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rides")
public class Ride {
    private Integer id;
    private String startLocation;
    private String endLocation;
    private Timestamp startDate;
    private Timestamp endDate;
    private Double price;
    private Integer landingSides;
    private Driver driverByDriverId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "landing_sites")
    public Integer getLandingSides() {
        return landingSides;
    }

    public void setLandingSides(Integer landingSides) {
        this.landingSides = landingSides;
    }

    @Basic
    @Column(name = "start_location")
    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    @Basic
    @Column(name = "end_location")
    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return Objects.equals(id, ride.id) && Objects.equals(startLocation, ride.startLocation) && Objects.equals(endLocation, ride.endLocation) && Objects.equals(startDate, ride.startDate) && Objects.equals(endDate, ride.endDate) && Objects.equals(price, ride.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startLocation, endLocation, startDate, endDate, price);
    }

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    public Driver getDriversByDriverId() {
        return driverByDriverId;
    }

    public void setDriversByDriverId(Driver driverByDriverId) {
        this.driverByDriverId = driverByDriverId;
    }
}
