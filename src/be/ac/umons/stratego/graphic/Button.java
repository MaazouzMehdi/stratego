package be.ac.umons.stratego.graphic;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class Button extends JButton  {
	
	
	public String name;
	public Button(String name) {
		super(name) ; 
		this.name=name;
	}       
}