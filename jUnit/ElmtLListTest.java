package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import gameTubes.ElmtLList;
import gameTubes.Guppy;

public class ElmtLListTest {

    @Test
    public void testGetData() {
        Guppy G = new Guppy(100,100,0);
        ElmtLList<Guppy> E = new ElmtLList<Guppy>(G);
        assertEquals(true, E.getData().getX() == 100);
    }

    @Test
    public void testSetData() {
        Guppy G = new Guppy(100,100,0);
        ElmtLList<Guppy> E = new ElmtLList<Guppy>(G);
        E.getData().setX(200);
        assertEquals(true, E.getData().getX() == 200);
    }

}
