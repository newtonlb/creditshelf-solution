package com.creditshelf.solution.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class RevenueReportDTO {
    BigDecimal totalRevenue;
    Map<Integer, MonthlyReport> history;


    public RevenueReportDTO() {
    }

    public RevenueReportDTO(BigDecimal totalRevenue, Map<Integer,MonthlyReport> history) {
        this.totalRevenue = totalRevenue;
        this.history = history;
    }

    public BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Map<Integer,MonthlyReport> getMonthlyReports() {
        return this.history;
    }

    public void setMonthlyReports(Map<Integer,MonthlyReport> history) {
        this.history = history;
    }

    public RevenueReportDTO totalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
        return this;
    }

    public RevenueReportDTO history(Map<Integer,MonthlyReport> history) {
        this.history = history;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RevenueReportDTO)) {
            return false;
        }
        RevenueReportDTO revenueReportDTO = (RevenueReportDTO) o;
        return Objects.equals(totalRevenue, revenueReportDTO.totalRevenue) && Objects.equals(history, revenueReportDTO.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRevenue, history);
    }

    @Override
    public String toString() {
        return "{" +
            " totalRevenue='" + getTotalRevenue() + "'" +
            ", history='" + getMonthlyReports() + "'" +
            "}";
    }

}