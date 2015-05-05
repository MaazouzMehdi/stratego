package be.ac.umons.stratego.pion;

public class Miner extends PionGeneral {

	public Miner (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
		String a = "M";
		if (this.equipe=="Friend")
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
