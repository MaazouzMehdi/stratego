package be.ac.umons.stratego.graphic;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import be.ac.umons.stratego.plateau.PlateauBase;


public class FenetreGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Panneau emplacement3=new Panneau();
	public static JPanel panelSud= new JPanel();
	protected static JPanel panelEast = new JPanel();
	private JPanel panelNord= new JPanel();
	private JPanel panelWest= new JPanel();
	protected static DrawPlateau plateauGameGraphic = new DrawPlateau();
	protected static int countColonel=0, countMajor=0, countGeneral=0,
			countLieutenant=0,countMarechal=0, countCaptain=0, countFlag=0,
			countSergeant=0, countMiner=0, countSpy=0, countScout=0, countBomb=0,
			countEnnemy=0;
	
	
	
	public FenetreGame(){
		    this.setTitle("Bienvenue dans la Stragego");
		    this.setSize(800, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setContentPane(emplacement3);
		    this.setVisible(true);
		    
		    //On définit le layout à utiliser sur le content pane
		    this.setLayout(new BorderLayout());
		    this.add(panelSud, BorderLayout.SOUTH);
		    this.add(plateauGameGraphic,BorderLayout.CENTER);
		    this.add(panelEast,BorderLayout.EAST);
		    this.add(panelNord,BorderLayout.NORTH);
		    this.add(panelWest,BorderLayout.WEST);
		    
		   PlacementPawn.PlacementEnnemyPawn();
		   plateauGameGraphic.plateau.zone[7][5]="FLEUVE";
		   plateauGameGraphic.plateau.zone[2][5]="FLEUVE";
		   while (countColonel < 2) {
			   Button a= new Button("Colonel");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countColonel ++;
		   }
		    while (countMajor < 3) {
		       Button a= new Button("Major");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countMajor ++;
			   }
		   /*
		   while (countGeneral < 1) {
			   Button a= new Button("General");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countGeneral ++;
			   }
		   
		   while (countMarechal < 3) {
			   Button a= new Button("Marechal");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countMarechal ++;
			   }
		   
		   while (countCaptain < 4) {
			   Button a= new Button("Captain");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countCaptain ++;
			   }
		   
		   while (countLieutenant < 4) {
			   Button a= new Button("Lieutenant");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countLieutenant ++;
			   }
		   
		   while (countSergeant < 4) {
			   Button a= new Button("Sergeant");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countSergeant ++;
			   }
		   
		   while (countMiner < 5) {
			   Button a= new Button("Miner");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countMiner ++;
			   }
		   
		   while (countScout < 8) {
			   Button a= new Button("Scout");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countScout ++;
			   }
		   
		   while (countSpy < 1) {
			   Button a= new Button("Spy");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countSpy ++;
			   }
		   
		   while (countBomb < 4) {
			   Button a= new Button("Bomb");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countBomb ++;
			   }
		   while (countFlag < 1) {
			   Button a= new Button("Flag");
			   if (PlacementPawn.PlacementMyPawn(a))
				   countFlag ++ ;
			   }
		   */
			  if(PlacementPawn.ChoicePion()==true) {
			   System.out.println("FINI");
		   }
		}
	
}
	
	


	  