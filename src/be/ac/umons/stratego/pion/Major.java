package be.ac.umons.stratego.pion;

public class Major extends PionGeneral{

	public Major (int lvl, int posY, int posX , String equipe) {
		super(lvl, posY, posX, equipe);
        }

	public String toString() {
		String a = "MJ";
		if (this.equipe=="Friend" )
		        return a +"-F";
		else 
		        return a + "-E";
	}
}
