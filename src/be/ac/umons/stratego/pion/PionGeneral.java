package be.ac.umons.stratego.pion;

import be.ac.umons.stratego.plateau.PlateauBase;

public class PionGeneral extends Pion {

    public PionGeneral ( int lvl , int posY , int posX , String equipe ) { // MAJ
	    this.lvl = lvl;
	    this.posY = posY;
        this.posX = posX;
        this.equipe=equipe;
    }

    @Override
    public boolean deplacement(Direction direction, PlateauBase plateau, int number) {
        return super.deplacement(direction, plateau, 1);

    }
}
