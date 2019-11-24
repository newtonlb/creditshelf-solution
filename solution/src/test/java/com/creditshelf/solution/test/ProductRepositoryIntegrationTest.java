package com.creditshelf.solution.test;

import static org.assertj.core.api.Assertions.*;

import com.creditshelf.solution.model.Product;
import com.creditshelf.solution.model.ProductRepository;

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
public class ProductRepositoryIntegrationTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
 
    @Autowired
    private ProductRepository productRepository;
 
    // write test cases here
    @Test
    public void whenFindByCompanyAndId_thenReturnProduct() {
        // given
        Product mock = new Product()
        .companyName("test Company")
        .cost("15.00")
        .currency("USD")
        .name("test product")
        .id((long)1);

        entityManager.persist(mock);
        entityManager.flush();
    
        // when
        Product found = productRepository.findProductByIdAndCompany(mock.getCompany(), mock.getId());
    
        // then
        assertThat(found.toString())
      .isEqualTo(mock.toString());
}
 
}