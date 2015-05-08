package be.ac.umons.stratego.graphic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JFrame;
import be.ac.umons.stratego.plateau.PlateauBase;

public class PlacementPawn extends FenetreGame  {

	/**
	 * @param args
	 */
	static boolean placement = true;
	public static boolean deplacement=false;

	public static boolean Deplacement(final PionPosition pion) {
		emplacement3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
					System.out.println("deplacement");
					if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY) {
						if (e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX +1) {
							plateauGameGraphic.plateau.zone[pion.posX +1][pion.posY]=plateauGameGraphic.plateau.zone[pion.posX][pion.posY];
							plateauGameGraphic.plateau.zone[pion.posX][pion.posY]="null";
							emplacement3.repaint();
							deplacement=true;
							System.out.println(deplacement);
					
						}
						else if(e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX -1) {
							plateauGameGraphic.plateau.zone[pion.posX-1][pion.posY]=plateauGameGraphic.plateau.zone[pion.posX][pion.posY];
							plateauGameGraphic.plateau.zone[pion.posX][pion.posY]="null";
							emplacement3.repaint();
							deplacement=true;
							//ChoicePion();
						}
							//ChoicePion();
						
					}
					else  {
						if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY +1) {
							plateauGameGraphic.plateau.zone[pion.posX][pion.posY+1]=plateauGameGraphic.plateau.zone[pion.posX][pion.posY];
							plateauGameGraphic.plateau.zone[pion.posX][pion.posY]="null";
							emplacement3.repaint();
							deplacement=true;
							//ChoicePion();
						
						}
						else if(e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY -1) {
							plateauGameGraphic.plateau.zone[pion.posX][pion.posY-1]=plateauGameGraphic.plateau.zone[pion.posX][pion.posY];
							plateauGameGraphic.plateau.zone[pion.posX][pion.posY]="null";
							emplacement3.repaint();
							deplacement=true;
							//ChoicePion();
						}
						
					}
				}
		});
		return deplacement;
}
			
	
	public static boolean ChoicePion(final PionPosition pion) {
			emplacement3.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {}
			
				@Override
				public void mousePressed(MouseEvent e) {
						if (!(plateauGameGraphic.plateau.zone[e.getX()/(plateauGameGraphic.getWidth()/10)][e.getY()/(plateauGameGraphic.getHeight()/10)])
								.equals("null") && !(plateauGameGraphic.plateau.zone[e.getX()/(plateauGameGraphic.getWidth()/10)][e.getY()/(plateauGameGraphic.getHeight()/10)])
								.equals("RIVER")) {
							 pion.posX=e.getX()/(plateauGameGraphic.getWidth()/10);
							 pion.posY=e.getY()/(plateauGameGraphic.getHeight()/10);
							 deplacement=true;
							// Deplacement(pion);
							
						}
					//else {
						//System.out.println("mauvais choix");
						//ChoicePion();
			
				}
				@Override
				public void mouseExited(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseClicked(MouseEvent e) {}
			
			});
	return deplacement;
		
	}
	
	
	public static boolean  PlacementMyPawn(final Button b) {
			panelSud.add(b);
		    b.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (b.getY()/(plateauGameGraphic.getHeight()/10) > 5) {
						if (plateauGameGraphic.plateau.zone[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)].equals("null")) {
								plateauGameGraphic.plateau.zone[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]= b.name;
								plateauGameGraphic.remove(b);
								panelSud.revalidate();
						}
						
				 }
					
					else {
						plateauGameGraphic.remove(b);
						panelSud.add(b);
						panelSud.revalidate();
						placement=false;
					}
					
					emplacement3.repaint();
					
					
					
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		    b.addMouseMotionListener(new MouseMotionListener()
		    {
		    	
		    	public void mouseDragged(MouseEvent e) {
		    		plateauGameGraphic.add(b);
		    		emplacement3.repaint();
		    		b.setLocation(b.getX()+e.getX(),b.getY() + e.getY() );
		    	}

				public void mouseMoved(MouseEvent e) {}

			

				  });
		    return placement;
	
		
	}
	
	public static void PlacementEnnemyPawn() {
		for (int x=0 ; x < 10 ; x++ ) {
			for (int y=0; y<4; y++) {
				plateauGameGraphic.plateau.zone[x][y]= "Ennemy";
				emplacement3.repaint();
			}
		}
	}
	
	
}
