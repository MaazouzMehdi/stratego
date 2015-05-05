package be.ac.umons.stratego.pion;

public class PionNoMove extends Pion {

    public PionNoMove ( int lvl , int posY , int posX , String equipe ) { // MAJ : ici p-t nbre spécial ( exemple : 42 ou 867645564 )
	    this.lvl = lvl;
	    this.posY = posY;
        this.posX = posX;
        this.equipe=equipe;
    }
    

	public boolean deplacementPossible (){
		return false;
	}

}
