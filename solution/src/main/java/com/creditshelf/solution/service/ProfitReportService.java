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
public class ProfitReportService {

@Autowired
SalesByCompanyService salesByCompanyService;

@Autowired 
ProductService productService;

@Autowired
CurrencyConversionService currencyConversionService;

    public RevenueReportDTO getProfitReportByCompany(String company) {
        List<SalesByCompanyDTO> salesByCompany = salesByCompanyService.getAllSalesByCompany(company);

        BigDecimal totalProfit = BigDecimal.ZERO;

        Map<Integer,MonthlyReport> history = new HashMap<Integer, MonthlyReport>();

        for(SalesByCompanyDTO saleByCompany : salesByCompany ) {
            int month = saleByCompany.getOrderDate().getMonthValue();
            BigDecimal profit = BigDecimal.ZERO;
            BigDecimal cost = BigDecimal.ZERO;
            for (ProductSalesDTO productSale : saleByCompany.getProducts()) {

                Product product = productService.getProductByCompanyNameAndId(company, productSale.getProductId());
                BigDecimal productCost = new BigDecimal(product.getCost().replace(',', '.'));
                cost = currencyConversionService.convertToEuroWithDateCurrency(product.getCurrency(), productCost, saleByCompany.getOrderDate());
                
                profit = profit.add(productSale.getSalePrice().subtract(cost).multiply(new BigDecimal(productSale.getQuantity())));

            }
            totalProfit = totalProfit.add(profit);
            if (!history.containsKey(month)) {
                history.put(month, new MonthlyReport().value(profit).month(month));
            }
            else {
                history.get(month).increaseValue(profit);
            }
            
        }
        RevenueReportDTO profitReport = new RevenueReportDTO().totalRevenue(totalProfit).history(history);
        return profitReport;

    }

   
}