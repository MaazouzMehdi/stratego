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

import be.ac.umons.stratego.pawn.Cell;
import be.ac.umons.stratego.pawn.CellObject;
import be.ac.umons.stratego.pawn.River;
import be.ac.umons.stratego.pawn.SaveLoad;
import be.ac.umons.stratego.plateau.BaseBoard;


public class WindowGame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	public static boolean count=false;
	public static boolean save_game=false;
	private static final long serialVersionUID = 1L;
	protected static Panneau emplacement3=new Panneau();
	public static JPanel panelSud= new JPanel();
	public static JPanel panelEast = new JPanel();
	protected static JPanel panelNord= new JPanel();
	protected static JPanel panelWest= new JPanel();
	protected static int countColonel=0, countMajor=0, countGeneral=0,
			countLieutenant=0,countMarechal=0, countCaptain=0, countFlag=0,
			countSergeant=0, countMiner=0, countSpy=0, countScout=0, countBomb=0,
			countEnnemy=0;
	static JMenuBar menuBar = new JMenuBar();
	 static JMenu game = new JMenu("Partie");
	static  JMenu JMenuExit = new JMenu("Quitter");
	
	 static JMenuItem newGame=new JMenuItem("Nouvelle partie");
	 static JMenuItem save=new JMenuItem("Sauvegarder Partie");
	 static JMenuItem exit=new JMenuItem("Quitter partie");

	
	
	
	public WindowGame(DrawPlateau plateauGameGraphic){
		    this.setTitle("Bienvenue dans la Stratego");
		    this.setSize(800, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setContentPane(emplacement3);
		    this.setVisible(true);
		    
		    
		    //On définit le layout à utiliser sur le content pane
		    this.setLayout(new BorderLayout());
		    this.add(panelSud, BorderLayout.SOUTH);
		    this.add(plateauGameGraphic,BorderLayout.CENTER);
		    this.add(panelNord,BorderLayout.NORTH);
		    this.initMenu();
		    
		   //PlacementPawn.PlacementEnnemyPawn(plateauGameGraphic);
		   PawnOffPlateau( plateauGameGraphic);
		   plateauGameGraphic.plateau.board[4][7]=new Cell(CellObject.RIVER,4,7);
			plateauGameGraphic.plateau.board[5][7]=new Cell(CellObject.RIVER,5,7);
			plateauGameGraphic.plateau.board[4][6]=new Cell(CellObject.RIVER,4,6);
			plateauGameGraphic.plateau.board[5][6]=new Cell(CellObject.RIVER,5,6);
			
			plateauGameGraphic.plateau.board[4][2]=new Cell(CellObject.RIVER,4,2);
			plateauGameGraphic.plateau.board[5][2]=new Cell(CellObject.RIVER,5,3);
			plateauGameGraphic.plateau.board[4][3]=new Cell(CellObject.RIVER,4,2);
			plateauGameGraphic.plateau.board[5][3]=new Cell(CellObject.RIVER,5,3);
		   
		    //repaint();
		    //emplacement3.repaint();
	}
	
	public static void PawnOffPlateau(final DrawPlateau plateauGameGraphic) {
		   while (countColonel < 2) {
			   Button a= new Button("COLONEL"); 
			   PlacementPawn.PlacementMyPawn(a,plateauGameGraphic);
			   countColonel ++;
		   }
		   while (countBomb < 6) {
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
		   while (countFlag < 1) { 
			   Button a= new Button("FLAG");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   countFlag ++ ;
			   }
		   }
		   while (countMajor < 3) {
			   Button a= new Button("MAJOR");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
				   countMajor ++;
		   }
		}
		   while (countGeneral < 1) {
			   Button a= new Button("GENERAL");
			   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
			   countGeneral ++;
		   }
	   }
	   while (countCaptain < 4) {
		   Button a= new Button("CAPTAIN");
		   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
			   countCaptain ++;
		   }
	   }
	   while (countLieutenant < 4) {
		   Button a= new Button("LIEUTENANT");
		   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
			   countLieutenant ++;
			   
		   }
	   }
	   while (countSergeant < 4) {
		   Button a= new Button("SERGEANT");
		   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
			   countSergeant ++;
			   
		   }
	   }
	 
	   while (countSpy < 1) {
		   Button a= new Button("SPY");
		   if (PlacementPawn.PlacementMyPawn(a,plateauGameGraphic)) {
			   countSpy ++;
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
			panelSud.removeAll();
			 countColonel=0 ;countMajor=0 ; countGeneral=0;
			countLieutenant=0;countMarechal=0; countCaptain=0;countFlag=0;
			countSergeant=0; countMiner=0;countSpy=0;countScout=0;countBomb=0;
			BeforeGame.plateauGameGraphic.removeAll();
			BeforeGame.plateauGameGraphic.repaint();
			Game.NewGame(BeforeGame.plateauGameGraphic);
			emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new WindowGame(BeforeGame.plateauGameGraphic);
			count =true;
		}
		else if ((JMenuItem)e.getSource()==save)
		{
			try {
				SaveLoad.SaveGame(BeforeGame.plateauGameGraphic.plateau);
				save_game=true;
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
		else {
			if (!save_game) {
				countColonel=0 ;countMajor=0 ; countGeneral=0;
				countLieutenant=0;countMarechal=0; countCaptain=0;countFlag=0;
				countSergeant=0; countMiner=0;countSpy=0;countScout=0;countBomb=0;
				BeforeGame.plateauGameGraphic.removeAll();
				BeforeGame.plateauGameGraphic.repaint();
				Game.NewGame(BeforeGame.plateauGameGraphic);
			}
			save_game=false;
			emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new Interface();
		}
	}
	
}
	
		
	


	  