package com.example.covid.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "Countries_stats")
public class CountryStat extends AbstractEntity<String> {

    @PrePersist
    @PreUpdate
    public void persistId() {
        String generatedId = this.getCountryId() + String.valueOf(this.getDay());
        this.setId(generatedId);
    }

    @Column(name = "countryId")
    private String countryId;

    @Column(name = "dailyTested")
    Long dailyTested;

    @Column(name = "dailyCases")
    Long dailyCases;

    @Column(name = "dailyRecovered")
    Long dailyRecovered;

    @Column(name = "dailyDeaths")
    Long dailyDeaths;

    @Column(name = "day")
    Date day;

    public String user;

    public void setUser(String user) {
        this.user = user;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
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

    public Long getDailyTested() {
        return dailyTested;
    }

    public void setDailyTested(Long dailyTested) {
        this.dailyTested = dailyTested;
    }

    @Override
    String getUserName() {
        return user;
    }

}
