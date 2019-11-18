package com.creditshelf.solution.service;

import java.util.ArrayList;
import java.util.List;

import com.creditshelf.solution.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSalesService {
@Autowired
ProductSalesRepository productSalesRepository;

    public List<ProductSales> getAllCompanies() {
        List<ProductSales> productSales = new ArrayList<ProductSales>();
        productSalesRepository.findAll().forEach(productSale -> productSales.add(productSale));
        return productSales;
    }

    public ProductSales getProductSalesById(int id) {
        return productSalesRepository.findById(id).get();
    }

    public void saveOrUpdate(ProductSales productSale) {
        productSalesRepository.save(productSale);
    }

    public void delete(int id) {
        productSalesRepository.deleteById(id);
    }
}