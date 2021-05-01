package by.bsuir.beltransport.controller;

import by.bsuir.beltransport.entity.Client;
import by.bsuir.beltransport.entity.Driver;
import by.bsuir.beltransport.entity.Role;
import by.bsuir.beltransport.entity.Status;
import by.bsuir.beltransport.entity.User;
import by.bsuir.beltransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

  private UserService userService;

  @Autowired
  public HomeController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public String home() {
    return "hello";
  }

  @GetMapping("/join")
  public String toJoin(User user) {
    return "join";
  }

  @PostMapping("/join")
  public String join(@Valid User user, BindingResult bindingResult, HttpSession session) {
    if (bindingResult.hasErrors()) {
      return "join";
    }
    final Optional<User> userOptional = userService.findByLoginAndPassword(user);
    if (userOptional.isEmpty()) {
      bindingResult.addError(
          new ObjectError("globalError", "User with this login and password not found"));
      return "join";
    }
    final User userFromDb = userOptional.get();
    return getPageUrlAfterJoin(userFromDb, session);
  }

  private String getPageUrlAfterJoin(User user, HttpSession session) {
    String pageUrl = "redirect:/";
    if (user instanceof Client) {
      final Client client = (Client) user;
      session.setAttribute("client", client);
      pageUrl += "client";
    } else if (user instanceof Driver) {
      final Driver driver = (Driver) user;
      session.setAttribute("driver", driver);
      pageUrl += "driver";
    } else {
      session.setAttribute("admin", user);
      pageUrl += "admin";
    }
    return pageUrl;
  }

  @GetMapping("/sign-in-client")
  public String toSignClient(Client client) {
    return "sign_in_client";
  }

  @PostMapping("sign-in-client")
  public String signClient(@Valid Client client, BindingResult bindingResult, HttpSession session) {
    if (bindingResult.hasErrors()) {
      return "sign_in_client";
    }
    fillNewClientInfo(client);
    final User saved = userService.save(client);
    session.setAttribute("user", saved);
    return "redirect:/client";
  }

  private void fillNewClientInfo(Client client) {
    client.setRole(Role.CLIENT);
    client.setStatus(Status.ACTIVE);
    client.setBonus(0);
  }

  @GetMapping("/sign-in-driver")
  public String toSignDriver(Driver driver) {
    return "sign_in_driver";
  }

  @PostMapping("/sign-in-driver")
  public String signDriver(@Valid Driver driver, BindingResult bindingResult, HttpSession session) {
    if (bindingResult.hasErrors()) {
      return "sign_in_driver";
    }
    driver.setRole(Role.DRIVER);
    driver.setStatus(Status.ACTIVE);
    final User saved = userService.save(driver);
    session.setAttribute("user", saved);
    return "redirect:/driver";
  }
}
