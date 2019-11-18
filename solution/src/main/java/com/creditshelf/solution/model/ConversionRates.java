package com.creditshelf.solution.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class ConversionRates {
    private String base;
    private String date;
    private Map<String, BigDecimal> rates;


    public ConversionRates() {
    }

    public ConversionRates(String base, String date, Map<String,BigDecimal> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String,BigDecimal> getRates() {
        return this.rates;
    }

    public void setRates(Map<String,BigDecimal> rates) {
        this.rates = rates;
    }

    public ConversionRates base(String base) {
        this.base = base;
        return this;
    }

    public ConversionRates date(String date) {
        this.date = date;
        return this;
    }

    public ConversionRates rates(Map<String,BigDecimal> rates) {
        this.rates = rates;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConversionRates)) {
            return false;
        }
        ConversionRates conversionRates = (ConversionRates) o;
        return Objects.equals(base, conversionRates.base) && Objects.equals(date, conversionRates.date) && Objects.equals(rates, conversionRates.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, date, rates);
    }

    @Override
    public String toString() {
        return "{" +
            " base='" + getBase() + "'" +
            ", date='" + getDate() + "'" +
            ", rates='" + getRates() + "'" +
            "}";
    }

}