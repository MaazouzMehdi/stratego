package be.ac.umons.stratego.plateau;

import java.util.Random;

/* dedans tu as la méthode qui génère un plateau, une qui met les pions alliés
 * une autre , les pions ennemis et une dernière qui imprime te tableau */

public class PlateauBase 
{
	public String[][] zone;
	public static int posD_X;
	public static int posD_Y;
	
	public PlateauBase() {
	
	// Methdod that generates and return a table
	
		this.zone= new String[10][10];
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++)
				this.zone[i][j]="null";
		}
}
	
	public static PlateauBase riverPlacement (PlateauBase plateau) {
		Random myNumberRandom = new Random();
		int countRiver=0;
		boolean placementPiece;
		while (countRiver<4){ // tant que les 4 fleuves ne sont pas mis 
			placementPiece=false;
			int numberLine = myNumberRandom.nextInt(2)+4; // ligne 0 et 1 +4
			int numberColonne = myNumberRandom.nextInt(10);
			if (plateau.zone[numberLine][numberColonne].equals("null")) {
				plateau.zone[numberLine][numberColonne]="FLEUVE";
				placementPiece=true;
			}
			
			if (placementPiece==true) // Si un autre fleuve ne se trouvait pas sur la case
				countRiver++;
		}
		return plateau;
	}
	
	public static PlateauBase pawnRandomEnnemy(PlateauBase plateau) {
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
					if ( plateau.zone[numberLine][numberColonne].equals("null") &&countMarechal<1) {
						plateau.zone[numberLine][numberColonne] = new String("MA-E");
						placementPiece=true;
						countMarechal=1;
				}
				case 1: 
					if (plateau.zone[numberLine][numberColonne].equals("null") && countGeneral<1) {
						plateau.zone[numberLine][numberColonne] = new String("G-E");
						placementPiece=true;
						countGeneral=1;
					}
				case 2:
					if (plateau.zone[numberLine][numberColonne].equals("null") && countColonel<2) {
						plateau.zone[numberLine][numberColonne] = new String("CO-E");
						placementPiece=true;
						countColonel++;
					}
				case 3:
					if (plateau.zone[numberLine][numberColonne].equals("null") && countMajor<3) {
						plateau.zone[numberLine][numberColonne] = new String("MJ-E");
						placementPiece=true;
						countMajor++;
					}
				case 4:
					if (plateau.zone[numberLine][numberColonne].equals("null") && countCaptain<4) {
						plateau.zone[numberLine][numberColonne] = new String("C-E");
						placementPiece=true;
						countCaptain++;
					}
				case 5: 
					if (plateau.zone[numberLine][numberColonne].equals("null") && countLieutenant<4) {
						plateau.zone[numberLine][numberColonne] = new String("L-E");
						placementPiece=true;
						countLieutenant++;
					}	
				case 6:
					if (plateau.zone[numberLine][numberColonne].equals("null") && countSergeant<4) {
						plateau.zone[numberLine][numberColonne] = new String("SE-E");
						placementPiece=true;
						countSergeant++;
					}	
				case 7:
					if (plateau.zone[numberLine][numberColonne].equals("null") && countMiner<5) {
						plateau.zone[numberLine][numberColonne] = new String("M-E");
						placementPiece=true;
						countMiner++;
					}
				case 8: 
					if (plateau.zone[numberLine][numberColonne].equals("null") && countScout<8) {
						plateau.zone[numberLine][numberColonne] = new String("SC-E");
						placementPiece=true;
						countScout++;
					}
				case 9:
					if (plateau.zone[numberLine][numberColonne].equals("null") && countSpy<1) {
						plateau.zone[numberLine][numberColonne] = new String("S-E");
						placementPiece=true;
						countSpy++;
					}
				case 10:
					if (plateau.zone [numberLine][numberColonne].equals("null") && countBomb<6) {
						plateau.zone[numberLine][numberColonne] = new String("B-E");
						placementPiece=true;
						countBomb++;
					}
				case 11:
					if (plateau.zone [numberLine][numberColonne].equals("null") && countFlag<1) {
						if ((numberLine < 2)) {
							plateau.zone[numberLine][numberColonne] = new String("F-E");
							placementPiece=true;
							countFlag++;
							//posD_X = numberColonne;
							//posD_Y = numberLine;
						}
					}		
				}
				if (placementPiece==true) {
					// if the piece put in the table
					numberPiece ++;
				}
			}
			return plateau;
		}
		
		
		public static PlateauBase pawnRandomAlly(PlateauBase plateau) {
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
						if ( plateau.zone [numberLine+6][numberColonne].equals("null") &&countMarechal<1) {
							plateau.zone[numberLine+6][numberColonne] = new String("MA-F");
							placementPiece=true;
							countMarechal=1;
					}	
					case 1: 
						if (plateau.zone[numberLine+6][numberColonne].equals("null")&& countGeneral<1) {
							plateau.zone[numberLine+6][numberColonne] = new String("G-F");
							placementPiece=true;
							countGeneral=1;
						}
					case 2:
						if (plateau.zone[numberLine+6][numberColonne].equals("null") && countColonel<2) {
							plateau.zone[numberLine+6][numberColonne] = new String("CO-F");
							placementPiece=true;
							countColonel++;
						}
					case 3:
						if (plateau.zone[numberLine+6][numberColonne].equals("null") && countMajor<3) {
							plateau.zone[numberLine+6][numberColonne] = new String("MJ-F");
							placementPiece=true;
							countMajor++;
						}
					case 4:
						if (plateau.zone[numberLine+6][numberColonne].equals("null")&& countCaptain<4) {
							plateau.zone[numberLine+6][numberColonne] = new String("C-F");
							placementPiece=true;
							countCaptain++;
						}
					case 5: 
						if (plateau.zone[numberLine+6][numberColonne].equals("null") && countLieutenant<4) {
							plateau.zone[numberLine+6][numberColonne] = new String("L-F");
							placementPiece=true;
							countLieutenant++;
						}	
					case 6:
						if (plateau.zone[numberLine+6][numberColonne].equals("null") && countSergeant<4) {
							plateau.zone[numberLine+6][numberColonne] = new String("SE-F");
							placementPiece=true;
							countSergeant++;
						}	
					case 7:
						if (plateau.zone[numberLine+6][numberColonne].equals("null") && countMiner<5) {
							plateau.zone[numberLine+6][numberColonne] = new String("M-F");
							placementPiece=true;
							countMiner++;
						}
					case 8: 
						if (plateau.zone[numberLine+6][numberColonne].equals("null") && countScout<8) {
							plateau.zone[numberLine+6][numberColonne] = new String("SC-F");
							placementPiece=true;
							countScout++;
						}
					case 9:
						if (plateau.zone[numberLine+6][numberColonne].equals("null") && countSpy<1) {
							plateau.zone[numberLine+6][numberColonne] = new String("S-F");
							placementPiece=true;
							countSpy++;
						}
					case 10:
						if (plateau.zone [numberLine+6][numberColonne].equals("null") && countBomb<6) {
							plateau.zone[numberLine+6][numberColonne] = new String("B-F");
							placementPiece=true;
							countBomb++;
						}
					case 11:
						if (plateau.zone [numberLine+6][numberColonne].equals("null")&& countFlag<1){
							plateau.zone[numberLine+6][numberColonne] = new String("F-F");
							placementPiece=true;
							countFlag++;
						}		
					}
					if (placementPiece==true) {
						numberPiece ++;
					}
				}
				return plateau;
			}
	public static void afficherTab(PlateauBase plateau) {
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				if (plateau.zone[i][j]=="null") 
					System.out.print("[ "+plateau.zone[i][j]+"  ]"+"  ");
				else if (plateau.zone[i][j].length()==3)
					System.out.print("[   "+plateau.zone[i][j]+"   ]"+"  ");
				else if (plateau.zone[i][j].length()==6)
					System.out.print("["+plateau.zone[i][j]+" ]"+"  ");
				else
					System.out.print("[   "+plateau.zone[i][j]+"  ]"+"  ");
					
					
			}
		System.out.println();
		}
	}
	
	public static void main (String argv[]) {
		afficherTab(pawnRandomAlly(pawnRandomEnnemy(((new PlateauBase())))));
		//PlateauBase x= new PlateauBase();
		//pawnRandomAlly(x);
		//afficherTab(x);
		//afficherTab(riverPlacement(x));
		
		}

}
