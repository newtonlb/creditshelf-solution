package com.creditshelf.solution.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CSVDictionaryRepository extends CrudRepository<CSVDictionary, Integer> {
    @Query("SELECT p FROM CSVDictionary p WHERE p.column=?1")
    public CSVDictionary findTranslatedColumn(String column);
}