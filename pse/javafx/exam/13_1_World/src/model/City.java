package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {
	@Id
	private String name;
	
	private int population;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;
	
	
	
	public City(String name, int population, Country country) {
		this.name = name;
		this.population = population;
		this.country = country;
	}

	public City(String name, int population) {
		this.name = name;
		this.population = population;
	}
	
	public City() {
		
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public Country getCountry() {
		return country;
	}

	
}
