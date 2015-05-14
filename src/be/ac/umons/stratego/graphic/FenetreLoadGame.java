package be.ac.umons.stratego.graphic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.pion.SaveLoad;

public class FenetreLoadGame extends JFrame implements ActionListener {

	public FenetreLoadGame(DrawPlateau plateauGameGraphic) {
		    this.setTitle("Bienvenue dans la Stragego");
		    this.setSize(800, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setContentPane(FenetreGame.emplacement3);
		    this.setVisible(true);
		    //this.plateauGameGraphic=plateauGameGraphic;
		    
		    //On définit le layout à utiliser sur le content pane
		    this.setLayout(new BorderLayout());
		    this.add(FenetreGame.panelSud, BorderLayout.SOUTH);
		    this.add(plateauGameGraphic,BorderLayout.CENTER);
		    this.add(FenetreGame.panelEast,BorderLayout.EAST);
		    this.add(FenetreGame.panelNord,BorderLayout.NORTH);
		    this.add(FenetreGame.panelWest,BorderLayout.WEST);
		    this.initMenu();
		    
		   //PlacementPawn.PlacementEnnemyPawn(plateauGameGraphic);
		   PawnOffPlateau( plateauGameGraphic);
		   plateauGameGraphic.plateau.board[4][7]=new Cell(CellObject.RIVER,4,7);
			plateauGameGraphic.plateau.board[5][7]=new Cell(CellObject.RIVER,5,7);
			plateauGameGraphic.plateau.board[4][6]=new Cell(CellObject.RIVER,4,6);
			plateauGameGraphic.plateau.board[5][6]=new Cell(CellObject.RIVER,5,6);
		   
		   //NE PAS OUBLIER DE RETIRER LES PARENTHESES AUX IF POUR LES COUNT...
		  /*  while (countMajor < 3) {
		       Button a= new Button("M");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   countMajor ++;
			   }
			}
		   /*
		   while (countGeneral < 1) {
			   Button a= new Button("General");
			   if (PlacementPawn.PlacementMyPawn(a)) {
				   countGeneral ++;
				   countPiecesTot ++;
			   }
		   }
		   while (countCaptain < 4) {
			   Button a= new Button("Captain");
			   if (PlacementPawn.PlacementMyPawn(a)) {
				   countCaptain ++;
				   countPiecesTot ++;
			   }
		   }
		   while (countLieutenant < 4) {
			   Button a= new Button("Lieutenant");
			   if (PlacementPawn.PlacementMyPawn(a)) {
				   countLieutenant ++;
				   countPiecesTot ++;
			   }
		   }
		   while (countSergeant < 4) {
			   Button a= new Button("Sergeant");
			   if (PlacementPawn.PlacementMyPawn(a)) {
				   countSergeant ++;
				   countPiecesTot ++;
			   }
		   }
		 
		   while (countSpy < 1) {
			   Button a= new Button("Spy");
			   if (PlacementPawn.PlacementMyPawn(a)) {
				   countSpy ++;
				   countPiecesTot ++;
			   }
		    }
		   
		   while (countBomb < 4) {
			   Button a= new Button("Bomb");
			   if (PlacementPawn.PlacementMyPawn(a)) {
				   countBomb ++;
				   countPiecesTot ++;
			   }
			}
		   while (countFlag < 1) { 
			   Button a= new Button("Flag");
			   if (PlacementPawn.PlacementMyPawn(a)) {
				   countFlag ++ ;
				   countPiecesTot ++;
				 }
		}
		   */
		    repaint();
		    FenetreGame.emplacement3.repaint();
	}
	
	public void PawnOffPlateau(final DrawPlateau plateauGameGraphic) {
		   while (FenetreGame.countColonel < 2) {
			   Button a= new Button("COlONEL"); 
			   PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
			   FenetreGame.countColonel ++;
		   }
		   while (FenetreGame.countBomb < 4) {
			   Button a= new Button("BOMB");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   FenetreGame.countBomb ++;
			   }
				  
		   }
		   /*while (countMarechal < 1) {
			   Button a= new Button("MARECHAL");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   countMarechal ++;
			   }
		   }
		   while (countMiner < 5) {
			   Button a= new Button("MINER");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   countMiner ++;
			   }
		   }
		   while (countScout < 8) {
			   Button a= new Button("SCOUT");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   countScout ++;
			   }
		  }
		  */
		   
	}
	
	public void initMenu()  {
		FenetreGame.menuBar.add(FenetreGame.game);
		FenetreGame.menuBar.add(FenetreGame.JMenuExit);
	   
		FenetreGame.game.add(FenetreGame.newGame);
		FenetreGame.game.add(FenetreGame.save);
		FenetreGame.JMenuExit.add(FenetreGame.exit);
		
		FenetreGame.newGame.addActionListener(this);
		FenetreGame.save.addActionListener(this);
		FenetreGame.exit.addActionListener(this);
		
		//Ajout de la barre de menus sur la fenêtre
		this.setJMenuBar(FenetreGame.menuBar);
	}
	
	public void DisposeFenetreGame() {
		this.dispose();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if((JMenuItem)e.getSource()==FenetreGame.newGame) {
			
			BeforeGame.plateauGameGraphic.removeAll();
			BeforeGame.plateauGameGraphic.repaint();
			Game.NewGame(BeforeGame.plateauGameGraphic);
			FenetreGame.emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new FenetreGame(BeforeGame.plateauGameGraphic);
			FenetreGame.count =true;
		}
		else if ((JMenuItem)e.getSource()==FenetreGame.save)
		{
			try {
				SaveLoad.SaveGame(BeforeGame.plateauGameGraphic.plateau);
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
		else {
			BeforeGame.plateauGameGraphic.removeAll();
			BeforeGame.plateauGameGraphic.repaint();
			Game.NewGame(BeforeGame.plateauGameGraphic);
			FenetreGame.emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new Interface();
		}
	}
	
}
	
	


