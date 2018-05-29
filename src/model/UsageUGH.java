package model;

import java.time.ZonedDateTime;
import java.util.Date;
	
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UsageUGH {

	@Id
	@TableGenerator(name = "Usage_ID_Generator", table = "ID_GEN_Table",
	pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE",
	pkColumnValue = "Usage_ID", initialValue = 1, allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Usage_ID_Generator")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.MERGE})
	private Client client;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.MERGE})
	private Device device;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date logInTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date logOutTime;
	
	private float bill;
	
	private final static int PPH = 5;
	
	public UsageUGH() {
		
	}

	public UsageUGH(Client user, Device device, Date logInTime) {
		this.client = user;
		this.device = device;
		this.logInTime = logInTime;
	}
		
	public UsageUGH(Client user, Device device) {
		this(user, device, Date.from(ZonedDateTime.now().toInstant()));
	}

	public Date getLogOutTime() {
		return logOutTime;
	}

	public void setLogOutTime(Date logOutTime) {
		this.logOutTime = logOutTime;
	}

	public int getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public Device getDevice() {
		return device;
	}

	public Date getLogInTime() {
		return logInTime;
	}
	
	
	public float getBill() {
		return bill;
	}

	public UsageUGH setBill(float bill) {
		this.bill = bill;
		return this;
	}

	public void calculateBill() {
		calculateBill(Date.from(ZonedDateTime.now().toInstant()));
	}
	
	public void calculateBill(Date time) {
		if (time.after(logInTime)) {
			logOutTime = time;
			float diff = logOutTime.getTime() - logInTime.getTime();
			System.out.println(diff);
			System.out.println(diff/(60 * 1000));
			bill = Math.round(PPH  * diff/(60 * 10))/100;
			System.out.println(bill);
		} else {
			System.out.println("sdageaqw");
		}
	}
	
}
