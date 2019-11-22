package com.creditshelf.solution.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creditshelf.solution.model.*;

import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class RevenuesReportService {

@Autowired
SalesByCompanyService salesByCompanyService;

@Autowired
CurrencyConversionService currencyConversionService;

    public RevenueReportDTO getRevenueReportByCompany(String company) {
        List<SalesByCompanyDTO> salesByCompany = salesByCompanyService.getAllSalesByCompany(company);

        BigDecimal totalRevenue = BigDecimal.ZERO;

        Map<Integer,MonthlyReport> history = new HashMap<Integer, MonthlyReport>();

        for(SalesByCompanyDTO saleByCompany : salesByCompany ) {
            int month = saleByCompany.getOrderDate().getMonthValue();
            totalRevenue = totalRevenue.add(saleByCompany.getTotal());
            if (!history.containsKey(month)) {
                
                MonthlyReport mr = new MonthlyReport().value(saleByCompany.getTotal()).month(month);
                if(mr == null) {
                    System.out.println("its null");
                }
                history.put(month, mr);
            }
            else {
                history.get(month).increaseValue(saleByCompany.getTotal());
            }
            
        }
        RevenueReportDTO revenueReport = new RevenueReportDTO().totalRevenue(totalRevenue).history(history);
        return revenueReport;

    }

   
}