package com.creditshelf.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creditshelf.solution.model.ResponseDTO;

import com.creditshelf.solution.service.SalesByCompanyService;


@Controller
public class SalesController {
    @Autowired
    SalesByCompanyService salesByCompanyService;


    @RequestMapping(value = "/sales", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private ResponseDTO getSalesByCompany( @RequestParam("companyName") String companyName) {
        return new ResponseDTO().response(salesByCompanyService.getAllSalesByCompany(companyName));
    }



}