package jUnit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import gameTubes.Aquarium;
import gameTubes.Coin;
import gameTubes.Guppy;
import gameTubes.Main;
import gameTubes.Piranha;

public class PiranhaTest {
	@Test
	public void deathTest() {
		Aquarium aquarium = new Aquarium();
		Piranha piranha = new Piranha(500, 500, 6);
		
		aquarium.insertCreature(piranha);
		piranha.death(aquarium);
		
		assertEquals("failure - guppy not removed yet", aquarium.getCreatures().getFirst(), null);
	}
	
	@Test
	public void spawnCoinTest() {
		Aquarium aquarium = new Aquarium();
		Piranha piranha = new Piranha(500, 500, 6);
		
		piranha.spawnCoin(aquarium);
		assertEquals("failure - piranha not spawn anything or wrong coin", 
				((Coin)aquarium.getItems().getFirst().getData()).getValue(), 
				Main.goldValue);
	}
	
	@Test
	public void moveTest() {
		Aquarium aquarium = new Aquarium();
		Piranha piranha = new Piranha(500, 500, 6);
		piranha.setHunger(1500);
		
		aquarium.insertCreature(piranha);
		piranha.move(aquarium);
		assertEquals("failure - piranha must removed due to hunger", aquarium.getCreatures().getFirst(), null);
	}
	
	@Test
	public void eatTest() {
		Aquarium aquarium = new Aquarium();
		Guppy guppy = new Guppy(500, 500, 6);
		Piranha piranha = new Piranha(500, 500, 6);
		
		aquarium.insertCreature(guppy);
		
		piranha.eat(aquarium);
		assertEquals("failure - guppy not eated", aquarium.getCreatures().getFirst(), null);
	}
}
