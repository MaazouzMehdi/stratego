package be.ac.umons.stratego.pion;

public class Miner extends PionGeneral {

	public Miner ( int posY, int posX , String equipe) {
		super(3, posY, posX, equipe);
	}

	public String toString() {
		return "MINER";
	}
}
