package be.ac.umons.stratego.pawn;

public class Sergeant extends PawnGeneral{

	public Sergeant(int posY, int posX, String squad) {
		super(4, posY, posX, squad);
        }

	public String toString() {
		return "SERGEANT";
	}
}
