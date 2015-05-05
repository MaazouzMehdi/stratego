package be.ac.umons.stratego.pion;
import be.ac.umons.stratego.plateau.PlateauBase;

public class SpecialPion extends Pion {

    public SpecialPion ( int lvl , int posY , int posX , String equipe ) {
	    this.lvl = lvl;
	    this.posY = posY;
        this.posX = posX;
        this.equipe=equipe;
    }
    
    
    public boolean deplacementPossible ( String direction, PlateauBase plateau, int nbrDeCases ) {
    	int countDeplacement =0;
    	 String caseDeJeu; 
    	 nvlposY=this.posY;
    	 nvlposX=this.posX;
 		if (direction.equals("UP")) {
 			while (countDeplacement < nbrDeCases-1) {
 				nvlposY = nvlposY- 1;
 				if ( nvlposY < 10 && nvlposY >= 0 ) {
 					caseDeJeu = plateau.zone [nvlposY] [this.posX];  
 					if (caseDeJeu.equals("null"))
 						countDeplacement ++;
 					else 
 						return false;
             
 					}
 				else
 					return false;
 			}
 			nvlposY= nvlposY -1;
 			
 			if (nvlposY < 10 && nvlposY >= 0) {
 				caseDeJeu = plateau.zone [nvlposY] [this.posX];
 				int lengthCase=caseDeJeu.length();
 				if ((caseDeJeu.equals("FLEUVE")) 
 						|(this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))) )
 					
 						return false;
 				else
 					return true;
 			}
 			else
 				return false;
 		
 		}
 		
 		else if (direction.equals("DOWN")) {
		 		while (countDeplacement < nbrDeCases-1) {
		 			nvlposY = nvlposY + 1;
		 			if ( nvlposY < 10 && nvlposY >= 0 ) { 
		 				caseDeJeu = plateau.zone [nvlposY] [this.posX];
		 				if (caseDeJeu.equals("null")) {
		 					countDeplacement ++;
		 				}
		 				else 
		 					return false;
		             
		 					}
		 			else
		 				return false;
		 				}
		 			nvlposY=nvlposY +1;
		 			if (nvlposY < 10 && nvlposY >= 0) {
		 				caseDeJeu = plateau.zone [nvlposY] [this.posX];
		 				int lengthCase=caseDeJeu.length();
		 				if ((caseDeJeu.equals("FLEUVE")) || 
		 						(this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))))
		 					return false;
		 				else
		 					return true;
		 			}
		 			else
		 				return false;
		}
		else if (direction.equals("RIGHT")) {
 		 		while (countDeplacement < nbrDeCases-1) {
 		 			nvlposX = nvlposX + 1;
 		 			if ( nvlposX < 10 && nvlposX >= 0 ) { 
 		 				caseDeJeu = plateau.zone [this.posY] [nvlposX];  
 		 				if (caseDeJeu.equals("null"))
 		 					countDeplacement ++;
 		 				else 
 		 					return false;
 		             
 		 					}
 		 			else
 		 				return false;
 		 				}
 		 			nvlposX=nvlposX +1;
 		 			if (nvlposX < 10 && nvlposX >= 0) {
 		 				caseDeJeu = plateau.zone [this.posY] [nvlposX];
 		 				int lengthCase=caseDeJeu.length();
 		 				if ((caseDeJeu.equals("FLEUVE")) 
 		 						|| (this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))))
 		 					return false;
 		 				else
 		 					return true;
 		 			}
 		 			else
 		 				return false;
			}
	else {
		while (countDeplacement < nbrDeCases-1) {
	 			nvlposX = nvlposX - 1;
	 			if ( nvlposX < 10 && nvlposX >= 0 ) { 
	 				caseDeJeu = plateau.zone [this.posY] [nvlposX];  
	 				if (caseDeJeu.equals("null"))
	 					countDeplacement ++;
	 				else 
	 					return false;
	             
	 					}
	 			else
	 				return false;
	 				}
	 			nvlposX=nvlposX -1;
	 			if (nvlposX < 10 && nvlposX >= 0) {
	 				caseDeJeu = plateau.zone [this.posY] [nvlposX];
	 				int lengthCase=caseDeJeu.length();
	 				if ((caseDeJeu.equals("FLEUVE")) 
	 						|| (this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))))
	 					return false;
	 				else
	 					return true;
	 			}
	 			else
	 				return false;
	 			
		}
    }
    

public boolean deplacement ( String direction, PlateauBase plateau, int nbrDeCases ) { 
    
    if (direction.equals("UP")) {
    	if (deplacementPossible("UP",plateau, nbrDeCases)==true) { 
    		for (int avancementCase=0;avancementCase < nbrDeCases; avancementCase++) {
    			super.deplacement("UP", plateau);

    		}
    		return true;
    	}
        
        else 
        	return false;
    }
        
    else if (direction.equals("DOWN")) {
        	if (deplacementPossible("DOWN",plateau, nbrDeCases)==true) { 
        		for (int avancementCase=0;avancementCase < nbrDeCases; avancementCase++) {
        			super.deplacement("DOWN", plateau);
        			
        			
        		}
        		return true;
           }
            
            else 
            	return false;
     }

    else if (direction.equals("RIGHT")) {
        	if (deplacementPossible("RIGHT",plateau, nbrDeCases)==true) { 
        		for (int avancementCase=0;avancementCase < nbrDeCases; avancementCase++) {
        			super.deplacement("RIGHT", plateau);
        			
        		}
        	return true;	
        		
           }
            
            else 
            	return false;
    }
    else {
        	if (deplacementPossible("LEFT",plateau, nbrDeCases)==true) { 
        		for (int avancementCase=0;avancementCase < nbrDeCases; avancementCase++) {
        			super.deplacement("LEFT", plateau);
        			
        		}
        		return true;
        	}
            
            else 
            	return false;
    }
 }

public static SpecialPion conversion ( String quase, int y , int x ) { 
  	if (quase.equals("SC-F"))
        return new Scout(2,y,x,"Friend");
  	else
  		return new Scout(2,y,x,"Ennemy");
	}

}




