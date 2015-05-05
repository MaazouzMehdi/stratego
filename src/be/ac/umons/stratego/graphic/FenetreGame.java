package be.ac.umons.stratego.graphic;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import be.ac.umons.stratego.graphic.SavePionPlateau;


public class FenetreGame extends JFrame {
	/**
	 * 
	 */
	private JButton [][] positions = new JButton[10][10];
	private static final long serialVersionUID = 1L;
	private Panneau emplacement3=new Panneau();
	private JPanel panelSud= new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelNord= new JPanel();
	private JPanel panelWest= new JPanel();
	private JDrawPanel plateauGame= new JDrawPanel();
	
	
	
	
	public FenetreGame(){
		    this.setTitle("Bienvenue dans la Stragego");
		    this.setSize(800, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    
		    //On définit le layout à utiliser sur le content pane
		    this.setLayout(new BorderLayout());
		    this.add(panelSud, BorderLayout.SOUTH);
		    this.add(plateauGame,BorderLayout.CENTER);
		    for (int i = 0; i <  10; i++) {
				for (int j = 0; j <  10 ; j++) {
					//plateauGame.add(new Button("Empty"));
					positions[i][j]=new JButton("Empty");
					plateauGame.add(positions[i][j]);
				}
		    }
		    this.add(panelEast,BorderLayout.EAST);
		    this.add(panelNord,BorderLayout.NORTH);
		    this.add(panelWest,BorderLayout.WEST);
		    
		    //panelNord.add(new Button("Flag"));
		    
		   panelWest.add(new Pions("General"));
		   panelEast.add(new Button("General"));
		   
		   
		   panelSud.add(new Pions("Flag"));
		   //panelGridBag.add(new Button("BOMB"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("General"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("Miner"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("Marechal"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("Captain"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("Colonel"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("Sergeant"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("Spy"), BorderLayout.SOUTH);
		   //panelGridBag.add(new Pions("Major"), BorderLayout.SOUTH);
		   this.setVisible(true);
		   final Button b=new Button("Flag");
		    panelNord.add(b);
		    b.addMouseMotionListener(new MouseMotionListener()
		    {
		    	String name;
		    	
		    	public void mouseDragged(MouseEvent e) {
		    		plateauGame.add(b);
		    		repaint();
		    		b.setLocation(b.getX()+e.getX(),b.getY() + e.getY() );
		    	}

				public void mouseMoved(MouseEvent e) {}

			

				  });
		    
		    try {
		        Thread.sleep(10);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
			
	}
}

	  