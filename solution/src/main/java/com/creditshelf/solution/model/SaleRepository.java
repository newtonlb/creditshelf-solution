package com.creditshelf.solution.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
    @Query("SELECT s FROM Sale s WHERE s.companyName=?1")
    public List<Sale> findSalesByCompanyName(String companyName);
}