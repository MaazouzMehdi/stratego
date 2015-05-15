package be.ac.umons.stratego.graphic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import be.ac.umons.stratego.pawn.SaveLoad;

public class WindowEnd extends JFrame  {

	/**
	 * @param args
	 */
	private Panneau emplacement5=new Panneau();
	
	public WindowEnd()
	{
		EndLabel affichage = new EndLabel();
		this.setTitle("Bienvenue dans le Stratego");
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
	    this.add(affichage,BorderLayout.CENTER);
	    this.add(emplacement5,BorderLayout.NORTH);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emplacement5.repaint();
	}
	
}
