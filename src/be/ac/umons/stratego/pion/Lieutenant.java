package be.ac.umons.stratego.pion;

public class Lieutenant extends PionGeneral {

	public Lieutenant (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
		String a = "L";
		if (this.equipe=="Friend" )
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
