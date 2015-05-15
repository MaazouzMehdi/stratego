package be.ac.umons.stratego.pawn;

import be.ac.umons.stratego.plateau.BaseBoard;

public class PawnNoMove extends Pawn {

    public PawnNoMove ( int lvl , int posY , int posX , String equipe ) { // MAJ : ici p-t nbre spécial ( exemple : 42 ou 867645564 )
		super(lvl, posY, posX, equipe);
    }

	public boolean deplacementPossible (Direction direction , BaseBoard plateau , int number){
		return false;
	}


}
