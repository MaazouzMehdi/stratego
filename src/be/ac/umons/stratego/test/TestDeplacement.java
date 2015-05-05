package be.ac.umons.stratego.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


import be.ac.umons.stratego.plateau.PlateauBase;
import be.ac.umons.stratego.pion.Captain;


public class TestDeplacement {
	
	//classe qui va servir a tester si le deplacement est possible et si oui,le deplacement d'un pion

	PlateauBase plateau;
	Captain capitaine=new Captain(10,1,1,"Friend");
	Captain capitaineEnnemy=new Captain(10,2,1,"Ennemy");
	
	@Before
	public void init() {
		plateau=new PlateauBase();
		plateau.zone[1][2]="FLEUVE";
		plateau.zone[capitaine.getpositionY()][capitaine.getpositionX()]=capitaine.toString();
		
	}
	@Test
	public void deplacementPossibleTest() {
		// test si le deplacement sur un fleuve  est impossible 
		assertTrue(capitaine.deplacementPossible("RIGHT",plateau)==false);
		// test si le déplacement sur une zone vide est bien possible
		assertTrue(capitaine.deplacementPossible("UP",plateau)==true);
		// test si le pion peut se déplacer sur une case ennemie
		assertTrue(capitaine.deplacementPossible("DOWN",plateau)==true);
	}
	@Test
	public void deplacementTest() {
		// test si le pion s'est bien déplacé d'une unité vers le haut 
		capitaine.deplacement("UP",plateau);
		assertTrue(plateau.zone[capitaine.getpositionY()][capitaine.getpositionX()].equals("C-F"));
		
		final int oldPosX=capitaine.getpositionX();
		final int oldPosY=capitaine.getpositionY();
		
		// test si le pion est bel et bien bloqué par la fin du tableau et n'a donc pas bougé de position
		assertTrue(capitaine.deplacement("UP",plateau)==false);
		assertTrue(plateau.zone[capitaine.getpositionY()][capitaine.getpositionX()].equals(plateau.zone[oldPosY][oldPosX]));
		
		//test si le pion s'est bien déplacer vers la gauche,vers une case vide
		assertTrue(capitaine.deplacement("LEFT",plateau)==true);
		assertFalse(plateau.zone[capitaine.getpositionY()][capitaine.getpositionX()].equals(plateau.zone[oldPosY][oldPosX]));
		
		
	}
	
	


}

