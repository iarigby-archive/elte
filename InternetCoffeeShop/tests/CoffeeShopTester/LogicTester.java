package CoffeeShopTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Test;

import model.Client;
import model.Device;
import model.UsageUGH;

public class LogicTester {
	
	@Test
	public void calculateBills() {
		calculateBill(60);
	}
	
	private void calculateBill(int minutes) {
		Date now = Date.from(ZonedDateTime.now().toInstant());
		UsageUGH usage = new UsageUGH(new Client(), new Device(), now);
		usage.calculateBill(new Date((long) (now.getTime() + minutes*1000)));
		assertEquals(5*minutes/60, usage.getBill());
	}
	
}
