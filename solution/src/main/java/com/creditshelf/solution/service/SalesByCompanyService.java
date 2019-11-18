package com.creditshelf.solution.service;

import java.util.ArrayList;
import java.util.List;

import com.creditshelf.solution.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class SalesByCompanyService {
@Autowired
SaleRepository saleRepository;

@Autowired
CurrencyConversionService currencyConversionService;
@Autowired
ProductSalesRepository productSalesRepository;

    public List<SalesByCompanyDTO> getAllSalesByCompany(String company) {
        List<SalesByCompanyDTO> salesByCompany = new ArrayList<>();
        List<Sale> sales = saleRepository.findSalesByCompanyName(company);
        for(Sale sale: sales) {
            List<ProductSales> productSales = productSalesRepository.findProductsSalesByOrderAndCompany(company, sale.getOrderNumber());
            List<ProductSales> productSalesConverted = productSales;
            for(ProductSales productSale : productSalesConverted) {
                if(!productSale.getCurrency().equals("EUR")) {
                    System.out.println(productSale.getCurrency());
                    System.out.println(productSale.getSalePrice());
                    productSale.setSalePrice(currencyConversionService.convertToEuro(productSale.getCurrency(), productSale.getSalePrice()));
                    productSale.setCurrency("EUR");
                }
                
            }
            SalesByCompanyDTO saleByCompanyDTO = new SalesByCompanyDTO()
            .orderDate(sale.getOrderDate())
            .orderNumber(sale.getOrderNumber())
            .products(productSalesConverted);

            saleByCompanyDTO.calculateTotal();
            salesByCompany.add(saleByCompanyDTO);
        }
        return salesByCompany;
    }

   
}