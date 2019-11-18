package com.creditshelf.solution.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
	@Id   
	@Column(name="name")
	private String name;

	public Company() {
	}

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Company)) {
			return false;
		}
		Company company = (Company) o;
		return Objects.equals(name, company.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}

	@Override
	public String toString() {
		return "{" +
			" name='" + getName() + "'" +
			"}";
	}
	
}