package com.creditshelf.solution.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.companyName=?1 AND p.Id=?2")
    public Product findProductByIdAndCompany(String company, long Id);

    
}