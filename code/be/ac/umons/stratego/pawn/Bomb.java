package be.ac.umons.stratego.pawn;

public class Bomb extends PawnNoMove {

	public Bomb ( int posY, int posX , String squad) {
		super(42, posY, posX, squad);
        }
                                                                                                             
	public String toString() {
		return "BOMB";
	}
}
