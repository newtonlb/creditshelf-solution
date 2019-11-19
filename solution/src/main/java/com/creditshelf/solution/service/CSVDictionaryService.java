package com.creditshelf.solution.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.annotation.PostConstruct;

import com.creditshelf.solution.model.CSVDictionary;
import com.creditshelf.solution.model.CSVDictionaryRepository;
import com.creditshelf.solution.model.ConversionRates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CSVDictionaryService {
    
    @Autowired
    CSVDictionaryRepository csvDictionaryRepository;
    
    @PostConstruct
    public void populateDictionaryTable() {
        String[] idsAlias = {"Product Id", "Id", "Prod. Id"};
        // Name alias
        String[] nameAlias = {"Description", "Product", "Name"};

        String[] costAlias = {"Assembly cost", "Purchase price", "Build cost"};

        if (csvDictionaryRepository == null) {
            System.out.println("REPOSITORY IS NULL!");
        }
        for(String alias : idsAlias) {
            CSVDictionary entry = new CSVDictionary().column(alias).translatedColumn("Id");
            csvDictionaryRepository.save(entry);
        }
        for(String alias : nameAlias) {
            CSVDictionary entry = new CSVDictionary().column(alias).translatedColumn("name");
            csvDictionaryRepository.save(entry);
        }
        for(String alias : costAlias) {
            CSVDictionary entry = new CSVDictionary().column(alias).translatedColumn("cost");
            csvDictionaryRepository.save(entry);
        }

    }
    public String getTranslatedHeaderField(String column) {
        System.out.println(column);
        CSVDictionary csvDictionary = csvDictionaryRepository.findTranslatedColumn(column);
        return csvDictionary.getTranslatedColumn();
    }

}