package com.creditshelf.solution.service;

import java.util.ArrayList;
import java.util.List;

import com.creditshelf.solution.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
@Autowired
SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<Sale>();
        saleRepository.findAll().forEach(sale -> sales.add(sale));
        return sales;
    }

    public Sale getSaleById(int id) {
        return saleRepository.findById(id).get();
    }

    public void saveOrUpdate(Sale sale) {
        saleRepository.save(sale);
    }

    public void delete(int id) {
        saleRepository.deleteById(id);
    }
}