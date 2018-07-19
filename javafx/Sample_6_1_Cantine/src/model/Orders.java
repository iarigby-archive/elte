package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private Menu menu;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Orders() {
	}

	public Orders(Customer customer, Menu menu, Date date) {
		this.customer = customer;
		this.menu = menu;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Menu getMenu() {
		return menu;
	}

	public Date getDate() {
		return date;
	}

}
