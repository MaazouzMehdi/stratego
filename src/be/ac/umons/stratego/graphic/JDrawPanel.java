package be.ac.umons.stratego.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout; 

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JButton;


public class JDrawPanel extends JPanel {

	public JDrawPanel(  ) {
		this.setLayout(new GridLayout(10, 10));
	}
	/* Je pars du principe que array.length est le tableau de jeu qui
	   se trouve dans une autre classe.
	*/
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		//for (int i = 0; i <  10; i++) {
		//	for (int j = 0; j <  10 ; j++) {
				/* 
					J'adhère pas trop, parce que lorsque
					un pion va se déplacer, tu vas soit 
					permuter deux JButtons, soit permuter
					les images de deux JButtons... Pas top.
				*/
				//this.add(new Button("Empty"));
			//}
		//}

		/*
			Maintenant tu peux dessiner tes lignes :)
		*/		
	}
}