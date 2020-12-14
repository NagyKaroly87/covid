package com.example.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.model.CountryModel;
import com.example.covid.model.CountryStatModel;
import com.example.covid.service.DataService;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/country")
    public ResponseEntity<List<CountryModel>> getAllCountry() {
        return ResponseEntity.ok().body(dataService.getAllCountry());
    }

    @GetMapping("/country/{alpha3Code}")
    public ResponseEntity<CountryModel> getCountryByCountryAlpha3Code(@PathVariable String alpha3Code) {
        return ResponseEntity.ok().body(dataService.getCountryByCountryAlpha3Code(alpha3Code));
    }

    @PostMapping("/countrystat")
    public ResponseEntity<CountryStatModel> createOrUpdateCountryStat(@RequestBody CountryStatModel stat) {
        return ResponseEntity.ok().body(dataService.createOrUpdateCountryStat(stat));
    }

    @GetMapping("/countrystat/{alpha3Code}")
    public ResponseEntity<List<CountryStatModel>> getCountryStatByCountryAlpha3Code(@PathVariable String alpha3Code) {
        return ResponseEntity.ok().body(dataService.getCountryStatByCountryAlpha3Code(alpha3Code));
    }

}
