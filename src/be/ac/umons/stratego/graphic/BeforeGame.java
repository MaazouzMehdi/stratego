package be.ac.umons.stratego.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import be.ac.umons.stratego.pawn.SaveLoad;
import be.ac.umons.stratego.board.BaseBoard;


public class BeforeGame extends JFrame implements ActionListener {
	private Panneau emplacement1=new Panneau();
	public final static DrawPlateau plateauGameGraphic= new DrawPlateau(new BaseBoard());
	private JButton bouton1 = new JButton("Nouvelle Partie");
	private JButton bouton2 = new JButton("Charger Partie");
	
	public BeforeGame() {
		this.setTitle("Bienvenue dans le Stratego");
		this.setSize(800, 800);
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
			WindowGame.countColonel=0 ;WindowGame.countMajor=0 ; WindowGame.countGeneral=0;
			WindowGame.countLieutenant=0;WindowGame.countMarechal=0; WindowGame.countCaptain=0;WindowGame.countFlag=0;
			WindowGame.countSergeant=0; WindowGame.countMiner=0;WindowGame.countSpy=0;WindowGame.countScout=0;
			WindowGame.countBomb=0;
			WindowGame.panelSud.removeAll();
			BeforeGame.plateauGameGraphic.removeAll();
			BeforeGame.plateauGameGraphic.repaint();
			WindowGame.emplacement3.add(BeforeGame.plateauGameGraphic);
			Game.NewGame(BeforeGame.plateauGameGraphic);
			this.dispose(); // permet de fermer la fenetre
			new WindowGame(plateauGameGraphic);
		}		
		else {
			this.dispose();
			try {
				SaveLoad.LoadGame();
				BeforeGame.plateauGameGraphic.repaint();
				new WindowGame(plateauGameGraphic);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
	}
}
