package com.example.covid.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractEntity implements Entity<Long> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
     * create user
     * */
    @Column(name = "cu")
    private String cu;
    /*
     * modify user
     * */
    @Column(name = "mu")
    private String mu;
    /*
     * create date
     * */
    @Column(name = "cd")
    private Timestamp cd;
    /*
     * modify date
     * */
    @Column(name = "md")
    private Timestamp md;

    abstract String getUserName();

    @PrePersist
    public void setCuCdPrePersist() {
        if (getCu() == null) {
            setCu(getUserName());
        }
        setCd(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    public void setMuCdPreUpdate() {
        setMu(getUserName());
        setMd(new Timestamp(System.currentTimeMillis()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    public Timestamp getCd() {
        return cd;
    }

    public void setCd(Timestamp cd) {
        this.cd = cd;
    }

    public Timestamp getMd() {
        return md;
    }

    public void setMd(Timestamp md) {
        this.md = md;
    }

}
