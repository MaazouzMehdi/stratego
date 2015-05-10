package be.ac.umons.stratego.pion;

public class Bomb extends PionNoMove {

	public Bomb ( int posY, int posX , String equipe) {
		super(42, posY, posX, equipe);
        }
                                                                                                             
	public String toString() {
		return "B";
	}
}
