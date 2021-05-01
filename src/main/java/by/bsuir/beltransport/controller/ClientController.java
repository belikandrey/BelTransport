package by.bsuir.beltransport.controller;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Order;
import by.bsuir.beltransport.entity.Ride;
import by.bsuir.beltransport.entity.User;
import by.bsuir.beltransport.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

  private ClientService clientService;

  @Autowired
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping
  public String home() {
    return "client_home";
  }

  @GetMapping("/orders")
  public String getClientRides(HttpSession session, Model model) {
    Client client = (Client) session.getAttribute("client");
    final List<Order> allClientOrders = clientService.getAllClientOrders(client.getId());
    model.addAttribute("orders", allClientOrders);
    return "client_orders";
  }

  @GetMapping("/available-rides")
  public String getAllEnabledRides(Model model) {
    List<Ride> rides = clientService.getAvailableRides();
    model.addAttribute("rides", rides);
    return "client_available_rides";
  }

  @GetMapping("/edit-phone")
  public String getPageForEdit(Client client){
    return "client_edit_phone_number";
  }

  @PostMapping("/edit-phone")
  public String updatePhoneNumber(Client clientFromRequest, BindingResult bindingResult, HttpSession session){
    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(System.out::println);
      return "client_edit_phone_number";
    }
    Client client =(Client) session.getAttribute("client");
    client.setPhoneNumber(clientFromRequest.getPhoneNumber());
    clientService.update(client);
    session.setAttribute("client", client);
    return "client_edit_phone_number";
  }
}
