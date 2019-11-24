package com.creditshelf.solution.test;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;


import com.creditshelf.solution.model.ProductSales;
import com.creditshelf.solution.model.ProductSalesRepository;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductSalesRepositoryUnitTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
 
    @Autowired
    private ProductSalesRepository productSaleRepository;
 
    // write test cases here
    @Test
    public void whenFindByCompanyAndId_thenReturnProduct() {
        // given
        ProductSales mock = new ProductSales()
        .companyName("test company")
        .currency("EUR")
        .orderId((long)1)
        .quantity((long)1)
        .salePrice(new BigDecimal("15.00"));
        

        entityManager.persist(mock);
        entityManager.flush();
    
        // when
        List<ProductSales> found = productSaleRepository.findProductsSalesByOrderAndCompany("test company", 1);
    
        // then
        assertThat(found.get(0).toString())
      .isEqualTo(mock.toString());
}
 
}