package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 128)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Country> countries;
	
	public Language(String name, Set<Country> countries) {
		this.name = name;
		this.countries = countries;
	}
	
	public Language(String name) {
		this.name = name;
	}

	public Language() {
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Country> getCountries() {
		return countries;
	}
	
}
