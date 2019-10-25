package com.example.demo;

public class MetersToYardsConverter implements UnitsConverter{
    @Override
    public double convertFrom(double yards) {
        return yards * 0.9144;
    }

    @Override
    public double convertTo(double meters) {
        return meters / 0.9144;
    }
}
