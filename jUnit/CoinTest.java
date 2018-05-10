package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import gameTubes.Aquarium;
import gameTubes.Coin;

public class CoinTest {

	@Test
	public void testCoin() {
		Aquarium aquarium = new Aquarium();
		Coin c = new Coin(500, 500, 100);
		aquarium.insertItem(c);
		
		assertEquals(true, aquarium.getItems().getFirst().getData().getX()==500);
	}

	@Test
	public void testGetValue() {
		Coin c = new Coin(500, 500, 100);
		
		assertEquals(100, c.getValue());
	}
	
	@Test
    public void testIsOnLand() {
        Coin p = new Coin(500, 0, 50);
        assert(p.isOnLand());
    }

}
