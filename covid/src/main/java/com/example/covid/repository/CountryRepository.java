package com.example.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.covid.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}