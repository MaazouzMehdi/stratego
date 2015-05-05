package be.ac.umons.stratego.pion;

public class Scout extends SpecialPion {

	public Scout (int lvl, int posY, int posX , String equipe) { // Peut on faire dans les paramètres ( int lvl = 2 ) ? 
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
		String a = "SC";
		if (this.equipe=="Friend" )
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
