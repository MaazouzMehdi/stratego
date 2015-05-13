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

	
	public static void SpecialPionMove( final PionPosition pion, final DrawPlateau plateauGameGraphic) {
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
			if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY) {
				if (e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX) {
					emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
					ChoicePion(plateauGameGraphic);
				}
				else if(e.getX()/(plateauGameGraphic.getWidth()/10) > pion.posX) { 
						if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
						deplacementPossible(Direction.EAST,plateauGameGraphic.plateau,e.getX()/(plateauGameGraphic.getWidth()/10) - pion.posX)) {
							
							plateauGameGraphic.plateau.board[pion.posY ][pion.posX].getThispiece().
							deplacement(Direction.EAST,plateauGameGraphic.plateau,e.getX()/(plateauGameGraphic.getWidth()/10) - pion.posX);
						}
							
						else {
							emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
							ChoicePion(plateauGameGraphic);
						}
					emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);		
					Game.GameBegin(plateauGameGraphic);
				}
				else if (e.getX()/(plateauGameGraphic.getWidth()/10) < pion.posX ) {
					if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
							deplacementPossible(Direction.WEST,plateauGameGraphic.plateau,pion.posX -(e.getX()/(plateauGameGraphic.getWidth()/10)))) {
								
								plateauGameGraphic.plateau.board[pion.posY ][pion.posX].getThispiece().
								deplacement(Direction.WEST,plateauGameGraphic.plateau,pion.posX -(e.getX()/(plateauGameGraphic.getWidth()/10)));
					}
					else {
						emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
						ChoicePion(plateauGameGraphic);
					}
					emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
					Game.GameBegin(plateauGameGraphic);
				}
				else {
					emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
					ChoicePion(plateauGameGraphic);
				}
			}
			else if(e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX) {
				if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY) {
					emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
					ChoicePion(plateauGameGraphic);
				}
				else if(e.getY()/(plateauGameGraphic.getHeight()/10)>pion.posY) {
					if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
							deplacementPossible(Direction.SOUTH,plateauGameGraphic.plateau,e.getY()/(plateauGameGraphic.getHeight()/10) - pion.posY)) {
								
								plateauGameGraphic.plateau.board[pion.posY ][pion.posX].getThispiece().
								deplacement(Direction.SOUTH,plateauGameGraphic.plateau,e.getY()/(plateauGameGraphic.getHeight()/10) - pion.posY);
					}
					else {
						emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
						ChoicePion(plateauGameGraphic);
					}
					emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
					Game.GameBegin(plateauGameGraphic);
				}
				else {
					if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
							deplacementPossible(Direction.NORTH,plateauGameGraphic.plateau,pion.posY -(e.getY()/(plateauGameGraphic.getHeight()/10)))){
								
								plateauGameGraphic.plateau.board[pion.posY ][pion.posX].getThispiece().
								deplacement(Direction.NORTH,plateauGameGraphic.plateau,pion.posY -(e.getY()/(plateauGameGraphic.getHeight()/10)));
					}
					else {
						emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
						ChoicePion(plateauGameGraphic);
					}
					emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);	
					Game.GameBegin(plateauGameGraphic);
			}
			
		 }
			else {
				emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
				ChoicePion(plateauGameGraphic);
			}
		}
				
	  });
	}
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
				
					 if (myPion==true) {    //////////////////////////
						if (e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY) {
							if(e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX+1) {
								if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
								deplacementPossible(Direction.EAST,plateauGameGraphic.plateau,1)) {
								
									plateauGameGraphic.plateau.board[pion.posY ][pion.posX].getThispiece().
									deplacement(Direction.EAST,plateauGameGraphic.plateau,1);
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									Game.GameBegin(plateauGameGraphic);
								}
								else {
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									ChoicePion(plateauGameGraphic);
								}
							}
							else if(e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX-1) {
					
								if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
								deplacementPossible(Direction.WEST,plateauGameGraphic.plateau,1)) {
									
									plateauGameGraphic.plateau.board[pion.posY ][pion.posX].getThispiece().
									deplacement(Direction.WEST,plateauGameGraphic.plateau,1);
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									Game.GameBegin(plateauGameGraphic);
								}
								else
									ChoicePion(plateauGameGraphic);
							
							}
						}
						
						else if(e.getX()/(plateauGameGraphic.getWidth()/10)==pion.posX) {
							if(e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY+1) {
								if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
								deplacementPossible(Direction.SOUTH,plateauGameGraphic.plateau,1)) {
								
									plateauGameGraphic.plateau.board[pion.posY ][pion.posX].getThispiece().
									deplacement(Direction.SOUTH,plateauGameGraphic.plateau,1);
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									Game.GameBegin(plateauGameGraphic);
								}
								else {
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									ChoicePion(plateauGameGraphic);
								}
							}
							else if(e.getY()/(plateauGameGraphic.getHeight()/10)==pion.posY-1) {
								if (plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
								deplacementPossible(Direction.NORTH,plateauGameGraphic.plateau,1)) {
								
									plateauGameGraphic.plateau.board[pion.posY][pion.posX].getThispiece().
									deplacement(Direction.NORTH,plateauGameGraphic.plateau,1);
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									Game.GameBegin(plateauGameGraphic);
								}
								else {
									emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
									ChoicePion(plateauGameGraphic);	
								}
							}
						}
					}
				emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
				ChoicePion(plateauGameGraphic);
					
				//emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
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
					if ((plateauGameGraphic.plateau.board[e.getY()/(plateauGameGraphic.getHeight()/10)][e.getX()/(plateauGameGraphic.getWidth()/10)])!=null 
				    && (plateauGameGraphic.plateau.board[e.getY()/(plateauGameGraphic.getHeight()/10)][e.getX()/(plateauGameGraphic.getWidth()/10)].getThisriverpiece())==null 
				    && !(plateauGameGraphic.plateau.board[e.getY()/(plateauGameGraphic.getHeight()/10)][e.getX()/(plateauGameGraphic.getWidth()/10)].getThispiece()).getSquad().equals("Ennemy") 
					&& !plateauGameGraphic.plateau.board[e.getY()/(plateauGameGraphic.getHeight()/10)][e.getX()/(plateauGameGraphic.getWidth()/10)].getThispiece().toString().equals("B")
					&& !plateauGameGraphic.plateau.board[e.getY()/(plateauGameGraphic.getHeight()/10)][e.getX()/(plateauGameGraphic.getWidth()/10)].getThispiece().toString().equals("F")){
							PionPosition pion = new PionPosition(e.getY()/(plateauGameGraphic.getHeight()/10),e.getX()/(plateauGameGraphic.getWidth()/10));
							myPion=true;
							emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
							if (plateauGameGraphic.plateau.board[e.getY()/(plateauGameGraphic.getHeight()/10)][e.getX()/(plateauGameGraphic.getWidth()/10)].getThispiece().toString().equals("SC"))
								SpecialPionMove(pion,plateauGameGraphic);
							else 
								PionMove(pion,plateauGameGraphic);
							System.out.println("bon pion choisi");
							 //emplacement3.repaint();
							 
							
						}
						else //{
							//emplacement3.removeMouseListener(emplacement3.getMouseListeners()[0]);
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
							if (plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]==null) {
								if (b.name.equals("COLONEL"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.COLONEL,b.getY()/(plateauGameGraphic.getWidth()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("CAPTAIN"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.CAPTAIN,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("MARECHAL"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.MARECHAL,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("FLAG"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.FLAG,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("BOMB"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.BOMB,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("MAJOR"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.MAJOR,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("SPY"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.SPY,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("MINER"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.MINER,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("GENERAL"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.GENERAL,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("LIEUTENANT"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.LIEUTENANT,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else if (b.name.equals("SCOUT"))
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.SCOUT,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								else 
									plateauGameGraphic.plateau.board[b.getY()/(plateauGameGraphic.getHeight()/10)][b.getX()/(plateauGameGraphic.getWidth()/10)]=
									new Cell(CellObject.SERGEANT,b.getY()/(plateauGameGraphic.getHeight()/10),b.getX()/(plateauGameGraphic.getWidth()/10),"Friend");
								
								plateauGameGraphic.remove(b);
								plateauGameGraphic.revalidate();
								panelSud.revalidate();
								b.removeMouseListener(b.getMouseListeners()[0]);
								//emplacement3.repaint();
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
					//emplacement3.repaint();
					
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
