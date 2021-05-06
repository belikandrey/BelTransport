package by.bsuir.beltransport.controller;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.OrderResult;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.entity.Status;
import by.bsuir.beltransport.exception.EntityNotFoundException;
import by.bsuir.beltransport.service.AdminService;
import by.bsuir.beltransport.service.ClientService;
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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private AdminService adminService;
  private ClientService clientService;
  private DriverService driverService;

  @Autowired
  public AdminController(
      AdminService adminService, ClientService clientService, DriverService driverService) {
    this.adminService = adminService;
    this.clientService = clientService;
    this.driverService = driverService;
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
  public String createRide(
      @Valid Ride ride, BindingResult result, @RequestBody MultiValueMap<String, String> params) {
    if (result.hasErrors()) {
      return "admin_create_ride";
    }
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

  @GetMapping("/edit-clients")
  public String toShowAllClients(Model model) {
    final List<Client> clients = clientService.findAll();
    model.addAttribute("clients", clients);
    return "admin_show_all_clients";
  }

  @GetMapping("/edit-drivers")
  public String toShowAllDrivers(Model model) {
    List<Driver> drivers = driverService.findAll();
    model.addAttribute("drivers", drivers);
    return "admin_show_all_drivers";
  }

  @GetMapping("/edit-drivers/{id}")
  public String showDriverById(@PathVariable Integer id, Model model) {
    try {
      Driver driver = driverService.findById(id);
      Double revenue = driverService.findSummaryRevenue(driver.getId());
      model.addAttribute("driver", driver);
      model.addAttribute("revenue", revenue);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return "admin_edit_driver_by_id";
  }

  @PostMapping("/edit-drivers/{id}")
  public String editClientById(
      @PathVariable Integer id, @RequestBody MultiValueMap<String, String> params) {
    final Status status = Status.valueOf(params.getFirst("status"));
    try {
      driverService.update(id, status);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return "redirect:/admin/edit-drivers";
  }

  @GetMapping("/edit-clients/{id}")
  public String showClientById(@PathVariable Integer id, Model model) {
    try {
      Client client = clientService.findById(id);
      Integer countCame = clientService.findCountByOrderResults(client, OrderResult.CAME);
      Integer countDidNotCome =
          clientService.findCountByOrderResults(client, OrderResult.DID_NOT_COME);
      model.addAttribute("client", client);
      model.addAttribute("countCame", countCame);
      model.addAttribute("countDidNotCome", countDidNotCome);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return "admin_edit_client_by_id";
  }

  @PostMapping("/edit-clients/{id}")
  public String editClientInfo(
      @PathVariable Integer id, @RequestBody MultiValueMap<String, String> params) {
    final Integer bonus = Integer.parseInt(params.getFirst("bonus"));
    final Status status = Status.valueOf(params.getFirst("status"));
    try {
      clientService.update(id, bonus, status);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return "redirect:/admin/edit-clients";
  }
}
