package com.example.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.covid.entity.CountryStat;

public interface CountryStatRepository extends JpaRepository<CountryStat, Long> {

}
