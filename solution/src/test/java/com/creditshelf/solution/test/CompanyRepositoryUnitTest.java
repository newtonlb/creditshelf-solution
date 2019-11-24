package com.creditshelf.solution.test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import com.creditshelf.solution.model.Company;
import com.creditshelf.solution.model.CompanyRepository;
import com.creditshelf.solution.model.Product;
import com.creditshelf.solution.model.ProductRepository;
import com.creditshelf.solution.model.Sale;
import com.creditshelf.solution.model.SaleRepository;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryUnitTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
 
    @Autowired
    private SaleRepository saleRepository;
 
    // write test cases here
    @Test
    public void whenFindByCompanyName_thenReturnSale() {
        // given
        Sale mock = new Sale()
        .companyName("test company")
        .orderDate(LocalDate.now())
        .orderNumber((long)1);


        entityManager.persist(mock);
        entityManager.flush();
    
        // when
        List<Sale> found = saleRepository.findSalesByCompanyName("test company");
        // then
        assertThat(found.get(0).toString())
      .isEqualTo(mock.toString());
}
 
}