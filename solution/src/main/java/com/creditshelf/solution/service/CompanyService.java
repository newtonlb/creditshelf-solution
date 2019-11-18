package com.creditshelf.solution.service;

import java.util.ArrayList;
import java.util.List;

import com.creditshelf.solution.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
@Autowired
CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        companyRepository.findAll().forEach(company -> companies.add(company));
        return companies;
    }

    public Company getCompanyById(int id) {
        return companyRepository.findById(id).get();
    }

    public void saveOrUpdate(Company company) {
        companyRepository.save(company);
    }

    public void delete(int id) {
        companyRepository.deleteById(id);
    }
}