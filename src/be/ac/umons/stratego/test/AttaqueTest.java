package be.ac.umons.stratego.test;

import static org.junit.Assert.*;

import be.ac.umons.stratego.pawn.*;
import org.junit.Before;
import org.junit.Test;

import be.ac.umons.stratego.plateau.BaseBoard;

public class AttaqueTest {
	
	
	BaseBoard plateau;
	Captain capitaine=new Captain(1,1,"Friend");
	Marechal marechal = new Marechal(2,1,"Ennemy");
	Bomb bombe = new Bomb(1,0,"Friend");
	Miner demineur = new Miner(0,0,"Ennemy");
	Scout eclaireur = new Scout(1,5,"Friend");

	@Before
	public void init() {
		plateau=new BaseBoard();
		plateau.board[marechal.getPosY()][marechal.getPosX()]= new Cell(CellObject.MARECHAL,marechal.getPosY(),marechal.getPosX(),"Ennemy");
		plateau.board[capitaine.getPosY()][capitaine.getPosX()]= new Cell(CellObject.CAPTAIN,capitaine.getPosY(),capitaine.getPosX(),"Friend");
		plateau.board[eclaireur.getPosY()][eclaireur.getPosX()]= new Cell(CellObject.SCOUT,eclaireur.getPosY(),eclaireur.getPosX(),"Friend");
		plateau.board[bombe.getPosY()][bombe.getPosX()]= new Cell(CellObject.BOMB,bombe.getPosY(),bombe.getPosX(),"Friend");
		plateau.board[demineur.getPosY()][demineur.getPosX()]= new Cell(CellObject.MINER,demineur.getPosY(),demineur.getPosX(),"Ennemy");
	}
	
		
		@Test
	public void attaqueTest() {
			// test si le marechal s'est bien déplacer sur une case ennemie
			assertTrue(marechal.deplacement(Direction.NORTH, plateau, 1));
			assertTrue(plateau.board[marechal.getPosY() + 1][marechal.getPosX()]==null);
			
			// test si marechal a battu son ennemie et a bien pris sa position
			assertTrue(plateau.board[capitaine.getPosY()][capitaine.getPosX()].getThispiece().toString().equals(marechal.toString()));
			// test si l'éclaireur s'est bien déplacer de 4 cases vers la gauche sur le maréchal ennemi
			assertTrue(eclaireur.deplacement(Direction.WEST, plateau, 4));
			// test si l'éclaireur s'est bien fait tuer par le maréchal
			assertTrue(plateau.board[1][1].getThispiece().toString().equals(marechal.toString()));
			// test si le marechal meurt bien en voulant attaquer une bombe
			assertTrue(marechal.deplacement(Direction.WEST, plateau,1));
			assertTrue(plateau.board[1][1]==null);
			assertTrue(plateau.board[1][0].getThispiece().toString().equals(bombe.toString()));
			
			//test si le demineur peut bel et bien deminer une bombe
			assertTrue(demineur.deplacement(Direction.SOUTH, plateau,1));
			assertTrue(plateau.board[0][0]==null);
			assertTrue(plateau.board[1][0].getThispiece().toString().equals(demineur.toString()));
	}

}
