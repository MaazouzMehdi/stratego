package be.ac.umons.stratego.graphic;

public class Game {

	public static void NewGame(DrawPlateau plateauGameGraphic) {
		for (int y=0; y<4; y++) {
			for (int x=0; x<10; x++) {
				if(!plateauGameGraphic.plateau.zone[x][y].equals("null") && !plateauGameGraphic.plateau.zone[x][y].equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.zone[x][y]);
					FenetreGame.panelSud.revalidate();
					plateauGameGraphic.repaint();
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					FenetreGame.emplacement3.repaint();
				}
				plateauGameGraphic.plateau.zone[x][y]="Ennemy";
					
			}
		}
		
		for (int y=4; y<6; y++) {
			for (int x=0; x<10; x++) {
				if(!plateauGameGraphic.plateau.zone[x][y].equals("null") && !plateauGameGraphic.plateau.zone[x][y].equals("Ennemy")
					&& !plateauGameGraphic.plateau.zone[x][y].equals("RIVER")) {
					Button a= new Button(plateauGameGraphic.plateau.zone[x][y]);
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					plateauGameGraphic.repaint();
					FenetreGame.emplacement3.repaint();
					FenetreGame.panelSud.revalidate();
					
				}
				plateauGameGraphic.plateau.zone[x][y]="null";
			}
		}
		for (int y=6; y<10; y++) {
			for (int x=0; x<10; x++) {
				if(!plateauGameGraphic.plateau.zone[x][y].equals("null") && !plateauGameGraphic.plateau.zone[x][y].equals("Ennemy")) {
					Button a= new Button(plateauGameGraphic.plateau.zone[x][y]);
					PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
					plateauGameGraphic.repaint();
					FenetreGame.emplacement3.repaint();
					FenetreGame.panelSud.revalidate();
				}
				plateauGameGraphic.plateau.zone[x][y]="null";
					
			}
		}
		plateauGameGraphic.plateau.zone[7][5]="RIVER";
		plateauGameGraphic.plateau.zone[2][5]="RIVER";
	}
	public static void GameBegin(DrawPlateau plateauGameGraphic) {
			if ( FenetreGame.count==false) {
				System.out.println("i renre dans le if");
				System.out.println(FenetreGame.count);
				PlacementPawn.ChoicePion(plateauGameGraphic);
			}
				
			else
				if (PlacementPawn.VerifyMyPawn(plateauGameGraphic)) {
					System.out.println("i rentre dans le verify");
					FenetreGame.count=true;
					Game.GameBegin(plateauGameGraphic);
				}
				
	}
}
