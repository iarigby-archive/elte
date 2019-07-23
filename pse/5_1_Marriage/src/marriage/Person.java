package marriage;

public class Person {
	private Sex sex;
	private String name;
	private String personalID;
	private String address;
	private Person spouse;
	private boolean isMarried;
	
	public Person(Sex sex, String name, String personalID, String address) {
		this.sex = sex;
		this.name = name;
		this.personalID = personalID;
		this.address = address;
		
		isMarried = false;
	}
	
	public Person getSpouse() {return spouse;}
	
	public String getName() {return name;}
	
	public void changeMaritalStatus() {isMarried = !isMarried;}
	
	public boolean isMarried() {return isMarried;}
	
	public Sex getSex() {return sex;}
}
