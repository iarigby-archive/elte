package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 128)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Continent continent;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Language> languages;
	
	@OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private Set<City> cities;
	
	public Country(String name, Continent continent, Set<Language> languages) {
		this.name = name;
		this.continent = continent;
		this.languages = languages;
	}

	public Country() {
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Continent getContinent() {
		return continent;
	}

	public Set<Language> getLanguages() {
		return languages;
	}
	
	

}
