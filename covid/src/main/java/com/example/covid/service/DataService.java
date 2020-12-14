package com.example.covid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.covid.model.CountryModel;
import com.example.covid.model.CountryStatModel;

@Service
public interface DataService {

    CountryStatModel createOrUpdateCountryStat(CountryStatModel stat);

    List<CountryStatModel> getCountryStatByCountryAlpha3Code(String alpha3Code);

    List<CountryModel> getAllCountry();

    CountryModel getCountryByCountryAlpha3Code(String alpha3Code);

    void initCountries();
}
