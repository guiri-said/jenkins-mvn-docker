package org.example.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final static Logger LOG = Logger.getLogger(HomeController.class.getName());
    @Value("${application.log.name:DEFAULT-CUSTOMER:APPLICATION}")
    String logName;
    @GetMapping("/index")
    public String index() {
        LOG.log(Level.INFO,"THE  {0} IS CALLED TO URL /home/index  ",logName);
        return "CUSTOMER index Page";
    }
}
