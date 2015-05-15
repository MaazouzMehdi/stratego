package be.ac.umons.stratego.pawn;

public class Scout extends Pawn {

	public Scout ( int posY, int posX , String squad) { // Peut on faire dans les paramètres ( int lvl = 2 ) ?
		super(2, posY, posX, squad);
        }

	public String toString() {
		return "SCOUT";
	}

}
