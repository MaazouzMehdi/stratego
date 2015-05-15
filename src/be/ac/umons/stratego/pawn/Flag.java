package be.ac.umons.stratego.pawn;

public class Flag extends PawnNoMove {

	public Flag ( int posY, int posX , String squad) {
		super(0, posY, posX, squad);
        }

	public String toString() {
	        return "FLAG";
		
	}
}
