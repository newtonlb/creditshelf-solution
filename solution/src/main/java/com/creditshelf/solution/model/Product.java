package com.creditshelf.solution.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.opencsv.bean.CsvBindByName;

@Entity
@IdClass(ProductId.class)
public class Product implements Serializable {

    @CsvBindByName(column="Id")
	@Id
	private Long Id;
    
    @CsvBindByName(column="Name")
    @Column(name="name")
    private String name;

    @CsvBindByName(column="Cost")
    @Column(name="cost")
    private String cost;

    @CsvBindByName(column="Currency")
    @Column(name="currency")
    private String currency;

    @Column(name="company")
    @Id
    private String companyName;


    public Product() {
    }

    public Product(Long id, String name, String cost, String currency, String companyName) {
        this.Id = id;
        this.name = name;
        this.cost = cost;
        this.currency = currency;
        this.companyName = companyName;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return this.cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return this.currency;
    }
    public String getCompany() {
        return this.companyName;
    }
    public void setCompany(String companyName) {
        this.companyName = companyName;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Product id(Long id) {
        this.Id = id;
        return this;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public Product cost(String cost) {
        this.cost = cost;
        return this;
    }

    public Product currency(String currency) {
        this.currency = currency;
        return this;
    }
    public Product companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(Id, product.Id) && Objects.equals(name, product.name) && Objects.equals(cost, product.cost) && Objects.equals(currency, product.currency) && Objects.equals(cost, product.cost) && Objects.equals(companyName, product.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, cost, currency, companyName);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", cost='" + getCost() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", companyName='" + getCompany() + "'" +
            "}";
    }
    
}