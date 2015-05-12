package be.ac.umons.stratego.plateau;


import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;

import java.util.Random;

/* dedans tu as la méthode qui génère un plateau, une qui met les pions alliés
  une autre , les pions ennemis et une dernière qui imprime te tableau */

public class PlateauBase 
{
	public static Cell [][] board = new  Cell [10] [10];// board = zone
	public static int posD_X;
	public static int posD_Y;
	
	public PlateauBase() {
	
	// Methdod that generates and returns a table

		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++)
				board[i][j]= null ;
		}
	}

	
	public static PlateauBase pawnRandomAlly(PlateauBase plateau) {
		/* Method that will place the pieces of your team randomly on the table
		 * This Method return the table whit your pawns */
		Random myNumberRandom = new Random();
		// Variables that limit the parts to put in the table
		int countBomb=0,countMarechal=0,countGeneral=0,countFlag=0,countSpy=0,countScout=0,
		countLieutenant=0, countColonel=0,countMajor=0,countCaptain=0,countMiner=0,
		countSergeant=0;
		// Number of pieces to place in the table
		int numberPiece=0;
		boolean placementPiece;
		while (numberPiece<40) {
			placementPiece=false;
			int numberLine = myNumberRandom.nextInt(4);
			int numberColonne = myNumberRandom.nextInt(10);
			int numberPiecesRandom= myNumberRandom.nextInt(11);
			switch (numberPiecesRandom) {
				case 0 :
					if ( plateau.board[numberLine][numberColonne]==null &&countMarechal<1) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.MARECHAL,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countMarechal=1;
				}
				case 1: 
					if (plateau.board[numberLine][numberColonne] ==null && countGeneral<1) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.GENERAL,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countGeneral=1;
					}
				case 2:
					if (plateau.board[numberLine][numberColonne] ==null && countColonel<2) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.COLONEL,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countColonel++;
					}
				case 3:
					if (plateau.board[numberLine][numberColonne] ==null && countMajor<3) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.MAJOR,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countMajor++;
					}
				case 4:
					if (plateau.board[numberLine][numberColonne] ==null && countCaptain<4) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.CAPTAIN,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countCaptain++;
					}
				case 5: 
					if (plateau.board[numberLine][numberColonne] ==null && countLieutenant<4) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.LIEUTENANT,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countLieutenant++;
					}	
				case 6:
					if (plateau.board[numberLine][numberColonne] ==null && countSergeant<4) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.SERGEANT,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countSergeant++;
					}	
				case 7:
					if (plateau.board[numberLine][numberColonne] ==null && countMiner<5) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.MINER,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countMiner++;
					}
				case 8: 
					if (plateau.board[numberLine][numberColonne] ==null && countScout<8) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.SCOUT,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countScout++;
					}
				case 9:
					if (plateau.board[numberLine][numberColonne] ==null && countSpy<1) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.SPY,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countSpy++;
					}
				case 10:
					if (plateau.board[numberLine][numberColonne] ==null && countBomb<6) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.BOMB,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countBomb++;
					}
				case 11:
					if (plateau.board[numberLine][numberColonne] ==null && countFlag<1) {
						plateau.board[numberLine][numberColonne] = new Cell(CellObject.FLAG,numberLine,numberColonne,"Friend");
						placementPiece=true;
						countFlag++;
						posD_X = numberColonne;
						posD_Y = numberLine;
					}		
				}
				if (placementPiece) {
					// if the piece put in the table
					numberPiece ++;
				}
			}
			return plateau;
		}
		
		
		public static PlateauBase pawnRandomEnnemy(PlateauBase plateau) {
			/* Method that will place the pieces of your team randomly on the table
			* This Method return the table whit your pawns */
			Random myNumberRandom = new Random();
			int countBomb=0,countMarechal=0,countGeneral=0,countFlag=0,countSpy=0,countScout=0,
			countLieutenant=0, countColonel=0,countMajor=0,countCaptain=0,countMiner=0,
			countSergeant=0;
			int numberPiece=0;
			boolean placementPiece;
			while (numberPiece<40) {
				placementPiece=false;
				int numberLine = myNumberRandom.nextInt(4);
				int numberColonne = myNumberRandom.nextInt(10);
				int numberPiecesRandom= myNumberRandom.nextInt(11);
				switch (numberPiecesRandom) {
					case 0 :
						if (plateau.board [numberLine+6][numberColonne]==null &&countMarechal<1) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.MARECHAL,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countMarechal=1;

					}	
					case 1: 
						if (plateau.board[numberLine+6][numberColonne] ==null && countGeneral<1) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.GENERAL,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countGeneral=1;

						}
					case 2:
						if (plateau.board[numberLine+6][numberColonne] ==null && countColonel<2) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.COLONEL,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countColonel++;

						}
					case 3:
						if (plateau.board[numberLine+6][numberColonne] ==null && countMajor<3) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.MAJOR,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countMajor++;

						}
					case 4:
						if (plateau.board[numberLine+6][numberColonne] ==null && countCaptain<4) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.CAPTAIN,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countCaptain++;

						}
					case 5: 
						if (plateau.board[numberLine+6][numberColonne] ==null && countLieutenant<4) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.LIEUTENANT,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countLieutenant++;

						}	
					case 6:
						if (plateau.board[numberLine+6][numberColonne] ==null && countSergeant<4) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.SERGEANT,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countSergeant++;

						}	
					case 7:
						if (plateau.board[numberLine+6][numberColonne] ==null && countMiner<5) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.MINER,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countMiner++;

						}
					case 8: 
						if (plateau.board[numberLine+6][numberColonne] ==null && countScout<8) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.SCOUT,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countScout++;

						}
					case 9:
						if (plateau.board[numberLine+6][numberColonne] ==null && countSpy<1) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.SPY,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countSpy++;

						}
					case 10:
						if (plateau.board[numberLine+6][numberColonne] ==null && countBomb<6) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.BOMB,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countBomb++;

						}
					case 11:
						if (plateau.board[numberLine+6][numberColonne] ==null && countFlag<1) {
							plateau.board[numberLine+6][numberColonne] = new Cell(CellObject.FLAG,numberLine,numberColonne,"Ennemy");
							placementPiece=true;
							countFlag++;

						}		
					}
					if (placementPiece) {
						numberPiece ++;
					}
				}
				return plateau;
			}
	public static void afficherTab(PlateauBase plateau) {
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				Cell cell = plateau.board[i][j];
				//String stringcell = cell.getThispiece().toString();
				if (cell==null)
					System.out.print("[ "+"null"+" ]  ");
				else
					System.out.print("[ "+cell.getThispiece().toString()+"   ]  ");
			}
		System.out.println();
		}
	}
	
	public static void main (String argv[]) {
		PlateauBase x = new PlateauBase();
		pawnRandomAlly(x);
		pawnRandomEnnemy(x);
		afficherTab(x);
		}

}
