package be.ac.umons.stratego.graphic;

import be.ac.umons.stratego.ia.Ia_easy;
import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.plateau.PlateauBase;

public class Game {

	public static void NewGame(DrawPlateau plateauGameGraphic) {
		for (int y=0; y<4; y++) {
			for (int x=0; x<10; x++) {
				if(plateauGameGraphic.plateau.board[x][y]!=null && !plateauGameGraphic.plateau.board[x][y].getThispiece().getSquad().equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.board[x][y].getThispiece().toString());
					FenetreGame.panelSud.revalidate();
					plateauGameGraphic.repaint();
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					FenetreGame.emplacement3.repaint();
				}
					
			}
		}
		
		for (int y=4; y<6; y++) {
			for (int x=0; x<10; x++) {
				if(plateauGameGraphic.plateau.board[x][y]!=null && plateauGameGraphic.plateau.board[x][y].getThisriverpiece()==null
					&& !plateauGameGraphic.plateau.board[x][y].getThispiece().getSquad().equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.board[x][y].getThispiece().toString());
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					plateauGameGraphic.repaint();
					FenetreGame.emplacement3.repaint();
					FenetreGame.panelSud.revalidate();
					
				}
				plateauGameGraphic.plateau.board[x][y]=null;
			}
		}
		for (int y=6; y<10; y++) {
			for (int x=0; x<10; x++) {
				if(plateauGameGraphic.plateau.board[x][y]!=null && !plateauGameGraphic.plateau.board[x][y].getThispiece().getSquad().equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.board[x][y].getThispiece().toString());
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					plateauGameGraphic.repaint();
					FenetreGame.emplacement3.repaint();
					FenetreGame.panelSud.revalidate();
				}
				plateauGameGraphic.plateau.board[x][y]=null;
					
			}
		}
		//PlateauBase.pawnRandomAlly(plateauGameGraphic.plateau);
		plateauGameGraphic.plateau.board[7][5]=new Cell(CellObject.RIVER,7,5);
		plateauGameGraphic.plateau.board[2][5]=new Cell(CellObject.RIVER,2,5);
	}
	public static void GameBegin(DrawPlateau plateauGameGraphic) {
			FenetreGame.emplacement3.repaint();
			if ( FenetreGame.count==false) {
				System.out.println(FenetreGame.count);
				PlacementPawn.ChoicePion(plateauGameGraphic);
				Ia_easy.play(plateauGameGraphic.plateau);
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
