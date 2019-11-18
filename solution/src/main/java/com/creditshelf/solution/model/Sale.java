package com.creditshelf.solution.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

@Entity
@IdClass(SaleId.class)
public class Sale {
    @Id
    @CsvBindByPosition(position=0)
    private String companyName;
    
    @Id
    @Column(name="order_number")
    @CsvBindByPosition(position=1)
    private long orderNumber;

    @Column(name="order_date")
    @Temporal(TemporalType.DATE)
    @CsvBindByName(column="Order date")
    private Date orderDate;


    public Sale() {
    }

    public Sale(String companyName, long orderNumber, Date orderDate) {
        this.companyName = companyName;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Sale companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Sale orderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public Sale orderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sale)) {
            return false;
        }
        Sale sale = (Sale) o;
        return Objects.equals(companyName, sale.companyName) && orderNumber == sale.orderNumber && Objects.equals(orderDate, sale.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, orderNumber, orderDate);
    }

    @Override
    public String toString() {
        return "{" +
            " companyName='" + getCompanyName() + "'" +
            ", orderNumber='" + getOrderNumber() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            "}";
    }

}