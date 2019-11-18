package com.creditshelf.solution.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SalesByCompanyDTO {
    long orderNumber;
    Date orderDate;
    BigDecimal total;
    List<ProductSales> products;
    

    public SalesByCompanyDTO() {
    }

    public SalesByCompanyDTO(long orderNumber, Date orderDate, BigDecimal total, List<ProductSales> products) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.total = total;
        this.products = products;
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

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ProductSales> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductSales> products) {
        this.products = products;
    }

    public SalesByCompanyDTO orderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public SalesByCompanyDTO orderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public SalesByCompanyDTO total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public SalesByCompanyDTO products(List<ProductSales> products) {
        this.products = products;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SalesByCompanyDTO)) {
            return false;
        }
        SalesByCompanyDTO salesByCompanyDTO = (SalesByCompanyDTO) o;
        return orderNumber == salesByCompanyDTO.orderNumber && Objects.equals(orderDate, salesByCompanyDTO.orderDate) && Objects.equals(total, salesByCompanyDTO.total) && Objects.equals(products, salesByCompanyDTO.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderDate, total, products);
    }

    public void calculateTotal() {

        this.total = BigDecimal.ZERO;
        for (ProductSales product : this.products) {
            BigDecimal quantity = new BigDecimal(product.getQuantity());
            BigDecimal salePrice = product.getSalePrice();
            System.out.println("sale price: " + salePrice + " quantity: " + quantity);
            this.total = this.total.add(product.getSalePrice().multiply(quantity));
        }
    }
    @Override
    public String toString() {
        return "{" +
            " orderNumber='" + getOrderNumber() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", total='" + getTotal() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }

}