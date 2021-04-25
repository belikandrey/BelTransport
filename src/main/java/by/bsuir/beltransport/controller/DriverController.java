package by.bsuir.beltransport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/driver")
public class DriverController {
    @GetMapping
    public String home(){
        return "driver_home";
    }
}
