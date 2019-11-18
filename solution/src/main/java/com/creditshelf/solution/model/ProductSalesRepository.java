package com.creditshelf.solution.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductSalesRepository extends CrudRepository<ProductSales, Integer> {
    @Query("SELECT p FROM ProductSales p WHERE p.companyName= ?1 AND p.orderId=?2")
    public List<ProductSales> findProductsSalesByOrderAndCompany(String company, long order);
}