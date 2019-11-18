package com.creditshelf.solution.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.creditshelf.solution.model.ConversionRates;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConversionService {
    private ConversionRates conversionRates;
    static final String conversionRatingAPI = "https://api.exchangeratesapi.io/latest";
    public BigDecimal convertToEuro(String currency, BigDecimal value) {

        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method and default Headers.
        if (conversionRates == null) {
            conversionRates = restTemplate.getForObject(conversionRatingAPI, ConversionRates.class);
        }
        System.out.println("original value: " + value + " currency: " + currency);
        BigDecimal converted = value.divide(conversionRates.getRates().get(currency), 2, RoundingMode.CEILING);
        System.out.println("converted: " + converted);
        return converted;
    }

}