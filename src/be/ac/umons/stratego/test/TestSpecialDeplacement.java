package be.ac.umons.stratego.test;



import be.ac.umons.stratego.pawn.Cell;
import be.ac.umons.stratego.pawn.CellObject;
import be.ac.umons.stratego.pawn.Direction;
import be.ac.umons.stratego.pawn.Scout;
import be.ac.umons.stratego.plateau.BaseBoard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestSpecialDeplacement {
	
	BaseBoard plateau = new BaseBoard();
	Scout eclaireur = new Scout(2,2,"Friend");
	Scout eclaireurAlly=new Scout(2,1,"Friend");
	
	@Before
	public void init() {
		plateau.board[2][3]= new Cell(CellObject.RIVER,2,3);
		plateau.board[eclaireur.getPosY()][eclaireur.getPosX()]= new Cell(CellObject.SCOUT,eclaireur.getPosY(),eclaireur.getPosX(),"Friend");
		plateau.board[eclaireurAlly.getPosY()][eclaireurAlly.getPosX()]= new Cell(CellObject.SCOUT,eclaireurAlly.getPosY(),eclaireurAlly.getPosX(),"Friend");

	}
	@Test
	public void specialDeplacementPossibleTest(){
		// test si le pion est bine bloquer par son allié
		assertFalse(eclaireur.deplacementPossible(Direction.WEST, plateau, 1));
		// test si le pion est bel et bien bloqué par la fin du tableau
		assertFalse(eclaireur.deplacementPossible(Direction.NORTH, plateau, 3));
		// test si le pion est bien bloqué par la présence d'un fleuve sur son chemin
		assertFalse(eclaireur.deplacementPossible(Direction.EAST, plateau, 1));
		// test si le pion peut se deplacer de 2 cases libres vers le bas
		assertTrue(eclaireur.deplacementPossible(Direction.SOUTH,plateau,2));
		// test si le pion peut se deplacer de 5 unitées vers le bas 
		assertTrue(eclaireur.deplacement(Direction.SOUTH, plateau, 5));

	}
	

}

