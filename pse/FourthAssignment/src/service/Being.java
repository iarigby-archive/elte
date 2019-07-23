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

public abstract class Being {
	private String name;
	private int waterSupply;
	protected int maxValue;
	private int distanceMade;
	
	private boolean isAlive;
	
	protected int waterSunny;
	protected int waterCloudy;
	protected int waterRainy;
	
	protected int distanceSunny;
	protected int distanceCloudy;
	protected int distanceRainy;
	
	public Being(String name, int waterSupply, String type) {
		this.name = name;
		this.waterSupply = waterSupply;
		this.distanceMade = 0;
		this.isAlive = true;
	}
	
	public void tryMove(Day day) {
		if (isAlive) {
			if (day == Day.SUNNY) {
				supplyChange(waterSunny);
				move(distanceSunny);
			} else if (day == Day.CLOUDY) {
				supplyChange(waterCloudy);
				move(distanceCloudy);
			} else if (day == Day.RAINY) {
				this.supplyChange(waterRainy);
				move(distanceRainy);
			}
			System.out.println(this);
		}
	}
	
	public void supplyChange(int water) {
		if(waterSupply + water < 0) {
			isAlive = false;
			waterSupply = 0;
		} else if (waterSupply + water <= maxValue) {
			waterSupply += water;
		} else {
			waterSupply = maxValue;
		}	
	}
	
	public void move(int distance) {
		if (isAlive && waterSupply >=0) {
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
