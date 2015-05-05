package be.ac.umons.stratego.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.ac.umons.stratego.pion.Captain;
import be.ac.umons.stratego.pion.Marechal;
import be.ac.umons.stratego.plateau.PlateauBase;

public class AttaqueTest {
	
	
	PlateauBase plateau;
	Captain capitaine=new Captain(7,1,1,"Friend");
	Marechal marechal = new Marechal(10,2,1,"Ennemy");
	
	
	@Before
	public void init() {
		plateau=new PlateauBase();
		plateau.zone[marechal.getpositionY()][marechal.getpositionX()]=marechal.toString();
		plateau.zone[capitaine.getpositionY()][capitaine.getpositionX()]=capitaine.toString();
	}
	
		
		@Test
	public void attaqueTest() {
			// return true si le capitaine peut bel et bien attaqué un adversaire pres de sa position
			assertTrue(marechal.deplacement("UP",plateau)==true);
			// test si le marechal s'est bien déplacer
			assertTrue(plateau.zone[marechal.getpositionY()][marechal.getpositionX()].equals("null"));
			// test si marechal a bien pris la position du capitaine
			assertTrue(plateau.zone[capitaine.getpositionY()][capitaine.getpositionX()].equals(marechal.toString()));
			
			
	}

}
