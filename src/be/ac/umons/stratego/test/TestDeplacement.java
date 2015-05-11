package be.ac.umons.stratego.test;

import be.ac.umons.stratego.pion.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


import be.ac.umons.stratego.plateau.PlateauBase;


public class TestDeplacement {
	
	//classe qui va servir a tester si le deplacement est possible et si oui,le deplacement d'un pion

	PlateauBase plateau = new PlateauBase();;
	Captain capitaine=new Captain(1,1,"Friend");
	Captain capitaineEnnemy=new Captain(2,1,"Ennemy");
	
	@Before
	public void init() {
		plateau.board[1][2]= new Cell(CellObject.RIVER,1,2);
		plateau.board[capitaine.getPosY()][capitaine.getPosX()]= new Cell(CellObject.CAPTAIN,capitaine.getPosY(),capitaine.getPosX(),"Friend");
		plateau.board[capitaineEnnemy.getPosY()][capitaineEnnemy.getPosX()]= new Cell(CellObject.CAPTAIN,1,1,"Ennemy");
	}
	@Test
	public void deplacementPossibleTest() {
		// test si le deplacement sur un fleuve  est impossible 
		assertFalse(capitaine.deplacementPossible(Direction.EAST,plateau,1));
		// test si le déplacement sur une zone vide est bien possible
		assertTrue(capitaine.deplacementPossible(Direction.NORTH,plateau,1));
		// test si le pion peut se déplacer sur une case ennemie
		assertTrue(capitaine.deplacementPossible(Direction.SOUTH,plateau,1));
	}
	@Test
	public void deplacementTest() {
		// test si le pion s'est bien déplacé d'une unité vers le haut
		capitaine.deplacement(Direction.NORTH,plateau,1);
		assertTrue(plateau.board[capitaine.getPosY()][capitaine.getPosX()].getThispiece().toString().equals("C"));

		final int oldPosX=capitaine.getPosX();
		final int oldPosY=capitaine.getPosY();
		
		// test si le pion est bel et bien bloqué par la fin du tableau et n'a donc pas bougé de position
		assertFalse(capitaine.deplacement(Direction.NORTH, plateau, 1));
		assertTrue(plateau.board[capitaine.getPosY()][capitaine.getPosX()].getThispiece().toString().equals(plateau.board[oldPosY][oldPosX].getThispiece().toString()));
		
		//test si le pion s'est bien déplacer vers la gauche,vers une case vide
		assertTrue(capitaine.deplacement(Direction.WEST, plateau, 1));
		Cell thiscell = plateau.board[capitaine.getPosY()][capitaine.getPosX()];
		Pion notrepion = thiscell.getThispiece();
		String thispion = notrepion.toString();
		Cell anciennecase = plateau.board[oldPosY][oldPosX];
		assertEquals(thispion,capitaine.toString());
		assertNull(plateau.board[oldPosY][oldPosX]);
		
		
	}
	
	


}

