package be.ac.umons.stratego.pion;

public class Sergeant extends PionGeneral{

	public Sergeant (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
		String a = "SE";
		if (this.equipe.equals("Friend" ))
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
