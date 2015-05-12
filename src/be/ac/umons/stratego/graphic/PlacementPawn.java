package be.ac.umons.stratego.graphic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JFrame;

import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.CellObject;
import be.ac.umons.stratego.pion.Direction;
import be.ac.umons.stratego.pion.Pion;
import be.ac.umons.stratego.plateau.PlateauBase;

public class PlacementPawn extends FenetreGame  {

	public PlacementPawn(DrawPlateau plateauGameGraphic) {
		super(plateauGameGraphic);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	static boolean placement = true;
	public static boolean deplacement=false;
	public static boolean myPion=false;

	public static boolean PionMove(final PionPosition pion, final DrawPlateau plateauGameGraphic) {
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
					//if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY && e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX )
						//System.out.println("on peut pas se deplacer sur soi meme");
						//myPion=false;
					if (myPion==true) {
						if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY) {
							if (plateauGameGraphic.plateau.board[pion.posX ][pion.posY].getThispiece().
							deplacement(Direction.SOUTH,plateauGameGraphic.plateau,1)) {
							//if (e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX +1){
								//if (plateauGameGraphic.plateau.board[pion.posX +1][pion.posY].getThisriverpiece()==null ) {
								//plateauGameGraphic.plateau.board[pion.posX +1][pion.posY]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
								//plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null; 
								System.out.println("se deplace a droite");
							}
								/*else if (plateauGameGraphic.plateau.board[pion.posX +1][pion.posY]==null) {
									plateauGameGraphic.plateau.board[pion.posX +1][pion.posY]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null; 
								}
								
								else if (!plateauGameGraphic.plateau.board[pion.posX +1][pion.posY].getThispiece().getSquad().equals
								(plateauGameGraphic.plateau.board[pion.posX][pion.posY].getThispiece().getSquad())) {
									plateauGameGraphic.plateau.board[pion.posX +1][pion.posY]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null; 
								} */
								else {
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									emplacement3.repaint();
									//ChoicePion(plateauGameGraphic);
									
								
								}
					
							}
							else if(e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX -1) {
								if (plateauGameGraphic.plateau.board[pion.posX-1][pion.posY]==null
								&& plateauGameGraphic.plateau.board[pion.posX-1][pion.posY].getThisriverpiece()==null
								&& !plateauGameGraphic.plateau.board[pion.posX-1][pion.posY].getThispiece().getSquad().equals
									(plateauGameGraphic.plateau.board[pion.posX][pion.posY].getThispiece().getSquad())) {
										plateauGameGraphic.plateau.board[pion.posX-1][pion.posY]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
										plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null;
								}
								else
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
								emplacement3.repaint();
								
								
							}
							
						
						}
						else  {
							if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY +1) {
								if (plateauGameGraphic.plateau.board[pion.posX][pion.posY+1]==null) {
									plateauGameGraphic.plateau.board[pion.posX][pion.posY+1]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null;
								}
								else if(plateauGameGraphic.plateau.board[pion.posX][pion.posY+1].getThisriverpiece()==null) {
									plateauGameGraphic.plateau.board[pion.posX][pion.posY+1]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null;
								}
								else if ((!plateauGameGraphic.plateau.board[pion.posX][pion.posY+1].getThispiece().getSquad().equals
									(plateauGameGraphic.plateau.board[pion.posX][pion.posY].getThispiece().getSquad()))){
									plateauGameGraphic.plateau.board[pion.posX][pion.posY+1]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null;
								}
								else
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
								emplacement3.repaint();
								
						
							}
							else if(e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY -1) {
								if (plateauGameGraphic.plateau.board[pion.posX][pion.posY-1]==null) {
									plateauGameGraphic.plateau.board[pion.posX][pion.posY-1]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null;
								}
								else if ((plateauGameGraphic.plateau.board[pion.posX][pion.posY-1].getThisriverpiece()==null)) {
									plateauGameGraphic.plateau.board[pion.posX][pion.posY-1]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null;
								}
								else if((!plateauGameGraphic.plateau.board[pion.posX][pion.posY-1].getThispiece().getSquad().equals
									(plateauGameGraphic.plateau.board[pion.posX][pion.posY].getThispiece().getSquad()))){
									plateauGameGraphic.plateau.board[pion.posX][pion.posY-1]=plateauGameGraphic.plateau.board[pion.posX][pion.posY];
									plateauGameGraphic.plateau.board[pion.posX][pion.posY]=null;
								}
								else {
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
								}
								emplacement3.repaint();
							
							}
						
						}
						emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
						plateauGameGraphic.repaint();
						emplacement3.repaint();
						Game.GameBegin(plateauGameGraphic);
							
					}
					
			
			
			
		});
		
			
			
		return deplacement;
}
			
	
	public static boolean ChoicePion(final DrawPlateau plateauGameGraphic) {
		panelSud.revalidate();
		emplacement3.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {}
			
				@Override
				public void mousePressed(MouseEvent e) {
					if ((plateauGameGraphic.plateau.board[e.getX()/(plateauGameGraphic.getWidth()/10)][e.getY()/(plateauGameGraphic.getHeight()/10)])!=null 
				    && (plateauGameGraphic.plateau.board[e.getX()/(plateauGameGraphic.getWidth()/10)][e.getY()/(plateauGameGraphic.getHeight()/10)].getThisriverpiece())==null 
				    && !(plateauGameGraphic.plateau.board[e.getX()/(plateauGameGraphic.getWidth()/10)][e.getY()/(plateauGameGraphic.getHeight()/10)].getThispiece()).getSquad().equals("Ennemy") 
					&& !plateauGameGraphic.plateau.board[e.getX()/(plateauGameGraphic.getWidth()/10)][e.getY()/(plateauGameGraphic.getHeight()/10)].getThispiece().toString().equals("B")
					&& !plateauGameGraphic.plateau.board[e.getX()/(plateauGameGraphic.getWidth()/10)][e.getY()/(plateauGameGraphic.getHeight()/10)].getThispiece().toString().equals("F")){
							PionPosition pion = new PionPosition(e.getX()/(plateauGameGraphic.getWidth()/10),e.getY()/(plateauGameGraphic.getHeight()/10));
							 myPion=true;
							 System.out.println("bon pion choisi");
							 emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
							 PionMove(pion,plateauGameGraphic);
							
						}
						else 
							System.out.println("mauvais choix");
						
							
							
			
				}
				@Override
				public void mouseExited(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseClicked(MouseEvent e) {}
			
			});
	return myPion;
		
	}
	
	
	public static boolean  PlacementMyPawn(final Button b,final DrawPlateau plateauGameGraphic) {
			panelSud.add(b);
		    b.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					System.out.println(b.toString());
						if (b.getY()/(plateauGameGraphic.getHeight()/10) > 5) {
							if (plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]==null) {
								if (b.name.equals("COLONEL"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.COLONEL,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("CAPTAIN"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.CAPTAIN,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("MARECHAL"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.MARECHAL,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("FLAG"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.FLAG,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("BOMB"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.BOMB,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("MAJOR"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.MAJOR,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("SPY"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.SPY,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("MINER"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.MINER,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("GENERAL"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.GENERAL,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("LIEUTENANT"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.LIEUTENANT,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else if (b.name.equals("SCOUT"))
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.SCOUT,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								else 
									plateauGameGraphic.plateau.board[b.getX()/(plateauGameGraphic.getWidth()/10)][b.getY()/(plateauGameGraphic.getHeight()/10)]=
									new Cell(CellObject.SERGEANT,b.getX()/(plateauGameGraphic.getWidth()/10),b.getY()/(plateauGameGraphic.getHeight()/10),"Friend");
								
								plateauGameGraphic.remove(b);
								plateauGameGraphic.revalidate();
								panelSud.revalidate();
								b.removeMouseListener(b.getMouseListeners()[0]);
								emplacement3.repaint();
								 if (PlacementPawn.VerifyMyPawn(plateauGameGraphic)==true) 
									 Game.GameBegin(plateauGameGraphic);
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
		    b.removeMouseListener(b.getMouseListeners()[0]);
		    
		    b.addMouseMotionListener(new MouseMotionListener()
		    {
		    	
		    	public void mouseDragged(MouseEvent e) {
		    		plateauGameGraphic.add(b);
		    		emplacement3.repaint();
		    		b.setLocation(b.getX()+e.getX(),b.getY() + e.getY() );
		    	}

				public void mouseMoved(MouseEvent e) {}

			

				  });
		    b.removeMouseMotionListener(b.getMouseMotionListeners()[0]);
		    return placement;
	
		
	}
	
	public static void PlacementEnnemyPawn(DrawPlateau plateauGameGraphic) {
		PlateauBase.pawnRandomEnnemy(plateauGameGraphic.plateau);
		PlateauBase.afficherTab(plateauGameGraphic.plateau);
		emplacement3.repaint();
		//plateauGameGraphic.repaint();
		//for (int x=0 ; x < 10 ; x++ ) {
		//	for (int y=0; y<4; y++) {
			//	plateauGameGraphic.plateau.board[x][y]= plateau.board[x][y];
				//emplacement3.repaint();
			//}
		//}
	}
	
	public static boolean VerifyMyPawn(final DrawPlateau plateauGameGraphic) {
		boolean PlacementAllPawn = true;
		emplacement3.repaint();
		//for (int y=6; y<10; y++) {
			//for (int x=0; x<10; x++) {
				if (plateauGameGraphic.plateau.board[8][8]==null){
					PlacementAllPawn = false;
				}
			//}
		//}
		System.out.println("pions sont placés");
		return PlacementAllPawn;
	}

	
	
	
}
