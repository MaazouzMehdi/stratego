package be.ac.umons.stratego.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class EndLabel extends JLabel {

	public void paintComponent(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 20);
		if (Game.win==true) {
			g.setFont(font);
			g.setColor(Color.green);
			g.drawString("VOUS AVEZ GAGNER",this.getWidth()/2,this.getHeight()/2);
	 	}
		else if ( Game.nul==true){
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString("MATCH NUL",this.getWidth()/2,this.getHeight()/2);
		}
		else if ( Game.defeat==true) {
			g.setFont(font);
			g.setColor(Color.red);
			g.drawString("VOUS AVEZ PERDU",this.getWidth()/2,this.getHeight()/2);
			
		}
	}
}
	