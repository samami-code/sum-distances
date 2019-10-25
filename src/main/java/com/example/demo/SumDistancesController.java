package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@SuppressWarnings("unused")
public class SumDistancesController {

    @GetMapping("/")
    public String displayInfo() {
        return Messages.INFO;
    }
}
