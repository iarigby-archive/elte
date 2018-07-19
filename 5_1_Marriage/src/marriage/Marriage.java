package marriage;
import java.util.*;
import marriage.exception.*;

public class Marriage {
	private Person wife;
	private Person husband;
	private Person wifesWitness;
	private Person husbandsWitness;
	private String placeOfMarriage;
	private Date dateOfMarriage;
	
	private boolean sanctioned;
	
	
	ArrayList<WeddingPresent> weddingPresents;
	
	public Marriage(Person spouse1, Person spouse2, Person witness1, Person witness2, String place, Date date) {
		if(spouse1.getSex() == Sex.FEMALE) {
			wife = spouse1;
			husband = spouse2;
		} else {
			husband = spouse1;
			wife = spouse2;
		}
		if (witness1.getSex() == Sex.FEMALE) {
			wifesWitness = witness1;
			husbandsWitness = witness2;
		} else {
			wifesWitness = witness1;
			husbandsWitness = witness2;
		}
		
		placeOfMarriage = place;
		dateOfMarriage = date;
		weddingPresents = new ArrayList<WeddingPresent>();
		sanctioned = false;
	}
	
	public void addWeddingPresent(WeddingPresent gift) { weddingPresents.add(gift); }
	
	public ArrayList<WeddingPresent> getWeddingPresents() { return weddingPresents; }
	
	public void divorce() throws UnmarriedButWannaDivorceException {
		if (!(wife.isMarried() && husband.isMarried())) {
			UnmarriedButWannaDivorceException e = new UnmarriedButWannaDivorceException();
			throw e;
		} else {
			wife.changeMaritalStatus();
			husband.changeMaritalStatus();
		}
	}
	
	public void sanction() throws BigamousPersonException {
		if (wife.isMarried() || husband.isMarried()) {
			BigamousPersonException e = new BigamousPersonException();
			throw e;
		} else {
			wife.changeMaritalStatus();
			husband.changeMaritalStatus();
			sanctioned = true;
		}
		
	}
	
	
	public Person getHusband() {return husband;}
	public Person getWife() {return wife;}
	public Date getDateOfMarriage() {return dateOfMarriage;}
	public String getPlaceOfMarriage() {return placeOfMarriage;}
	public Person getWifesWitness() {return wifesWitness;}
	public Person getHusbandsWitness() {return husbandsWitness;}
}
