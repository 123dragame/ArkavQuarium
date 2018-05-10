/**
 * 
 */
package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import gameTubes.Aquarium;
import gameTubes.Coin;
import gameTubes.Snail;

/**
 * @author seldi
 *
 */
public class SnailTest {

	/**
	 * Test method for {@link gameTubes.Snail#move(gameTubes.Aquarium)}.
	 */
	@Test
	public void testMove() {
		Aquarium aquarium = new Aquarium();
		Coin c = new Coin(500, 500, 100);
		Snail s = new Snail(0,0,1);
		aquarium.insertItem(c);
		aquarium.insertCreature(s);
		s.move(aquarium);
		s.move(aquarium);
		s.move(aquarium);
		assertEquals(true, aquarium.getCreatures().getFirst().getData().getX()>0);
	}

	/**
	 * Test method for {@link gameTubes.Snail#eat(gameTubes.Aquarium)}.
	 */
	@Test
	public void testEat() {
		Aquarium aquarium = new Aquarium();
		Coin c = new Coin(500, 500, 100);
		Snail s = new Snail(500, 500, 1);
		
		aquarium.insertCreature(s);
		aquarium.insertItem(c);
		
		s.eat(aquarium);
		assertEquals("failure - guppy not eated", aquarium.getItems().getFirst(), null);
	}

}
