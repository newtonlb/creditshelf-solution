package com.creditshelf.solution.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.creditshelf.solution.model.ConversionRates;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConversionService {
    private ConversionRates conversionRates;
    static final String conversionRatingAPI = "https://api.exchangeratesapi.io/";
    

    public BigDecimal convertToEuroWithDateCurrency(String currency, BigDecimal value, LocalDate orderDate) {
        RestTemplate restTemplate = new RestTemplate();

        conversionRates = restTemplate.getForObject(conversionRatingAPI + orderDate.toString(), ConversionRates.class);
        BigDecimal converted = value.divide(conversionRates.getRates().get(currency), 2, RoundingMode.CEILING);
        return converted;
    }

}