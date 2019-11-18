package com.creditshelf.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.creditshelf.solution.model.Company;
import com.creditshelf.solution.model.Product;
import com.creditshelf.solution.model.ProductSales;
import com.creditshelf.solution.model.ResponseDTO;
import com.creditshelf.solution.model.RevenueReportDTO;
import com.creditshelf.solution.model.Sale;
import com.creditshelf.solution.model.SalesByCompanyDTO;
import com.creditshelf.solution.service.CompanyService;
import com.creditshelf.solution.service.ProductSalesService;
import com.creditshelf.solution.service.ProductService;
import com.creditshelf.solution.service.RevenuesReportService;
import com.creditshelf.solution.service.SaleService;
import com.creditshelf.solution.service.SalesByCompanyService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class RevenuesController {
    @Autowired
    RevenuesReportService revenuesReportService;


    @RequestMapping(value = "/revenuesReport", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    private ResponseDTO getrevenuesReportByCompany( @RequestParam("companyName") String companyName) {
        return new ResponseDTO().response(revenuesReportService.getRevenueReportByCompany(companyName));
    }



}