package be.ac.umons.stratego.board;


import be.ac.umons.stratego.pawn.Cell;
import be.ac.umons.stratego.pawn.CellObject;
import be.ac.umons.stratego.pawn.Pawn;

import java.util.Random;

/**
 * this class represents the board of the game and the methods to see it and put the pawns on it
 */
public class BaseBoard
{
	/**
	 * the board is represented through the attribute board
	 * the attribute board is a Cell array
	 */
	public Cell [][] board = new  Cell [10] [10];
	
	public BaseBoard() {
	
	// Methdod that generates and returns a table
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++)
				board[i][j]= null ;
		}
	}

	/**
	 * This methods put the computer pawns on the board
	 * @param plateau represents the game board
	 * @return a game board contains the computer pawns
	 */
	public static BaseBoard pawnRandomEnnemy(BaseBoard plateau) {
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
			Pawn oldPiece_a=a.getThispiece();

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

	/**
	 * this method print the board with all his cells in the terminal
	 * @param plateau represents the game board to print
	 */
	public static void afficherTab(BaseBoard plateau) {
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
