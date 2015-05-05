package be.ac.umons.stratego.pion;

public class Spy extends PionGeneral {

	public Spy (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
		String a = "S";
		if (this.equipe=="Friend" )
		        return a +"-F";
		else 
		        return a + "-E";
		
	}
}
