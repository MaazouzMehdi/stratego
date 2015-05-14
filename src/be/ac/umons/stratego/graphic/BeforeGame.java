package be.ac.umons.stratego.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import be.ac.umons.stratego.pion.SaveLoad;
import be.ac.umons.stratego.plateau.PlateauBase;

public class BeforeGame extends JFrame implements ActionListener {
	private Panneau emplacement1=new Panneau();
	public final static DrawPlateau plateauGameGraphic= new DrawPlateau(new PlateauBase());
	private JButton bouton1 = new JButton("Nouvelle Partie");
	private JButton bouton2 = new JButton("Charger Partie");
	
	public BeforeGame() {
		this.setTitle("Bienvenue dans le Stratego");
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		
		//on prévient notre JFrame que ce sera notre Jpannel
		this.getContentPane().add(emplacement1);
		emplacement1.add(bouton1); // on ajoute les boutons au JPanel, ainsi l'image est sauvegarder
		emplacement1.add(bouton2);
		
		bouton1.addActionListener(this);
		bouton2.addActionListener(this); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if((JButton)e.getSource()==bouton1)
		{
			this.dispose(); // permet de fermer la fenetre
			new FenetreGame(plateauGameGraphic);
		}		
		else {
			this.dispose();
			try {
				SaveLoad.LoadGame();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
	}
}
