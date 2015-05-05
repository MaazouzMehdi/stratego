package be.ac.umons.stratego.graphic;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pions extends JPanel {
	
	public String name;
	
	public Pions(String name) {
		this.name=name;
	}
	public void paintComponent(Graphics g){
		 //Graphics2D g2d = (Graphics2D)g;
		 g.fillRect(0, 0, this.getHeight(), this.getWidth());    

	}

}
