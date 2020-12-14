package com.example.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.model.CountryModel;
import com.example.covid.service.DataService;

@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/countrystat")
    public ResponseEntity<List<CountryModel>> getAllCountry() {
        return ResponseEntity.ok().body(dataService.getAllCountry());
    }

}
