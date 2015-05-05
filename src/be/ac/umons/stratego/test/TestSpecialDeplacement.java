package be.ac.umons.stratego.test;

import be.ac.umons.stratego.pion.Direction;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;
import be.ac.umons.stratego.plateau.PlateauBase;
import static be.ac.umons.stratego.plateau.PlateauBase.*;
import be.ac.umons.stratego.pion.Scout;


public class TestSpecialDeplacement {
	
	PlateauBase plateau;
	Scout eclaireur = new Scout(5,2,2,"Friend");
	Scout eclaireurAlly=new Scout(5,2,1,"Friend");
	
	@Before
	public void init() {
		plateau=new PlateauBase();
		plateau.zone[2][3]="FLEUVE";
		plateau.zone[eclaireur.getpositionY()][eclaireur.getpositionX()]=eclaireur.toString();
		plateau.zone[eclaireurAlly.getpositionY()][eclaireurAlly.getpositionX()]=eclaireurAlly.toString();
	}
	@Test
	public void specialDeplacementPossibleTest(){
		assertTrue("le pion est bien bloqué par un allié", eclaireur.deplacementPossible(Direction.NORTH,plateau,1));
		// test si le pion est bel et bien bloqué par la fin du tableau
		assertFalse(eclaireur.deplacementPossible(Direction.NORTH, plateau, 3));
		// test si le pion est bien bloqué par la présence d'un fleuve sur son chemin
		assertFalse(eclaireur.deplacementPossible(Direction.EAST, plateau, 1));
		// test si le pion peut se deplacer de 2 cases libres vers le bas
		assertTrue(eclaireur.deplacementPossible(Direction.SOUTH,plateau,2));
		
		assertTrue(eclaireur.deplacement(Direction.SOUTH, plateau, 5)==true);
		
	}
	

}
