package be.ac.umons.stratego.plateau;


import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.pion.Pion;
import be.ac.umons.stratego.pion.SaveLoad;

import java.io.IOException;
import java.util.Random;

/* dedans tu as la méthode qui génère un plateau, une qui met les pions alliés
  une autre , les pions ennemis et une dernière qui imprime te tableau */

public class PlateauBase 
{
	public Cell [][] board = new  Cell [10] [10];// board = zone
	public static int posD_X;
	public static int posD_Y;
	
	public PlateauBase() {
	
	// Methdod that generates and returns a table

		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++)
				board[i][j]= null ;
		}
	}

	
		public static PlateauBase pawnRandomEnnemy(PlateauBase plateau) {
			/* Method that will place the pieces of your team randomly on the table
			* This Method return the table whit your pawns */
			Random myNumberRandom = new Random();
			int countBomb=0,countMarechal=0,countGeneral=0,countFlag=0,countSpy=0,countScout=0,
			countLieutenant=0, countColonel=0,countMajor=0,countCaptain=0,countMiner=0,
			countSergeant=0;
			int numberShuffer = 42;
			for (int i=0;i<4;i++) {
				for (int j=0;j<10;j++) {
					if (countMarechal != 1 ) {
						plateau.board[i][j]= new Cell(CellObject.MARECHAL,i,j,"Ennemy");
						countMarechal ++;
					}
					else if ( countBomb != 6 ) {
						plateau.board[i][j]= new Cell(CellObject.BOMB,i,j,"Ennemy");
						countBomb ++;
					}
					
					else if ( countGeneral != 1) {
						plateau.board[i][j]= new Cell(CellObject.GENERAL,i,j,"Ennemy");
					countGeneral ++;
					}
					else if ( countMajor != 3) {
						plateau.board[i][j]= new Cell(CellObject.MAJOR,i,j,"Ennemy");
						countMajor ++;
					}
					else if ( countColonel != 2) {
						plateau.board[i][j]= new Cell(CellObject.COLONEL,i,j,"Ennemy");
						countColonel ++;
					}
					else if ( countSpy !=1) {
						plateau.board[i][j]= new Cell(CellObject.SPY,i,j,"Ennemy");
						countSpy ++;
					}
					else if ( countFlag != 1) {
						plateau.board[i][j]= new Cell(CellObject.FLAG,i,j,"Ennemy");
						countFlag ++;
					}
					else if ( countMiner !=5) {
						plateau.board[i][j]= new Cell(CellObject.MINER,i,j,"Ennemy");
						countMiner ++;
					}
					else if ( countScout !=8) {
						plateau.board[i][j]= new Cell(CellObject.SCOUT,i,j,"Ennemy");
						countScout ++;
					}
					else if (countSergeant !=4) {
						plateau.board[i][j]= new Cell(CellObject.SERGEANT,i,j,"Ennemy");
						countSergeant ++;
					}
					else if ( countLieutenant != 4) {
						plateau.board[i][j]= new Cell(CellObject.LIEUTENANT,i,j,"Ennemy");
						countLieutenant ++;
					}
					else  if( countCaptain !=4) {
						plateau.board[i][j]= new Cell(CellObject.CAPTAIN,i,j,"Ennemy");
						countCaptain ++;
					}
				}
			}
			while (numberShuffer != 0) {
				int numberLine1 = myNumberRandom.nextInt(4);
				int numberColonne1 = myNumberRandom.nextInt(10);
				Cell a= plateau.board[numberLine1][numberColonne1];
				int x_old=a.getThispiece().getPosX();
				int y_old=a.getThispiece().getPosY();
				Pion oldPiece_a=a.getThispiece();
				
				int numberLine2 = myNumberRandom.nextInt(4);
				int numberColonne2 = myNumberRandom.nextInt(10); 
				
				Cell b = plateau.board[numberLine2][numberColonne2];
				a.getThispiece().setPosX(b.getThispiece().getPosX());
				a.getThispiece().setPosY(b.getThispiece().getPosY());
				
				b.getThispiece().setPosX(x_old);
				b.getThispiece().setPosY(y_old);
				
				a.setThispiece(b.getThispiece());
				b.setThispiece(oldPiece_a);
				
				
				plateau.board[numberLine1][numberColonne1]=a;
				plateau.board[numberLine2][numberColonne2]=b;
				
				
				numberShuffer --;
			}
				
			return plateau;
		} 
			
	public static void afficherTab(PlateauBase plateau) {
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				Cell cell = plateau.board[i][j];
				if (cell==null)
					System.out.print("[ "+"null"+" ]  ");
				else if (cell.getThisriverpiece()!=null)
					System.out.print("[ "+cell.getThisriverpiece().toString()+"]  ");
				else
					System.out.print("[ "+cell.getThispiece().toString()+"   ]  ");
			}
		System.out.println();
		}
	}
	
}
