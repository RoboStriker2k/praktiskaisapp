package com.praktiskaisapp.Rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestProvider {
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "Hello from RestProvider!";
    }
    
}
