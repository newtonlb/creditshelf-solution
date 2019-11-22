package com.creditshelf.solution.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductSalesDTO {
    String productName;
    long quantity;
    BigDecimal salePrice;
    long productId;

    public ProductSalesDTO(String productName, long quantity, BigDecimal salePrice, long productId) {
        this.productName = productName;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.productId = productId;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public ProductSalesDTO productId(long productId) {
        this.productId = productId;
        return this;
    }

    public ProductSalesDTO() {
    }

    public ProductSalesDTO(String productName, long quantity, BigDecimal salePrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public ProductSalesDTO productName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductSalesDTO quantity(long quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductSalesDTO salePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductSalesDTO)) {
            return false;
        }
        ProductSalesDTO productSalesDTO = (ProductSalesDTO) o;
        return Objects.equals(productName, productSalesDTO.productName) && quantity == productSalesDTO.quantity && Objects.equals(salePrice, productSalesDTO.salePrice)  && Objects.equals(productId, productSalesDTO.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, quantity, salePrice);
    }

    @Override
    public String toString() {
        return "{" +
            " productName='" + getProductName() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", salePrice='" + getSalePrice() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }

}