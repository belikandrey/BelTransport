package by.bsuir.beltransport.controller;

import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private AdminService adminService;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @GetMapping
  public String home() {
    return "admin_home";
  }

  @GetMapping("/ride")
  public String toCreateRide(Ride ride) {
    return "admin_create_ride";
  }

  @PostMapping("/ride")
  public String createRide(Ride ride, @RequestBody MultiValueMap<String, String> params) {
    final String start_date = params.getFirst("start_date");
    final String end_date = params.getFirst("end_date");
    final String driver_id = params.getFirst("driver_id");
    try {
      adminService.createRide(ride, start_date, end_date, driver_id);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return "admin_home";
  }
}
