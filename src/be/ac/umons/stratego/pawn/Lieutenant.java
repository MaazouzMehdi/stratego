package be.ac.umons.stratego.pawn;

public class Lieutenant extends PawnGeneral {

	public Lieutenant(int posY, int posX, String squad) {
		super(5, posY, posX, squad);
        }

	public String toString() {
		return "LIEUTENANT";
	}
}
