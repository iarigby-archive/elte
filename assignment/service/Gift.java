package service;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Gift {
	String name;
	String description;
	Date date;
	

	public Gift(String name, String description, Date date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}

	@Override
	public String toString() {
		return description + " was given by " + name + " on " + date;
	
	}
 
}