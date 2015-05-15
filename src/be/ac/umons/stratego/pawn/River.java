package be.ac.umons.stratego.pawn;

import java.io.Serializable;

/**
 * Created by marco on 9/05/15.
 */
public class River implements Serializable {
    int posY;
    int posX;

    public River(int posY, int posX){
        this.posY=posY;
        this.posX=posX;
    }

    @Override
    public String toString() {
        return "RIVER";
    }
}
