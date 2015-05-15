package be.ac.umons.stratego.pawn;

import be.ac.umons.stratego.plateau.BaseBoard;

public class PawnGeneral extends Pawn {

    public PawnGeneral ( int lvl , int posY , int posX , String equipe ) { // MAJ
        super(lvl, posY, posX, equipe);
    }

    public boolean deplacement(Direction direction, BaseBoard plateau) {
        return super.deplacement(direction, plateau, 1);

    }

    public boolean deplacement(Direction direction, BaseBoard plateau, int cases) {
        return super.deplacement(direction, plateau, 1);

    }
}
