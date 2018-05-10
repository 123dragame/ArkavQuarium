package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import gameTubes.Guppy;
import gameTubes.LList;

public class LListTest {

    @Test
    public void testGetFirst() {
        LList<Guppy> L = new LList<Guppy>();
        assertEquals(true, L.getFirst() == null);
    }

    @Test
    public void testIsEmpty() {
        LList<Guppy> L = new LList<Guppy>();
        assert(L.isEmpty());
    }

    @Test
    public void testGet() {
        LList<Guppy> L = new LList<Guppy>();
        Guppy G = new Guppy(100,100,200);
        L.add(G);
        assertEquals(true, L.get(0) == G);
    }

    @Test
    public void testFind() {
        LList<Guppy> L = new LList<Guppy>();
        Guppy G = new Guppy(100, 0, 0);
        assertEquals(true, L.find(G) == -1);
    }

}
