package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/distance/{distance1}/{distance2}")
    public String sumDistances(@PathVariable double distance1,
                               @PathVariable double distance2,
                               @RequestParam(value = "isYardsUnit1", required = false, defaultValue = "false") boolean isYardsUnit1,
                               @RequestParam(value = "isYardsUnit2", required = false, defaultValue = "false") boolean isYardsUnit2,
                               @RequestParam(value = "isYardsResult", required = false, defaultValue = "false") boolean isYardsResult) {

        //Specify the units to return in the String result
        String unit1 = isYardsUnit1 ? "yards" : "meters";
        String unit2 = isYardsUnit2 ? "yards" : "meters";
        String unitResult = isYardsResult ? "yards" : "meters";

        //Convert both values to meters for simplicity: otherwise I would be using complicated switch statements
        //or if-blocks
        double distance1Meters = isYardsUnit1 ? metersToYardsConverter.convertFrom(distance1) : distance1;
        double distance2Meters = isYardsUnit2 ? metersToYardsConverter.convertFrom(distance2) : distance2;

        //If the result should be in yards, sum the values and convert to yards. Else just sum the values.
        double summedResult = isYardsResult ? metersToYardsConverter.convertTo
                (distance1Meters + distance2Meters) : distance1Meters + distance2Meters;

        //Use the Result String format to display the result
        return String.format(Messages.RESULT, distance1, unit1, distance2, unit2, summedResult, unitResult);
    }
}
