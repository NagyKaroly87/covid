package com.example.covid.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.covid.entity.CountryStat;

public interface CountryStatRepository extends JpaRepository<CountryStat, Long> {

    @Query("SELECT c FROM CountryStat c WHERE c.countryId = :countryId ")
    List<CountryStat> findCountryStatByCountryId(@Param("countryId") Long countryId);

    @Query("SELECT c FROM CountryStat c WHERE c.day = :date and c.countryId = :cId")
    CountryStat findCountryStatByDate(@Param("date") Date date, @Param("cId") Long cId);

    @Query("SELECT cs FROM CountryStat cs LEFT JOIN Country c on cs.countryId = c.id WHERE c.alpha3Code = :alpha3Code")
    List<CountryStat> findCountryStatByAlpha3Code(@Param("alpha3Code") String alpha3Code);
}
