package be.ac.umons.stratego.pion;

public class Flag extends PionNoMove {

	public Flag (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
	        String a = "F";
		if (this.equipe=="Friend")
		        return a +"-F";
		else 
		        return a + "-E";
		
	}
}
