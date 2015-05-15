package be.ac.umons.stratego.pawn;

import be.ac.umons.stratego.board.BaseBoard;

/**
 * All the pawns that move except the Scout extends this class
 */
public class PawnGeneral extends Pawn {

    public PawnGeneral ( int lvl , int posY , int posX , String equipe ) { // MAJ
        super(lvl, posY, posX, equipe);
    }

    /**
     *do a deplacement of one cell ( see Stratego rules about the differents pawns)
     */
    public boolean deplacement(Direction direction, BaseBoard plateau) {
        return super.deplacement(direction, plateau, 1);

    }

    public boolean deplacement(Direction direction, BaseBoard plateau, int cases) {
        return super.deplacement(direction, plateau, 1);

    }
}
