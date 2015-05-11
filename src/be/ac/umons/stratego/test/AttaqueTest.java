package be.ac.umons.stratego.test;

import static org.junit.Assert.*;

import be.ac.umons.stratego.pion.*;
import org.junit.Before;
import org.junit.Test;

import be.ac.umons.stratego.plateau.PlateauBase;

public class AttaqueTest {
	
	
	PlateauBase plateau;
	Captain capitaine=new Captain(1,1,"Friend");
	Marechal marechal = new Marechal(2,1,"Ennemy");

	@Before
	public void init() {
		plateau=new PlateauBase();
		plateau.board[marechal.getPosY()][marechal.getPosX()]= new Cell(CellObject.MARECHAL,marechal.getPosY(),marechal.getPosX(),"Ennemy");
		plateau.board[capitaine.getPosY()][capitaine.getPosX()]= new Cell(CellObject.CAPTAIN,capitaine.getPosY(),capitaine.getPosX(),"Friend");
		PlateauBase.afficherTab(plateau);
		//System.out.println("ok prochain tableau/n");
	}
	
		
		@Test
	public void attaqueTest() {
			// return true si le capitaine peut bel et bien attaqué un adversaire pres de sa position
			//marechal.deplacement(Direction.NORTH,plateau,1);
			//PlateauBase.afficherTab(plateau);
			assertTrue(marechal.deplacement(Direction.NORTH, plateau, 1));
			// test si le marechal s'est bien déplacer
			System.out.println("ok/n");
			PlateauBase.afficherTab(plateau);
			assertTrue(plateau.board[marechal.getPosY() + 1][marechal.getPosX()]==null);
			// test si marechal a bien pris la position du capitaine
			assertTrue(plateau.board[capitaine.getPosY()][capitaine.getPosX()].getThispiece().toString().equals(marechal.toString()));
			
			
	}

}
