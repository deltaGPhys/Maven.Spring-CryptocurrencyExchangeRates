package com.zipcoder.cryptonator_api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Datum {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("base")
    private String crypto;
    private Double price;
    private Double volume;
    private Double change;
    private Long timestamp;

    public Datum() {
    }

    public Datum(String crypto, Double price, Double volume, Double change, Long timestamp) {
        this.crypto = crypto;
        this.price = price;
        this.volume = volume;
        this.change = change;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrypto() {
        return crypto;
    }

    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
