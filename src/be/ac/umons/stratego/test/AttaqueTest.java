package be.ac.umons.stratego.test;

import static org.junit.Assert.*;

import be.ac.umons.stratego.pion.*;
import org.junit.Before;
import org.junit.Test;

import be.ac.umons.stratego.plateau.PlateauBase;

public class AttaqueTest {
	
	
	PlateauBase plateau;
	Captain capitaine=new Captain(7,1,1,"Friend");
	Marechal marechal = new Marechal(2,1,"Ennemy");

	@Before
	public void init() {
		plateau=new PlateauBase();
		plateau.board[marechal.getpositionY()][marechal.getpositionX()]= new Cell(CellObject.MARECHAL,marechal.getpositionY(),marechal.getpositionX(),"Ennemy");
		plateau.board[capitaine.getpositionY()][capitaine.getpositionX()]= new Cell(CellObject.CAPTAIN,capitaine.getpositionY(),capitaine.getpositionX(),"Friend");
		//PlateauBase.afficherTab(plateau);
		//System.out.println("ok prochain tableau/n");
	}
	
		
		@Test
	public void attaqueTest() {
			// return true si le capitaine peut bel et bien attaqué un adversaire pres de sa position
			//marechal.deplacement(Direction.NORTH,plateau,1);
			//PlateauBase.afficherTab(plateau);
			assertTrue(marechal.deplacement(Direction.NORTH, plateau, 1));
			// test si le marechal s'est bien déplacer
			assertTrue(plateau.board[marechal.getpositionY() + 1][marechal.getpositionX()].equals("null"));
			// test si marechal a bien pris la position du capitaine
			assertTrue(plateau.board[capitaine.getpositionY()][capitaine.getpositionX()].equals(marechal.toString()));
			
			
	}

}
