package be.ac.umons.stratego.pion;

import be.ac.umons.stratego.plateau.PlateauBase;

public class PionNoMove extends Pion {

    public PionNoMove ( int lvl , int posY , int posX , String equipe ) { // MAJ : ici p-t nbre spécial ( exemple : 42 ou 867645564 )
		super(lvl, posY, posX, equipe);
    }

	public boolean deplacementPossible (Direction direction , PlateauBase plateau , int number){
		return false;
	}


}
