package com.creditshelf.solution.model;

import java.io.Serializable;
import java.util.Objects;

public class ProductSalesId implements Serializable {
    private long productId;
    private long orderId;
    private String companyName;

    public ProductSalesId() {
    }

    public ProductSalesId(long productId, long orderId, String companyName) {
        this.productId = productId;
        this.orderId = orderId;
        this.companyName = companyName;
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

    public ProductSalesId productId(long productId) {
        this.productId = productId;
        return this;
    }

    public ProductSalesId orderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public ProductSalesId companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductSalesId)) {
            return false;
        }
        ProductSalesId productSalesId = (ProductSalesId) o;
        return productId == productSalesId.productId && orderId == productSalesId.orderId && Objects.equals(companyName, productSalesId.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId, companyName);
    }

    @Override
    public String toString() {
        return "{" +
            " productId='" + getProductId() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            "}";
    }


}