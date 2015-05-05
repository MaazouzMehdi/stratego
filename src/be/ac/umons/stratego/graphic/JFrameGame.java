package be.ac.umons.stratego.graphic;

/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel;

// Pas besoin d'import, ils sont dans le meme package.
import be.ac.umons.stratego.graphic.SavePionPlateau;

public class JFrameGame extends JFrame {

	private Panneau emplacement3 = new Panneau();
	/* 
		Preferable de faire une autre classe, comme je
		l'ai réalisé avec JSouthPanel (convention: on met
		le 'J' devant le panel, tu risques de perdre des points
		sinon

	private JPanel panelNorth = new JPanel();
	private JSouthPanel panelSouth = new SouthPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelWest = new JPanel();
	// Attention, tu risques de perdre des points, soit tu fais TOUT
	// le projet en français, soit TOUT le projet en anglais.
	private DrawPlateau plateauGame = new DrawPlateau();
		
	// Pas besoin de mettre 'this', c'est explicite.
	public JFrameGame() {
	    	setTitle("Bienvenue dans la Stragego");
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(emplacement3); // Faut revoir ton approche. 
		setLayout(new BorderLayout());
		add(panelNord,BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);
		add(plateauGame,BorderLayout.CENTER);
		add(panelEast,BorderLayout.EAST);
		add(panelWest,BorderLayout.WEST);
	}
}
