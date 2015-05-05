package be.ac.umons.stratego.graphic;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import be.ac.umons.stratego.graphic.FenetreGame;

public class DrawPlateau extends JPanel  {
	
	static int x_Int;
	static int y_Int;
	
	public void paintComponent(Graphics g){
		// trace 10 Horizontal Lines
		for (float x = this.getWidth()/10 ; x< ((this.getWidth()/10)*11) ; x = x + this.getWidth()/10) {
			
			//converting because the method drawLine() takes only integer parameters
			x_Int=(int)x;
			g.drawLine(x_Int + 6, 0, x_Int + 6 ,this.getHeight());
		}
		
		for (float y = this.getHeight()/10 ; y < ((this.getHeight()/10)*11) ; y = y + this.getHeight()/10) {
			y_Int=(int)y;
			g.drawLine(0, y_Int + 6,this.getWidth() ,y_Int + 6);
		}
		
	}
}
	
