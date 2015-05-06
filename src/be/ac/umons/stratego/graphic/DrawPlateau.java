package be.ac.umons.stratego.graphic;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import be.ac.umons.stratego.graphic.FenetreGame;
import be.ac.umons.stratego.plateau.PlateauBase;

public class DrawPlateau extends JPanel  {
	
	public PlateauBase plateau=new PlateauBase();
	
	
	public void paintComponent(Graphics g){
			final float cellX=getWidth()/10;
			final float cellY=getHeight()/10;
		
		Font font = new Font("Courier",Font.BOLD,20);
		
		for (int y = 1; y < 10; y++)
			g.drawLine(0, (int)(y*cellY), getWidth(), (int)(y*cellY));
		
		for (int x = 0 ; x < 10; x++ ) {
			g.drawLine((int)((x+1)*cellX), 0, (int)((x+1)*cellX), getHeight());
			for (int y = 0 ; y < 10 ; y++) {
				if ( y<4){
					g.setFont(font);
					g.setColor(Color.red);
					g.drawString(plateau.zone[x][y],x*this.getWidth()/10 ,(y+1)*this.getHeight()/10);
				}
				else if (y >= 4 && y< 6) {
					g.setFont(font);
					g.setColor(Color.black);
					g.drawString(plateau.zone[x][y],x*this.getWidth()/10 ,(y+1)*this.getHeight()/10);
				}
				else {
					g.setFont(font);
					g.setColor(Color.green);
					g.drawString(plateau.zone[x][y],x*this.getWidth()/10 ,(y+1)*this.getHeight()/10);
				}
				
				
			}
			
		}
		
		g.setColor(Color.blue);
		g.drawString(plateau.zone[7][5],7*this.getWidth()/10 ,(5+1)*this.getHeight()/10 );
		g.drawString(plateau.zone[2][5],2*this.getWidth()/10 ,(5+1)*this.getHeight()/10 );
		
	}
}
	
