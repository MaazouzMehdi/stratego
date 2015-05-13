package be.ac.umons.stratego.pion;

import be.ac.umons.stratego.plateau.PlateauBase;

/**
 * Created by marco on 9/05/15.
 */
public class River {
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
