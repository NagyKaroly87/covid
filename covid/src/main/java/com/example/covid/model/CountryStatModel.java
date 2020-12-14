package com.example.covid.model;

import java.sql.Date;

public class CountryStatModel {

    private Long id;
    private Long countryId;

    private Long dailyCases;
    private Long dailyRecovered;
    private Long dailyDeaths;
    private Date day;
    private String user;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getDailyCases() {
        return dailyCases;
    }

    public void setDailyCases(Long dailyCases) {
        this.dailyCases = dailyCases;
    }

    public Long getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(Long dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public Long getDailyDeaths() {
        return dailyDeaths;
    }

    public void setDailyDeaths(Long dailyDeaths) {
        this.dailyDeaths = dailyDeaths;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
