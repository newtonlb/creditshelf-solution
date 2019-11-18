package com.creditshelf.solution.model;

import java.math.BigDecimal;
import java.util.Objects;

public class MonthlyReport {
    BigDecimal value;
    int month;

    public MonthlyReport() {
    }

    public MonthlyReport(BigDecimal value, int month) {
        this.value = value;
        this.month = month;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getMonth() {
        return this.month;
    }
    public void increaseValue(BigDecimal value) {
        this.value = this.value.add(value);
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public MonthlyReport value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public MonthlyReport month(int month) {
        this.month = month;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MonthlyReport)) {
            return false;
        }
        MonthlyReport monthlyReport = (MonthlyReport) o;
        return Objects.equals(value, monthlyReport.value) && Objects.equals(month, monthlyReport.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, month);
    }

    @Override
    public String toString() {
        return "{" +
            " value='" + getValue() + "'" +
            ", month='" + getMonth() + "'" +
            "}";
    }


}