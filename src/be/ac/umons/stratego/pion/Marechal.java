package be.ac.umons.stratego.pion;

public class Marechal extends PionGeneral {

	public Marechal (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
		String a = "MA";
		if (this.equipe.equals("Friend"))
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
