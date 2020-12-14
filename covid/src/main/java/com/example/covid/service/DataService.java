package com.example.covid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.covid.model.CountryModel;

@Service
public interface DataService {

    List<CountryModel> getAllCountry();

    void initCountries();
}
