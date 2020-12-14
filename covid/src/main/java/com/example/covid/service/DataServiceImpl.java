package com.example.covid.service;

import static com.jayway.restassured.RestAssured.get;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.json.JSONArray;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.covid.entity.Country;
import com.example.covid.entity.CountryStat;
import com.example.covid.exception.ResourceNotFoundException;
import com.example.covid.model.CountryModel;
import com.example.covid.model.CountryStatModel;
import com.example.covid.repository.CountryRepository;
import com.example.covid.repository.CountryStatRepository;
import com.jayway.restassured.response.Response;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;

@Service
@Transactional
public class DataServiceImpl implements DataService {

    private static final Logger LOG = Logger.getLogger(DataServiceImpl.class);

    @Autowired
    private CountryStatRepository countryStatsRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CountryModel> getAllCountry() {

        return countryRepository.findAll().stream().map(s -> modelMapper.map(s, CountryModel.class)).collect(Collectors.toList());
    }

    @Override
    @PostConstruct
    public void initCountries() {

        try {
            String url = "https://restcountries.eu/rest/v2/all";
            Response resp = get(url);
            JSONArray jsonResponse = new JSONArray(resp.asString());
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Country>>() {
            }.getType();

            List<Country> countryList = gson.fromJson(jsonResponse.toString(), listType);
            Consumer<Country> consumer = s -> countryRepository.save(modelMapper.map(s, Country.class));
            countryList.forEach(consumer);

        } catch (Exception e) {
            LOG.error("There is an error connecting to the API: " + e.getStackTrace());
        }
    }

    @Override
    public CountryStatModel createOrUpdateCountryStat(CountryStatModel stat) {
        Optional<Country> countryEntity = countryRepository.findById(stat.getCountryId());

        if (countryEntity.isPresent()) {
            CountryStat statEntity = modelMapper.map(stat, CountryStat.class);
            statEntity.setCountryId(countryEntity.get().getId());
            if (stat.getDay() != null) {
                CountryStat countryStatDb = countryStatsRepository.findCountryStatByDate(stat.getDay(), stat.getCountryId());
                if (countryStatDb != null) {
                    statEntity.setId(countryStatDb.getId());
                }
            }
            countryStatsRepository.save(statEntity);
        } else {
            throw new ResourceNotFoundException("Country not found" + stat.getCountryId());
        }
        //countryRepository.findById(1L)
        return stat;
    }

    @Override
    public List<CountryStatModel> getCountryStatByCountryAlpha3Code(String alpha3Code) {
        List<CountryStat> countryStatList = countryStatsRepository.findCountryStatByAlpha3Code(alpha3Code);

        return countryStatList.stream().map(s -> modelMapper.map(s, CountryStatModel.class)).collect(Collectors.toList());
    }

    @Override
    public CountryModel getCountryByCountryAlpha3Code(String alpha3Code) {
        Country country = countryRepository.findCountryByAlpha3Code(alpha3Code);
        return modelMapper.map(country, CountryModel.class);
    }

}
