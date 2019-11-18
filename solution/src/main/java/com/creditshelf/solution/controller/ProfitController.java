package com.creditshelf.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.creditshelf.solution.model.ResponseDTO;
import com.creditshelf.solution.service.ProfitReportService;


@Controller
public class ProfitController {
    @Autowired
    ProfitReportService profitReportService;


    @RequestMapping(value = "/profitReport", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private ResponseDTO getrevenuesReportByCompany( @RequestParam("companyName") String companyName) {
        return new ResponseDTO().response(profitReportService.getProfitReportByCompany(companyName));
    }



}