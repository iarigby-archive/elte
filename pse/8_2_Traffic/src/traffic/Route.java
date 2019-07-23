package traffic;

import java.util.*;

public class Route {
	
	private List<BusStop> busStops = new ArrayList<BusStop>();
	
	public Route addStop(BusStop stop) {
		busStops.add(stop);
		return this;
	}
	
	public void travelByBus(Bus bus) {
		for (BusStop busStop : busStops) {
			System.out.println("accepted");	
			busStop.acceptBus(bus);
		}
	}
	
}
