package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@SuppressWarnings("unused")
public class SumDistancesController {

    @Autowired
    private UnitsConverter metersToYardsConverter;

    @GetMapping("/")
    public String displayInfo() {
        return Messages.INFO;
    }

    @GetMapping("/meters/{meters}")
    public String convertMetersToYards(@PathVariable double meters){
        meters = metersToYardsConverter.convertTo(meters);
        return meters + " yards";
    }

    @GetMapping("/yards/{yards}")
    public String convertYardsToMeters(@PathVariable double yards){
        yards = metersToYardsConverter.convertFrom(yards);
        return yards + " meters";
    }
}
