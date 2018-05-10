package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import gameTubes.Aquarium;
import gameTubes.Guppy;
import gameTubes.Item;
import gameTubes.Pellet;

public class AquariumTest {

	@Test
	public void testAquarium1() {
		Aquarium aquarium = new Aquarium();
		Item i = new Pellet(100,100);
		aquarium.insertItem(i);
		assertEquals(true, aquarium.getItems().getFirst().getData().getX()==100);
	}

	@Test
	public void testAquarium2() {
		Aquarium aquarium = new Aquarium();
		Guppy g = new Guppy(50,100,1);
		aquarium.insertCreature(g);
		assertEquals(true, aquarium.getCreatures().getFirst().getData().getX()==50);
	}
}
