package be.ac.umons.stratego.pion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marco on 10/05/15.
 */
public class CellObjectTest {
    @Test
    public void singleton() {
        CellObject first = CellObject.MARECHAL;
        CellObject second = CellObject.MARECHAL;
        assertEquals(2, first.posX);
        second.posX = 10;
        assertEquals(2, first.posX);
    }
}