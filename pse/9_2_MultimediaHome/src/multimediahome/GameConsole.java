/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , First test
>
> %% 2017.11.14
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> First test of the Practical Software Engineering course.
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

package multimediahome;

public class GameConsole implements Cable{
	private String currentGame;
	private boolean powerOn;
	
	private final CableType type = CableType.HDMI;
	
	
	public void turnOn() {powerOn = true;}
	public void turnOff() {
		powerOn = false;
		currentGame = "";
	}
	
	public void loadGame(String game) {
		if (powerOn)
			currentGame = game;
	}
	
	public String getSignal() {
		if (powerOn) {
			if (null == currentGame) {
				return "No game loaded";
			} else {
				return currentGame;
			}
		} else {
			return "No Signal";
		}
	}
	
	public CableType getCableType() {return type;}

}
