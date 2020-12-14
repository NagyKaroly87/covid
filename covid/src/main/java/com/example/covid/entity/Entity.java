package com.example.covid.entity;

import java.sql.Timestamp;

public interface Entity<I> {

    /**
     * Returns the entity id.
     * @return the entity id
     */
    I getId();

    void setId(I id);

    void setCu(String cu);

    void setMu(String mu);

    void setCd(Timestamp cd);

    void setMd(Timestamp md);

}
