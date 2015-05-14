package be.ac.umons.stratego.graphic;

import be.ac.umons.stratego.ia.Ia_easy;
import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.plateau.PlateauBase;
import be.ac.umons.stratego.plateau.Victory;

public class Game {

	public static void NewGame(DrawPlateau plateauGameGraphic) {
		for (int y=0; y<4; y++) {
			for (int x=0; x<10; x++) {
				if(plateauGameGraphic.plateau.board[y][x]!=null && !plateauGameGraphic.plateau.board[y][x].getThispiece().getSquad().equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.board[y][x].getThispiece().toString());
					FenetreGame.panelSud.revalidate();
					plateauGameGraphic.repaint();
					FenetreGame.emplacement3.repaint();
				}
					
			}
		}
		
		for (int y=4; y<6; y++) {
			for (int x=0; x<10; x++) {
				if(plateauGameGraphic.plateau.board[y][x]!=null && plateauGameGraphic.plateau.board[y][x].getThisriverpiece()==null
					&& !plateauGameGraphic.plateau.board[y][x].getThispiece().getSquad().equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.board[y][x].getThispiece().toString());
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					plateauGameGraphic.repaint();
					FenetreGame.emplacement3.repaint();
					FenetreGame.panelSud.revalidate();
					
				}
				plateauGameGraphic.plateau.board[y][x]=null;
			}
		}
		for (int y=6; y<10; y++) {
			for (int x=0; x<10; x++) {
				if(plateauGameGraphic.plateau.board[y][x]!=null && !plateauGameGraphic.plateau.board[y][x].getThispiece().getSquad().equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.board[y][x].getThispiece().toString());
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					plateauGameGraphic.repaint();
					FenetreGame.emplacement3.repaint();
					FenetreGame.panelSud.revalidate();
				}
				plateauGameGraphic.plateau.board[y][x]=null;
					
			}
		}
		//PlateauBase.pawnRandomAlly(plateauGameGraphic.plateau);
		plateauGameGraphic.plateau.board[4][7]=new Cell(CellObject.RIVER,4,7);
		plateauGameGraphic.plateau.board[5][7]=new Cell(CellObject.RIVER,5,7);
		plateauGameGraphic.plateau.board[4][6]=new Cell(CellObject.RIVER,4,6);
		plateauGameGraphic.plateau.board[5][6]=new Cell(CellObject.RIVER,5,6);
	}
	
	public static void GameBegin(DrawPlateau plateauGameGraphic) {
			FenetreGame.emplacement3.repaint();
			//plateauGameGraphic.repaint();
			if ( FenetreGame.count==false) {
				PlacementPawn.ChoicePion(plateauGameGraphic);
				Ia_easy.play(plateauGameGraphic.plateau);
				
				FenetreGame.emplacement3.repaint();
				PlateauBase.afficherTab(plateauGameGraphic.plateau);
			
			}
			else {
				if (PlacementPawn.VerifyMyPawn(plateauGameGraphic)) {
					System.out.println("i rentre dans le verify");
					FenetreGame.emplacement3.repaint();
					FenetreGame.count=false;
					Game.GameBegin(plateauGameGraphic);
				}
			}
		}
	}	
