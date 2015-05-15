package be.ac.umons.stratego.graphic;

import be.ac.umons.stratego.ia.Ia_Hard;
import be.ac.umons.stratego.ia.Ia_easy;
import be.ac.umons.stratego.pawn.Cell;
import be.ac.umons.stratego.pawn.CellObject;
import be.ac.umons.stratego.pawn.Pawn;
import be.ac.umons.stratego.plateau.BaseBoard;
import be.ac.umons.stratego.plateau.Victory;

public class Game {
	public static boolean Ia_hard=false;
	public static boolean win=false;
	public static boolean defeat=false;
	public static boolean nul=false;
	public static void NewGame(DrawPlateau plateauGameGraphic) {
		for (int y=0; y<10; y++) {
			for (int x=0; x<10; x++) {
				plateauGameGraphic.plateau.board[y][x]=null;
					
			}
		}
		PlacementPawn.PlacementEnnemyPawn(plateauGameGraphic);
		WindowGame.PawnOffPlateau(plateauGameGraphic);
		plateauGameGraphic.plateau.board[4][7]=new Cell(CellObject.RIVER,4,7);
		plateauGameGraphic.plateau.board[5][7]=new Cell(CellObject.RIVER,5,7);
		plateauGameGraphic.plateau.board[4][6]=new Cell(CellObject.RIVER,4,6);
		plateauGameGraphic.plateau.board[5][6]=new Cell(CellObject.RIVER,5,6);
		
		plateauGameGraphic.plateau.board[4][2]=new Cell(CellObject.RIVER,4,2);
		plateauGameGraphic.plateau.board[5][2]=new Cell(CellObject.RIVER,5,3);
		plateauGameGraphic.plateau.board[4][3]=new Cell(CellObject.RIVER,4,2);
		plateauGameGraphic.plateau.board[5][3]=new Cell(CellObject.RIVER,5,3);
	}
	
	public static void GameBegin(DrawPlateau plateauGameGraphic) {
		WindowGame.emplacement3.repaint();
			if ( WindowGame.count==false) {
				PlacementPawn.ChoicePion(plateauGameGraphic);
				if (!Victory.ComputerPawnsCanMoves(plateauGameGraphic.plateau) && (!Victory.MyPawnsCanMoves(plateauGameGraphic.plateau)) ) {
					nul=true;
					new WindowEnd();
				}
				if ((! Victory.FlagDisponible("Ennemy", plateauGameGraphic.plateau) || !Victory.ComputerPawnsCanMoves(plateauGameGraphic.plateau))){
					win=true;
					new WindowEnd();
				}
				if (Ia_hard) {
					Ia_Hard.play(plateauGameGraphic.plateau);
				}
					
				else
					Ia_easy.play(plateauGameGraphic.plateau);
				if (!Victory.ComputerPawnsCanMoves(plateauGameGraphic.plateau) && (!Victory.MyPawnsCanMoves(plateauGameGraphic.plateau)) ) {
					nul=true;
					new WindowEnd();
				}
				else if ((! Victory.FlagDisponible("Friend", plateauGameGraphic.plateau) || !Victory.MyPawnsCanMoves(plateauGameGraphic.plateau))) {
					defeat=true;
					System.out.println(Victory.FlagDisponible("Friend", plateauGameGraphic.plateau) );
					System.out.println(Victory.MyPawnsCanMoves(plateauGameGraphic.plateau));
					new WindowEnd();
				}
				WindowGame.emplacement3.repaint();
				BaseBoard.afficherTab(plateauGameGraphic.plateau);
			
			}
			else {
				if (PlacementPawn.VerifyMyPawn(plateauGameGraphic)) {
					//WindowGame.emplacement3.repaint();
					WindowGame.count=false;
					Game.GameBegin(plateauGameGraphic);
				}
			}
		}
	}	
