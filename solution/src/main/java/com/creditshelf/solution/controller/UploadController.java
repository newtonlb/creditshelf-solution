package com.creditshelf.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.creditshelf.solution.model.Company;
import com.creditshelf.solution.model.Product;
import com.creditshelf.solution.model.ProductSales;
import com.creditshelf.solution.model.Sale;
import com.creditshelf.solution.service.CompanyService;
import com.creditshelf.solution.service.ProductSalesService;
import com.creditshelf.solution.service.ProductService;
import com.creditshelf.solution.service.SaleService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class UploadController {
    @Autowired
    ProductService productService;

    @Autowired
    CompanyService companyService;
    
    @Autowired
    SaleService saleService;

    @Autowired
    ProductSalesService productSalesService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            System.out.println("file name: " + file.getName());
            String companyName = FilenameUtils.removeExtension(file.getOriginalFilename());
            Company company = new Company(companyName);
            companyService.saveOrUpdate(company);
            //CSVReader csvReader = new CSVReader();
            CsvToBean<Product> csvToBean = new CsvToBeanBuilder(new InputStreamReader(file.getInputStream()))
                    .withType(Product.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            
                    Iterator<Product> csvUserIterator = csvToBean.iterator();

                    while (csvUserIterator.hasNext()) {
                        Product product = csvUserIterator.next();
                        product.setCompany(companyName);
                        System.out.println(product);
                        productService.saveOrUpdate(product);
                        
                    }
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }


    @PostMapping("/uploadSales") // //new annotation since 4.3
    public String saleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            System.out.println("file name: " + file.getName());
            

            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(file.getInputStream())).withSkipLines(1).build();
            // Reading Records One by One in a String array
            String[] nextRecord;
            long orderNumber = -1;
            String companyName = "";
            Date orderDate = new Date();
            while ((nextRecord = csvReader.readNext()) != null) {
                if(!nextRecord[0].isEmpty() && !nextRecord[1].isEmpty() && !nextRecord[2].isEmpty()) {
                    System.out.println("new order");
                    
                    try {
                        orderDate = new SimpleDateFormat("MM/dd/yy").parse(nextRecord[1]);
                    } catch(ParseException e) {
                        e.printStackTrace();
                    }
                    //Storing variables for next rows
                    orderNumber = Integer.parseInt(nextRecord[2]);
                    companyName = nextRecord[0];
                    
                    //Create sale object
                    Sale sale = new Sale().
                    companyName(companyName)
                    .orderDate(orderDate)
                    .orderNumber(orderNumber);
                    
                    //insert into DB
                    saleService.saveOrUpdate(sale);

                    ProductSales productSale  = new ProductSales()
                    .companyName(companyName)
                    .orderId(orderNumber)
                    .productId(Integer.parseInt(nextRecord[3]))
                    .quantity(Integer.parseInt(nextRecord[4]))
                    .currency(nextRecord[6])
                    .salePrice(new BigDecimal(nextRecord[5].replace(',','.')));

                    System.out.println(productSale);
                    productSalesService.saveOrUpdate(productSale);

                }
                else {
                    ProductSales productSale  = new ProductSales()
                    .companyName(companyName)
                    .orderId(orderNumber)
                    .productId(Integer.parseInt(nextRecord[3]))
                    .quantity(Integer.parseInt(nextRecord[4]))
                    .currency(nextRecord[6])
                    .salePrice(new BigDecimal(nextRecord[5].replace(',','.')));

                    System.out.println(productSale);

                    productSalesService.saveOrUpdate(productSale);
                }
                System.out.println("company name : " + nextRecord[0]);
                System.out.println("Order date : " + nextRecord[1]);
                System.out.println("Order number : " + nextRecord[2]);
                System.out.println("Product Id : " + nextRecord[3]);
                System.out.println("Quantity : " + nextRecord[4]);
                System.out.println("Sale price : " + nextRecord[5]);
                System.out.println("Currency : " + nextRecord[6]);
                System.out.println("==========================");
            }
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");


        
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "redirect:/uploadStatus";
}
    
    private Object SimpleDateFormat(String string) {
        return null;
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}