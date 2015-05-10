package be.ac.umons.stratego.pion;

import be.ac.umons.stratego.plateau.PlateauBase;

public class PionGeneral extends Pion {

    public PionGeneral ( int lvl , int posY , int posX , String equipe ) { // MAJ
        super(lvl, posY, posX, equipe);
    }

    @Override
    public boolean deplacement(Direction direction, PlateauBase plateau, int number) {
        return super.deplacement(direction, plateau, 1);

    }


}
