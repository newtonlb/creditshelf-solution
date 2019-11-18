package com.creditshelf.solution.model;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ProductSalesId.class)
public class ProductSales {

    @Id
    @Column(name="product_id")
    private long productId;
    @Id
    @Column(name="order_id")
    private long orderId;
    
    @Id
    @Column(name="company_name")
    private String companyName;

    @Column(name="price")
    private BigDecimal salePrice;
    @Column(name="Currency")
    private String currency;

    @Column(name="quantity")
    private long quantity;


    public ProductSales(long productId, long orderId, String companyName, BigDecimal salePrice, String currency, long quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.companyName = companyName;
        this.salePrice = salePrice;
        this.currency = currency;
        this.quantity = quantity;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public ProductSales quantity(long quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductSales() {
    }

    public ProductSales(long productId, long orderId, String companyName, BigDecimal salePrice, String currency) {
        this.productId = productId;
        this.orderId = orderId;
        this.companyName = companyName;
        this.salePrice = salePrice;
        this.currency = currency;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ProductSales productId(long productId) {
        this.productId = productId;
        return this;
    }

    public ProductSales orderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public ProductSales companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ProductSales salePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public ProductSales currency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductSales)) {
            return false;
        }
        ProductSales productSales = (ProductSales) o;
        return productId == productSales.productId && orderId == productSales.orderId && Objects.equals(companyName, productSales.companyName) && Objects.equals(salePrice, productSales.salePrice) && Objects.equals(currency, productSales.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId, companyName, salePrice, currency);
    }

    @Override
    public String toString() {
        return "{" +
            " productId='" + getProductId() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", salePrice='" + getSalePrice() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }

}