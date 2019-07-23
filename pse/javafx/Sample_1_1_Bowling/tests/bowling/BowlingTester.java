package bowling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.Before;

public class BowlingTester {

	Game g;
	
	private void rollMany (int n, int pins) {
		for (int i = 0; i < n; i++ ) {
			g.roll(pins);
		}
	}
	
	@Before
	public void setup() {
		g = new Game();
	}

	
	@Test
	public void canRoll() throws Exception {
		g.roll(0);
	}
	
	@Test
	public void gutterGame() throws Exception {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	@Test
	public void allOnes() throws Exception {
		rollMany(20, 1);
		assertEquals(20, g.score());
	}
	
 
	@Test
	public void oneSpare() throws Exception {
		g.roll(5);
		g.roll(5);
		g.roll(3);
		rollMany(17,0);
		assertEquals(16, g.score());
	}
	
	
}
