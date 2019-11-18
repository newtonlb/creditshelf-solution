package com.creditshelf.solution.model;

import java.io.Serializable;
import java.util.Objects;

public class SaleId implements Serializable {
    
    private long orderNumber;
    private String companyName;

    public SaleId() {
    }

    public SaleId(long orderNumber, String companyName) {
        this.orderNumber = orderNumber;
        this.companyName = companyName;
    }

    public long getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SaleId orderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public SaleId companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SaleId)) {
            return false;
        }
        SaleId saleId = (SaleId) o;
        return orderNumber == saleId.orderNumber && Objects.equals(companyName, saleId.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, companyName);
    }

    @Override
    public String toString() {
        return "{" +
            " orderNumber='" + getOrderNumber() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            "}";
    }



}