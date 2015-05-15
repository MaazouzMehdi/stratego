package be.ac.umons.stratego.pawn;

public class Miner extends PawnGeneral {

	public Miner ( int posY, int posX , String squad) {
		super(3, posY, posX, squad);
	}

	public String toString() {
		return "MINER";
	}
}
