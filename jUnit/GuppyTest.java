package jUnit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import gameTubes.Aquarium;
import gameTubes.Coin;
import gameTubes.Guppy;
import gameTubes.Main;
import gameTubes.Pellet;

public class GuppyTest {
	@Test
	public void deathTest() {
		Aquarium aquarium = new Aquarium();
		Guppy guppy = new Guppy(500, 500, 6);
		
		aquarium.insertCreature(guppy);
		guppy.death(aquarium);
		
		assertEquals("failure - guppy not removed yet", aquarium.getCreatures().getFirst(), null);
	}
	
	@Test
	public void spawnCoinFirstStageTest() {
		Aquarium aquarium = new Aquarium();
		Guppy guppy = new Guppy(500, 500, 6);
		
		guppy.spawnCoin(aquarium);
		assertEquals("failure - wrong coin or coin not inserted", 
				((Coin)aquarium.getItems().getFirst().getData()).getValue(), 
				Main.bronzeValue);
	}
	
	@Test
	public void spawnCoinSecondStageTest() {
		Aquarium aquarium = new Aquarium();
		Guppy guppy = new Guppy(500, 500, 6);
		
		guppy.setStage(2);
		guppy.spawnCoin(aquarium);
		assertEquals("failure - coin not inserted", 
				((Coin)aquarium.getItems().getFirst().getData()).getValue(), 
				Main.silverValue);
	}
	
	@Test
	public void spawnCoinThirdStageTest() {
		Aquarium aquarium = new Aquarium();
		Guppy guppy = new Guppy(500, 500, 6);
		
		guppy.setStage(3);
		guppy.spawnCoin(aquarium);
		assertEquals("failure - coin not inserted", 
				((Coin)aquarium.getItems().getFirst().getData()).getValue(), 
				Main.goldValue);
	}
	
	@Test
	public void moveTest() {
		Aquarium aquarium = new Aquarium();
		Guppy guppy = new Guppy(500, 500, 6);
		guppy.setHunger(1500);
		
		aquarium.insertCreature(guppy);
		guppy.move(aquarium);
		assertEquals("failure - guppy must removed due to hunger", aquarium.getCreatures().getFirst(), null);
	}
	
	@Test
	public void eatTest() {
		Aquarium aquarium = new Aquarium();
		Guppy guppy = new Guppy(500, 500, 6);
		
		aquarium.insertItem(new Pellet(500, 500));
		
		guppy.eat(aquarium);
		assertEquals("failure - pellet not eated", aquarium.getItems().getFirst(), null);
	}
	
	@Test
	public void growTest() {
		Guppy guppy = new Guppy(500, 500, 6);
		guppy.grow();
		assertEquals("failure - grow not increased", 2, guppy.getStage());
	}
}