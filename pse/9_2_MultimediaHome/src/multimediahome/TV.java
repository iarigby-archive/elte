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

import java.util.Map;
import java.util.HashMap;

public class TV {

	private Map<Integer, Integer> channelMappings = new HashMap<Integer, Integer>();
	
	private Cable coaxInput;
	private Cable hdmiInput;
	private boolean currentIntputIsCoax;
	private boolean powerOn;
	private int volume;
	
	public TV() {
		currentIntputIsCoax = true;
		volume = 5;
	}
	
	public void showPicture() {
		String signal;
		String cable;
		
		if (currentIntputIsCoax) {
			cable = "Coax";
			if (null == coaxInput) {
				signal = "NO SIGNAL";
			} else {
				signal = coaxInput.getSignal();
			}
		} else {
			cable = "HDMI";
			if (null == hdmiInput) {
				signal = "NO SIGNAL";
			} else {
				signal = hdmiInput.getSignal();
			}
		}
		
		System.out.println("Display[" + cable + "]: " + signal);
	}
	
	public void switchInput() {
		currentIntputIsCoax = !currentIntputIsCoax;			
	}
	
	public void autoTuneChannels() {
		if (currentIntputIsCoax) {
			channelMappings.clear();
			int j = 1;
			for (int i = 0; i <= 10; i++) {
				System.out.print("Tuning... frequency=" + i + "...");
				if (null != coaxInput && null != ((SetTopBox) coaxInput).changeChannel(i)) {
					channelMappings.put(j, i);
					j++;
					System.out.print(" added " + ((SetTopBox)coaxInput).getSignal() + " to Channel-" + j);
				}
				System.out.println();
			}
			changeChannel(1);
			showPicture();
			
		} else {
			System.out.println("Auto tune on HDMI is not supported");
		}
	}
	
	public void changeChannel(int channelNum) {
		if (currentIntputIsCoax) {
			if (null == coaxInput) {
				System.out.println("No channels found. Did you plug a coax cable in?");
			} else {
				((SetTopBox) coaxInput).changeChannel(channelMappings.get(channelNum)); 
			}
		} else {
			System.out.println("Channel change on HDMI is not supported");
		}
	}
	
	public void increaseVolume() {
		if (volume < 10) 
			volume++;
		System.out.println("Volume: " + volume);
	}
	
	public void decreaseVolume() {
		if (volume > 0)
			volume--;
		System.out.println("Volume: " + volume);
	}
	
	public void turnOn() {
		powerOn = true;
		System.out.println("TV turned on. Volume: " + volume);
		showPicture();
	}
	
	public void turnOff() {
		powerOn = false;
		System.out.println("TV turned off;");
	}
	
	public void pluginCable(Cable cable) {
		if (cable.getCableType().equals(CableType.COAX)) {
			coaxInput = cable;
		} else {
			hdmiInput = cable; 
		}
	}
}
