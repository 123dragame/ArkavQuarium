package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import gameTubes.Aquarium;
import gameTubes.Pellet;

public class PelletTest {

	@Test
	public void testPellet() {
		Aquarium aquarium = new Aquarium();
		Pellet p = new Pellet(500, 500);
		aquarium.insertItem(p);
		assertEquals(true, aquarium.getItems().getFirst().getData().getX()==500);
	}

	@Test
    public void testIsOnLand() {
	    Pellet p = new Pellet(500, 0);
	    assert(p.isOnLand());
	}
}
