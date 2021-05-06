package by.bsuir.beltransport.controller;

import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.OrderResult;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.entity.Vehicle;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

  private DriverService driverService;

  @Autowired
  public DriverController(DriverService driverService) {
    this.driverService = driverService;
  }

  @GetMapping
  public String home() {
    return "driver_home";
  }

  @GetMapping("/edit-phone")
  public String getPageForEdit(Driver driver) {
    return "driver_edit_phone_number";
  }

  @PostMapping("/edit-phone")
  public String updatePhoneNumber(
      Driver driverFromRequest, BindingResult bindingResult, HttpSession session) {
    if (bindingResult.hasErrors()) {
      return "driver_edit_phone_number";
    }
    Driver driver = (Driver) session.getAttribute("driver");
    driver.setPhoneNumber(driverFromRequest.getPhoneNumber());
    driver = driverService.update(driver);
    session.setAttribute("driver", driver);
    return "driver_edit_phone_number";
  }

  @GetMapping("/all-rides")
  public String getAllRides(HttpSession session, Model model) {
    final Driver driver = (Driver) session.getAttribute("driver");
    final List<Ride> allRides = driverService.getAllRides(driver.getId());
    model.addAttribute("rides", allRides);
    return "driver_all_rides";
  }

  @GetMapping("/rides")
  public String getNextRides(HttpSession session, Model model) {
    final Driver driver = (Driver) session.getAttribute("driver");
    List<Ride> rides = driverService.getNextRides(driver.getId());
    model.addAttribute("rides", rides);
    return "driver_next_rides";
  }

  @GetMapping("/rides/{ride_id}")
  public String getOneRide(@PathVariable Integer ride_id, Model model) {
    try {
      Ride ride = driverService.getRideById(ride_id);
      List<Order> ordersForRide = driverService.getOrdersForRide(ride_id);
      model.addAttribute("ride", ride);
      model.addAttribute("orders", ordersForRide);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return "driver_ride_by_id";
  }

  @GetMapping("/edit-vehicle")
  public String toEditVehicle(Vehicle vehicle) {
    return "driver_edit_vehicle";
  }

  @PostMapping("/edit-vehicle")
  public String editVehicle(Vehicle vehicle, HttpSession session, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "driver_edit_vehicle";
    }
    Driver driver = (Driver) session.getAttribute("driver");
    vehicle.setId(driver.getVehicle().getId());
    driver.setVehicle(vehicle);
    final Driver updated = driverService.update(driver);
    session.setAttribute("driver", updated);
    return "driver_home";
  }

  @PostMapping("/rides/order-status")
  public String editStatus(@RequestBody MultiValueMap<String, String> params){
    final OrderResult result = OrderResult.valueOf(params.getFirst("result"));
    final Integer order_id = Integer.valueOf(params.getFirst("order_id"));
    try {
      driverService.editStatus(result, order_id);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return "driver_home";
  }
}
