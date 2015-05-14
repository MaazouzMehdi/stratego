package be.ac.umons.stratego.graphic;

import java.awt.BorderLayout;

import javax.swing.JFrame; 
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.pion.River;
import be.ac.umons.stratego.pion.SaveLoad;
import be.ac.umons.stratego.plateau.PlateauBase;


public class FenetreGame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	public static boolean count=false;
	private static final long serialVersionUID = 1L;
	protected static Panneau emplacement3=new Panneau();
	public static JPanel panelSud= new JPanel();
	protected static JPanel panelEast = new JPanel();
	private JPanel panelNord= new JPanel();
	private JPanel panelWest= new JPanel();
	//public final DrawPlateau plateauGameGraphic; 
	protected static int countColonel=0, countMajor=0, countGeneral=0,
			countLieutenant=0,countMarechal=0, countCaptain=0, countFlag=0,
			countSergeant=0, countMiner=0, countSpy=0, countScout=0, countBomb=0,
			countEnnemy=0;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu game = new JMenu("Partie");
	private JMenu JMenuExit = new JMenu("Quitter");
	
	private JMenuItem newGame=new JMenuItem("Nouvelle partie");
	private JMenuItem save=new JMenuItem("Sauvegarder Partie");
	private JMenuItem exit=new JMenuItem("Quitter partie");

	
	
	
	public FenetreGame(DrawPlateau plateauGameGraphic){
			emplacement3.removeAll();
		    this.setTitle("Bienvenue dans la Stragego");
		    this.setSize(800, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setContentPane(emplacement3);
		    this.setVisible(true);
		    //this.plateauGameGraphic=plateauGameGraphic;
		    
		    //On définit le layout à utiliser sur le content pane
		    this.setLayout(new BorderLayout());
		    this.add(panelSud, BorderLayout.SOUTH);
		    this.add(plateauGameGraphic,BorderLayout.CENTER);
		    this.add(panelEast,BorderLayout.EAST);
		    this.add(panelNord,BorderLayout.NORTH);
		    this.add(panelWest,BorderLayout.WEST);
		    this.initMenu();
		    
		   PlacementPawn.PlacementEnnemyPawn(plateauGameGraphic);
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
		    emplacement3.repaint();
	}
	
	public void PawnOffPlateau(final DrawPlateau plateauGameGraphic) {
		   while (countColonel < 2) {
			   Button a= new Button("COlONEL"); 
			   PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
			   countColonel ++;
		   }
		   while (countBomb < 4) {
			   Button a= new Button("BOMB");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   countBomb ++;
			   }
				  
		   }
		   while (countMarechal < 1) {
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
		   
	}
	
	public void initMenu()  {
		menuBar.add(game);
		menuBar.add(JMenuExit);
	   
		game.add(newGame);
		game.add(save);
		JMenuExit.add(exit);
		
		newGame.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		//Ajout de la barre de menus sur la fenêtre
		this.setJMenuBar(menuBar);
	}
	
	public void DisposeFenetreGame() {
		this.dispose();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if((JMenuItem)e.getSource()==newGame) {
			
			BeforeGame.plateauGameGraphic.removeAll();
			BeforeGame.plateauGameGraphic.repaint();
			Game.NewGame(BeforeGame.plateauGameGraphic);
			emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new FenetreGame(BeforeGame.plateauGameGraphic);
			count =true;
		}
		else if ((JMenuItem)e.getSource()==save)
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
			emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new Interface();
		}
	}
	
}
	
	


	  