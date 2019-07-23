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

public class SetTopBox implements Cable {

	private final CableType type = CableType.COAX;
	private TVChannel currentChannel;
	
	private Map<Integer, TVChannel> channels = new HashMap<Integer, TVChannel>();
	
	public void addTVChannel(TVChannel channel) {
		channels.put(channel.getFrequency(), channel);
	}
	
	public String getSignal() {
		if (null == currentChannel) {
			return "NO SIGNAL";
		}
		return currentChannel.getName();
	}
	
	public CableType getCableType() {
		return type;
	}
	
	public TVChannel changeChannel(int frequency) {
		if (channels.containsKey(frequency)) {
			currentChannel = channels.get(frequency);
			return channels.get(frequency);
		}
		return null;
	}
}
