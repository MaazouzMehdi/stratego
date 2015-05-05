package be.ac.umons.stratego.pion;

import be.ac.umons.stratego.graphic.Pions;

import java.io.Serializable;

/**
 * Created by marco on 5/05/15.
 */
public enum Direction {
    NORTH(0,-1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);


    final int x, y;

    Direction(int nx, int ny) {
        x = nx;
        y = ny;
    }

    public String toString() {
        return super.toString()+", x="+x+", y="+y;
    }
}