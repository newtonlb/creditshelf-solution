package com.creditshelf.solution.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SalesByCompanyRepository extends CrudRepository<Sale, Integer> {
    // @Query("SELECT * FROM (SELECT P.COMPANY_NAME, P.ORDER_ID, P.CURRENCY, P.PRODUCT_ID, P.QUANTITY, S.ORDER_DATE FROM PRODUCT_SALES P, SALE S WHERE  (P.ORDER_ID=S.ORDER_NUMBER  AND P.COMPANY_NAME=S.COMPANY_NAME)) A WHERE A.COMPANY_NAME=?1 ORDER BY A.ORDER_ID")
    // List<Sale> findUserByStatusNative(String companyName);
}