package com.creditshelf.solution.model;

import java.io.Serializable;
import java.util.Objects;

public class ProductId implements Serializable {
    private long Id;
 
    private String companyName;
 
    // default constructor
 

    public ProductId() {
    }

    public ProductId(long Id, String companyName) {
        this.Id = Id;
        this.companyName = companyName;
    }

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ProductId Id(long Id) {
        this.Id = Id;
        return this;
    }

    public ProductId companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductId)) {
            return false;
        }
        ProductId productId = (ProductId) o;
        return Id == productId.Id && Objects.equals(companyName, productId.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, companyName);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            "}";
    }

 
    // equals() and hashCode()
}