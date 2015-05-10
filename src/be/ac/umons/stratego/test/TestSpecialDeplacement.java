package be.ac.umons.stratego.test;

import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.pion.Direction;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import be.ac.umons.stratego.plateau.PlateauBase;
import be.ac.umons.stratego.pion.Scout;


public class TestSpecialDeplacement {
	
	PlateauBase plateau = new PlateauBase();
	Scout eclaireur = new Scout(5,2,2,"Friend");
	Scout eclaireurAlly=new Scout(5,2,1,"Friend");
	
	@Before
	public void init() {
		plateau.board[2][3]= new Cell(CellObject.RIVER,2,3);
		plateau.board[eclaireur.getpositionY()][eclaireur.getpositionX()]= new Cell(CellObject.SCOUT,eclaireur.getpositionY(),eclaireur.getpositionX(),"friend");
		plateau.board[eclaireurAlly.getpositionY()][eclaireurAlly.getpositionX()]= new Cell(CellObject.SCOUT,eclaireurAlly.getpositionY(),eclaireurAlly.getpositionX(),"friend");
		//PlateauBase.afficherTab(plateau);
	}
	@Test
	public void specialDeplacementPossibleTest(){
		// test si le pion est bine bloquer par son allié
		assertFalse("le pion est bien bloqué par un allié", eclaireur.deplacementPossible(Direction.WEST, plateau, 1));
		// test si le pion est bel et bien bloqué par la fin du tableau
		assertFalse(eclaireur.deplacementPossible(Direction.NORTH, plateau, 3));
		// test si le pion est bien bloqué par la présence d'un fleuve sur son chemin
		assertFalse(eclaireur.deplacementPossible(Direction.EAST, plateau, 1));
		// test si le pion peut se deplacer de 2 cases libres vers le bas
		assertTrue(eclaireur.deplacementPossible(Direction.SOUTH,plateau,2));

		assertTrue(eclaireur.deplacement(Direction.SOUTH, plateau, 5));

		//PlateauBase.afficherTab(plateau);
	}
	

}
