package be.ac.umons.stratego.graphic;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import be.ac.umons.stratego.graphic.FenetreGame;
import be.ac.umons.stratego.plateau.PlateauBase;

public class DrawPlateau extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PlateauBase plateau;
	public DrawPlateau(PlateauBase board) {
		this.plateau=board;
	}
	
	
	public  void paintComponent(Graphics g){
			final float cellX=getWidth()/10;
			final float cellY=getHeight()/10;
		
		Font font = new Font("Courier",Font.BOLD,14);
		FenetreGame.emplacement3.repaint();
		g.setColor(Color.black);
		for (int y = 1; y < 10; y++) 
			g.drawLine(0, (int)(y*cellY)-10, getWidth(), (int)(y*cellY)-10);
		
		for (int x = 0 ; x < 10; x++ ) {
			g.setColor(Color.black);
			g.drawLine((int)((x+1)*cellX)-4, 0, (int)((x+1)*cellX)-4, getHeight());
			for (int y= 0 ; y< 10 ; y++) {
				 if ( plateau.board[y][x]==null){
					g.setFont(font);
					g.setColor(Color.black);
					g.drawString("null",x*this.getWidth()/10 ,((y+1)*this.getHeight()/10-20));
				}
				 else if (plateau.board[y][x].getThisriverpiece()!= null) {
					 g.setColor(Color.blue);
					 g.drawString(plateau.board[y][x].getThisriverpiece().toString(),(x*this.getWidth()/10 )+3,((y+1)*this.getHeight()/10-20) );
					
				 }
				 else if ( plateau.board[y][x].getThispiece().getSquad().equals("Ennemy")){
						g.setFont(font);
						g.setColor(Color.red);
						g.drawString(plateau.board[y][x].getThispiece().toString(),(x*this.getWidth()/10)+3 ,((y+1)*this.getHeight()/10)-20);
					}
				else  {
						g.setFont(font);
						g.setColor(Color.green);
						g.drawString(plateau.board[y][x].getThispiece().toString(),(x*this.getWidth()/10)+3 ,((y+1)*this.getHeight()/10)-20);
					}
				
			}
			
		}
		
		if (PlacementPawn.clique==true) {
			g.setColor(Color.white);
			g.setColor(Color.yellow);
			g.drawString(BeforeGame.plateauGameGraphic.plateau.board[PlacementPawn.YellowY][PlacementPawn.YellowX].getThispiece()
					.toString(),(PlacementPawn.YellowX*this.getWidth()/10)+3 ,(PlacementPawn.YellowY+1)*this.getHeight()/10-20);
		 } 
	}
}


	
	
