package be.ac.umons.stratego.test;

import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.pion.Direction;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


import be.ac.umons.stratego.plateau.PlateauBase;
import be.ac.umons.stratego.pion.Captain;


public class TestDeplacement {
	
	//classe qui va servir a tester si le deplacement est possible et si oui,le deplacement d'un pion

	PlateauBase plateau = new PlateauBase();;
	Captain capitaine=new Captain(10,1,1,"Friend");
	Captain capitaineEnnemy=new Captain(10,2,1,"Ennemy");
	
	@Before
	public void init() {
		plateau.board[1][2]= new Cell(CellObject.RIVER,1,2);
		plateau.board[capitaine.getpositionY()][capitaine.getpositionX()]= new Cell(CellObject.CAPTAIN,capitaine.getpositionY(),capitaine.getpositionX(),"Ennemy");
		
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
		assertTrue(plateau.board[capitaine.getpositionY()][capitaine.getpositionX()].getThispiece().toString().equals("C"));

		final int oldPosX=capitaine.getpositionX();
		final int oldPosY=capitaine.getpositionY();
		
		// test si le pion est bel et bien bloqué par la fin du tableau et n'a donc pas bougé de position
		assertFalse(capitaine.deplacement(Direction.NORTH,plateau,1));
		assertTrue(plateau.board[capitaine.getpositionY()][capitaine.getpositionX()].getThispiece().toString().equals(plateau.board[oldPosY][oldPosX].getThispiece().toString()));
		
		//test si le pion s'est bien déplacer vers la gauche,vers une case vide
		assertTrue(capitaine.deplacement(Direction.WEST,plateau,1));
		assertFalse(plateau.board[capitaine.getpositionY()][capitaine.getpositionX()].getThispiece().toString().equals(plateau.board[oldPosY][oldPosX].getThispiece().toString()));
		
		
	}
	
	


}

