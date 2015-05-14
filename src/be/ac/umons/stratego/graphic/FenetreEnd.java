package be.ac.umons.stratego.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import be.ac.umons.stratego.pion.SaveLoad;

public class FenetreEnd extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	private Panneau emplacement1=new Panneau();
	//public final static DrawPlateau plateauGameGraphic= new DrawPlateau(new PlateauBase());
	private JButton bouton1 = new JButton("Recommencer une partie");
	private JButton bouton2 = new JButton("Menu Principal");
	private JButton bouton3 = new JButton("Quitter");
	
	public FenetreEnd()
	{
		this.setTitle("Bienvenue dans le Stratego");
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		
		//on prévient notre JFrame que ce sera notre Jpannel
		this.getContentPane().add(emplacement1);
		emplacement1.add(bouton1); // on ajoute les boutons au JPanel, ainsi l'image est sauvegarder
		emplacement1.add(bouton2);
		emplacement1.add(bouton3);
		bouton1.addActionListener(this);
		bouton2.addActionListener(this); 
		bouton3.addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if((JButton)e.getSource()==bouton1)
		{
			BeforeGame.plateauGameGraphic.removeAll();
			BeforeGame.plateauGameGraphic.repaint();
			Game.NewGame(BeforeGame.plateauGameGraphic);
			FenetreGame.emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new FenetreGame(BeforeGame.plateauGameGraphic);
			FenetreGame.count =true;
		}
		else if ((JButton)e.getSource()==bouton3)
		{
			System.exit(0); // permet de quitter le programme définitevement
		}
		
		else {
			BeforeGame.plateauGameGraphic.removeAll();
			BeforeGame.plateauGameGraphic.repaint();
			Game.NewGame(BeforeGame.plateauGameGraphic);
			FenetreGame.emplacement3.add(BeforeGame.plateauGameGraphic);
			this.dispose();
			new Interface();
		}
			
	}
}
