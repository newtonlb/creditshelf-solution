package com.creditshelf.solution.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SalesByCompanyDTO {
    long orderNumber;
    LocalDate orderDate;
    BigDecimal total;
    List<ProductSalesDTO> products;
    

    public SalesByCompanyDTO() {
    }

    public SalesByCompanyDTO(long orderNumber, LocalDate orderDate, BigDecimal total, List<ProductSalesDTO> products) {
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

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ProductSalesDTO> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductSalesDTO> products) {
        this.products = products;
    }

    public SalesByCompanyDTO orderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public SalesByCompanyDTO orderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public SalesByCompanyDTO total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public SalesByCompanyDTO products(List<ProductSalesDTO> products) {
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
        for (ProductSalesDTO product : this.products) {
            BigDecimal quantity = new BigDecimal(product.getQuantity());
            BigDecimal salePrice = product.getSalePrice();
            this.total = this.total.add(salePrice.multiply(quantity));
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