package be.ac.umons.stratego.graphic;

import javax.swing.JButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class WindowOption extends Interface
	{
		public boolean Ia_Hard=false;
		private PanelOption emplacement2=new PanelOption();
		private JButton bouton5 = new JButton("Retour");
		private JButton bouton4 = new JButton("Difficulté");
		// objet qui va servir a choisir la difficulté
		private JComboBox<String> choixDifficulter = new JComboBox<String>();
		
		public WindowOption()
		{
			this.setTitle("Bienvenue dans le Menu du Stratego");
			this.setSize(800,800);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//on prévient notre JFrame que ce sera notre Jpannel
			this.setContentPane(emplacement2);
			
			//placement des boutons
			emplacement2.add(bouton5);
			bouton5.addActionListener(this);
			emplacement2.add(bouton4);
			bouton4.addActionListener(this);
			
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if ((JButton)e.getSource()==bouton5)
			{
				this.dispose();
				new Interface();
				
			}
			else if ((JButton)e.getSource()==bouton4)
			{
				emplacement2.add(choixDifficulter);
				choixDifficulter.addItem("Facile");
				choixDifficulter.addItem("Difficile");
				choixDifficulter.addActionListener(new ItemAction());
				
			}
				
			
		}
		class ItemAction implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		      if ( choixDifficulter.getSelectedItem().equals("Facile"))
		    	  Game.Ia_hard=false;  
		    else if (choixDifficulter.getSelectedItem().equals("Difficile") )
		    	Game.Ia_hard=true;
		      
		  }

	}

}