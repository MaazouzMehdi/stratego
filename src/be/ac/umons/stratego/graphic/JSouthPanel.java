package be.ac.umons.stratego.graphic;

import javax.swing.JPanel;

public class JSouthPanel extends JPanel implements MouseMotionListener;

	public JSouthPanel() {

		// Tu placeras tout ce qui concerne ton plateau 'Sud' ici.
		// Serieux, indente tout ça, tu trouveras plus facilement
		// les erreurs :)
		panelSouth.add(b);
		    b.addMouseMotionListener(new MouseMotionListener()
		    {
		    	
		    public void mouseDragged(MouseEvent e) {
					plateauGame.add(b);
					 repaint(); // permet d'éviter la trainée
					 setLocation(b.getX()+e.getX(), b.getY()+e.getY());
					 
					 PlacementPionsAlly();

				}


				public void mouseMoved(MouseEvent e) {}
				
				public void PlacementPionsAlly() {
					if(b.getX()> (plateauGame.getWidth()/10) * 5){
						panelNord.add(b);
						plateauGame.remove(b);
				
						}
					else 
						 b.setLocation(b.getX(),0);
						
					}			
		    });
	}
