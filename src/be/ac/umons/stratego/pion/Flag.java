package be.ac.umons.stratego.pion;

public class Flag extends PionNoMove {

	public Flag ( int posY, int posX , String equipe) {
		super(0, posY, posX, equipe);
        }

	public String toString() {
	        return "F";
		
	}
}
