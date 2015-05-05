package be.ac.umons.stratego.pion;

public class Captain extends PionGeneral {

	public Captain (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {		
		String a = "C";
		if (this.equipe=="Friend")
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
