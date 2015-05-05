package be.ac.umons.stratego.pion;

public class Bomb extends PionNoMove {

	public Bomb (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }
                                                                                                             
	public String toString() {
		String a = "B";
		if (this.equipe=="Friend") 
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
