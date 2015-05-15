package be.ac.umons.stratego.pawn;

import be.ac.umons.stratego.board.BaseBoard;

public class PawnNoMove extends Pawn {
	/**
	 * the Flag and the Bomb objects extends this class because they don't move( see Stratego rules)
	 */
    public PawnNoMove ( int lvl , int posY , int posX , String equipe ) { // MAJ : ici p-t nbre spécial ( exemple : 42 ou 867645564 )
		super(lvl, posY, posX, equipe);
    }

	public boolean deplacementPossible (Direction direction , BaseBoard plateau , int number){
		return false;
	}


}
