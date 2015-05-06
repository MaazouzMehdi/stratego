package be.ac.umons.stratego.pion;
import be.ac.umons.stratego.plateau.PlateauBase;

public class SpecialPion extends Pion {

    public SpecialPion ( int lvl , int posY , int posX , String equipe ) {
		super(lvl, posY, posX, equipe);
    }

	public static SpecialPion conversion ( String quase, int y , int x ) {
  		if (quase.equals("SC-F"))
        	return new Scout(2,y,x,"Friend");
  		else
  			return new Scout(2,y,x,"Ennemy");
	}

}




