package com.creditshelf.solution.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CSVDictionary {
    @Id
    String column;
    
    String translatedColumn;


    public CSVDictionary() {
    }

    public CSVDictionary(String column, String translatedColumn) {
        this.column = column;
        this.translatedColumn = translatedColumn;
    }

    public String getColumn() {
        return this.column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getTranslatedColumn() {
        return this.translatedColumn;
    }

    public void setTranslatedColumn(String translatedColumn) {
        this.translatedColumn = translatedColumn;
    }

    public CSVDictionary column(String column) {
        this.column = column;
        return this;
    }

    public CSVDictionary translatedColumn(String translatedColumn) {
        this.translatedColumn = translatedColumn;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CSVDictionary)) {
            return false;
        }
        CSVDictionary cSVDictionary = (CSVDictionary) o;
        return Objects.equals(column, cSVDictionary.column) && Objects.equals(translatedColumn, cSVDictionary.translatedColumn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, translatedColumn);
    }

    @Override
    public String toString() {
        return "{" +
            " column='" + getColumn() + "'" +
            ", translatedColumn='" + getTranslatedColumn() + "'" +
            "}";
    }

}