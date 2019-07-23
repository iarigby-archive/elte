/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Fourth Assignment
>
> %% 2017.10.15
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Fourth assignment of the Practical Software Engineering course.
>
> %% I declare that this solution is my own work.
>
> %% I have not copied or used third party solutions.
>
> %% I have not passed my solution to my classmates, neither  made it public.
>
> %% Students’ regulation of Eötvös Loránd University (ELTE Regulations
> Vol. II. 74/C. § ) states that as long as a student presents another
> student’s work - or at least the significant part of it - as his/her own
> performance, it will count as a disciplinary fault. The most serious

> consequence of a disciplinary fault can be dismissal of the student from
> the University."

*/

package service;
import java.util.HashMap;

public abstract class Being {
	private String name;
	private int waterSupply;
	private int maxSupply;
	private boolean isAlive;
	private int distanceMade;
	
	private HashMap< Day, Integer> waterValues;
	private HashMap< Day, Integer > distanceValues;
	
	public Being(String name, int waterSupply, int maxSupply, int[] waterValues, int[] distanceValues){
		
		this.name = name;
		this.waterSupply = waterSupply;
		this.maxSupply = maxSupply;
				
		this.waterValues = new HashMap<Day, Integer>();
		this.waterValues.put(Day.SUNNY, waterValues[0]);
		this.waterValues.put(Day.CLOUDY, waterValues[1]);
		this.waterValues.put(Day.RAINY, waterValues[2]);
		
		this.distanceValues = new HashMap<Day, Integer>();
		this.distanceValues.put(Day.SUNNY, distanceValues[0]);
		this.distanceValues.put(Day.CLOUDY, distanceValues[1]);
		this.distanceValues.put(Day.RAINY, distanceValues[2]);
		
		isAlive = true;
		distanceMade = 0;

	}
	
	public void tryMove(Day day) {
		if (isAlive) {
			supplyChange(waterValues.get(day));
			move(distanceValues.get(day));
			System.out.println(this);
		}
		
	}
	
	public void supplyChange(int water) {
		if (waterSupply + water < 0) {
			isAlive = false;
			waterSupply = 0;
		} else if (waterSupply + water > maxSupply) {
			waterSupply = maxSupply;
		} else {
			waterSupply += water;
		}
	}
	
	public void move(int distance) {
		if (isAlive && waterSupply >= 0) {
			distanceMade += distance;
		}
	}
	
	public String toString() {
		String alive = "";
		if (!isAlive) {
			alive = "not ";
		}
		return name + " is " + alive + "alive, waterSupply is " + waterSupply + " and distance is " + distanceMade;
	}
	
}
