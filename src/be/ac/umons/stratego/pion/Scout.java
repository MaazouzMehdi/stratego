package be.ac.umons.stratego.pion;

public class Scout extends Pion {

	public Scout ( int posY, int posX , String equipe) { // Peut on faire dans les paramètres ( int lvl = 2 ) ?
		super(2, posY, posX, equipe);
        }

	public String toString() {
		return "SC";
	}

}
