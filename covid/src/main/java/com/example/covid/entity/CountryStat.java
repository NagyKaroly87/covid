package com.example.covid.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "Countries_stats")
public class CountryStat extends AbstractEntity {

    private Long countryId;

    Long dailyCases;

    Long dailyRecovered;

    Long dailyDeaths;

    Date day;

    public String user;

    public void setUser(String user) {
        this.user = user;
    }

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

    @Override
    String getUserName() {
        return user;
    }

}
