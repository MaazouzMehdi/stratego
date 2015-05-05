package be.ac.umons.stratego.pion;

import be.ac.umons.stratego.plateau.PlateauBase;

public abstract class Pion {

	protected int lvl; 
	protected int posY;
	protected int posX;
	protected static int nvlposX , nvlposY ;
	protected String equipe;
	
	public int getpositionX () {
	    return posX;
	}

    public int getpositionY () {
        return posY;
    }

    public void setposition ( int x , int y ) {    
        posX = x;
        posY = y;        
    }
        
    public int getlvl () {
        return lvl;
    }
    
    public String getSquad() {
    	return equipe;
    }
    
    public static Pion conversion ( String quase, int y , int x ) { // prends le string de la case et retourne un objet du pion correspondant 
   	 
    	
    	if (quase.equals("B-F"))
    	        return new Bomb(-42,y,x,"Friend");
    	else  if (quase.equals("C-F"))
    	        return new Captain(6,y,x,"Friend");
    	else if (quase.equals("S-F"))
    	        return new Spy(-1,y,x,"Friend");
    	else if (quase.equals("SE-F"))
    	        return new Sergeant(4,y,x,"Friend");
    	else if (quase.equals("M-F"))
    	        return new Miner(3,y,x,"Friend");
    	else if (quase.equals("MA-F"))
    	        return new Marechal(10,y,x,"friend");
    	else if (quase.equals("MJ-F"))
    	        return new Major(7,y,x,"Friend");
    	else if (quase.equals("L-F"))
    	        return new Lieutenant(5,y,x,"Friend");
    	else if (quase.equals("G-F"))
    	        return new General(9,y,x,"Friend");
    	else if (quase.equals("F-F"))
    	        return new Flag(0,y,x,"Friend");
    	else if (quase.equals("CO-F"))
    	        return new Colonel(8,y,x,"Friend");
    	        
    	        
    	else if (quase.equals("B-E"))
    	        return new Bomb(42,y,x,"Ennemy");
    	else if (quase.equals("C-E"))
    	        return new Captain(6,y,x,"Ennemy");
    	else if (quase.equals("S-E"))
    	        return new Spy(-1,y,x,"Ennemy");
    	else if (quase.equals("SE-E"))
    	        return new Sergeant(4,y,x,"Ennemy");
    	else if (quase.equals("M-E"))
    	        return new Miner(3,y,x,"Ennemy");
    	else if (quase.equals("MA-E"))
    	        return new Marechal(10,y,x,"Ennemy");
    	else if (quase.equals("MJ-E"))
    	        return new Major(7,y,x,"Ennemy");
    	else if (quase.equals("L-E"))
    	        return new Lieutenant(5,y,x,"Ennemy");
    	else if (quase.equals("G-E"))
    	        return new General(9,y,x,"Ennemy");
    	else if (quase.equals("F-E"))
    	        return new Flag(0,y,x,"Ennemy");
    	else 
    	        return new Colonel(8,y,x,"Ennemy");
    	}
    
	public boolean deplacementPossible ( String direction,PlateauBase plateau ) { // vérifie qu'il n'y a pas de fleuve et qu'il ne dépasse pas le plateau
       String caseDeJeu; 
		if (direction.equals("UP")) {
            nvlposY = this.posY - 1;
            while ( nvlposY < 10 && nvlposY >= 0 ) {
            	caseDeJeu = plateau.zone [nvlposY] [this.posX];
            	int lengthCase = caseDeJeu.length();
            	return ! ((caseDeJeu.equals("FLEUVE")) 
            			|| (this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))));            
            	}
            return false;
        }
		else if (direction.equals("DOWN")) {
            nvlposY = this.posY + 1;
            while ( nvlposY < 10 && nvlposY >= 0 ) {
            	caseDeJeu = plateau.zone [nvlposY] [this.posX];
            	int lengthCase = caseDeJeu.length();
            	return ! ((caseDeJeu.equals("FLEUVE")) 
            			|| (this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))));
            
            }
            return false;
        }    
		else if (direction.equals("LEFT")) {
            nvlposX = this.posX - 1;
            while (nvlposX < 10 && nvlposX >= 0) {
            	caseDeJeu = plateau.zone [this.posY] [nvlposX];
            	int lengthCase = caseDeJeu.length();
            	return ! ((caseDeJeu.equals("FLEUVE")) 
            			|| (this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))));  
            
            }
            return false;
        }    
		else  {
            nvlposX = this.posX + 1;
            while (nvlposX < 10 && nvlposX >= 0) {
            	caseDeJeu = plateau.zone[this.posY] [nvlposX];
            	int lengthCase = caseDeJeu.length();
                return ! (caseDeJeu.equals("FLEUVE") 
                		|| (this.equipe.charAt(0)==(caseDeJeu.charAt(lengthCase-1))));
           
            }
            return false;
	    }
    }


	
   
    public boolean deplacement ( String direction, PlateauBase plateau ) { 
        int nvlposX , nvlposY ;
        String caseDeJeu; 
        
        if (direction.equals("UP")) {
            nvlposY = this.posY - 1; // justification carnet ( sens de Y inverser dans matrice ) 
            if (deplacementPossible("UP",plateau)==true) {
            	 caseDeJeu= plateau.zone [nvlposY] [this.posX];
            	 if (caseDeJeu.equals("null")) {
            		 plateau.zone[this.posY][this.posX]="null";
            		 plateau.zone[nvlposY][this.posX]=this.toString();
            		 this.posY = nvlposY; 
            	 }
            
            	 else
            	 	attaque("UP",conversion(caseDeJeu,nvlposY,this.posX),plateau); // cette méthode comparera le lvl,regardera si c'est un ennemi , mettra le perdant en null et fera un deplacement
            	 return true;
            }
            
            return false;
        }
            
        else if (direction.equals("DOWN")) {
            nvlposY = this.posY + 1;
            if (deplacementPossible("DOWN",plateau)){
            	caseDeJeu = plateau.zone [nvlposY] [this.posX] ;
            		if(caseDeJeu.equals("null")) {
            			plateau.zone[this.posY][this.posX]="null";
            			plateau.zone[nvlposY][this.posX]=this.toString();
            			this.posY = nvlposY; 
            }
                
            		else
            			attaque("UP",conversion(caseDeJeu,nvlposY,this.posX),plateau);
            		return true;	
          }
            return false;
        }
        
        else if (direction.equals("RIGHT")) {
            nvlposX = this.posX + 1;
            if (deplacementPossible("RIGHT",plateau)) {
            	caseDeJeu= plateau.zone [this.posY] [nvlposX];
            		if (caseDeJeu.equals("null")) {
            			plateau.zone[this.posY][this.posX]="null";
            			plateau.zone[this.posY][nvlposX]=this.toString();
            			this.posX = nvlposX; 
            		}
            		else
            			attaque("UP",conversion(caseDeJeu,this.posY,nvlposX),plateau);
            		return true;
            }
            return false;
        }
        
        else {
            nvlposX = this.posX - 1;
            if (deplacementPossible("LEFT",plateau)){
            	caseDeJeu = plateau.zone [this.posY] [nvlposX]; 
            	if (caseDeJeu.equals("null")) {
            		plateau.zone[this.posY][this.posX]="null";
            		plateau.zone[this.posY][nvlposX]=this.toString();
            		this.posX = nvlposX; 
            	}
            	else
            		attaque("UP",conversion(caseDeJeu,this.posY,nvlposX),plateau);
            	return true;
        	}
            return false;
       }
    }
    

    
    public void attaque (String direction , Pion pion , PlateauBase plateau) { //MAJ
    // appelle une methode comparelvl et conversion pour voir qui a le lvl le plus grand ( attention cas spéciaux ) SSI c'est un ennemi qui compare les niveaux des objets et retourne le vainqueur  et AVANT regarde si friend or ennemi true( à faire dans le constructeur) 
        
        if (direction.equals("UP")){
            nvlposY = this.posY-1;
            if (comparelvl(pion).equals("null") ) {
            	plateau.zone[this.posY][this.posX] = "null";
            	plateau.zone[nvlposY][pion.posX] = "null" ;
             }
           else if ( comparelvl(pion).equals(this.toString()) ) {
                plateau.zone[this.posY][this.posX] = "null" ;
                plateau.zone[nvlposY][pion.posX] = this.toString();
             }     
            else 
                    plateau.zone[this.posY][this.posX] = "null";
            }
        else if (direction.equals("DOWN")){
            nvlposY = this.posY+1;
            if (comparelvl(pion).equals("null") ) {
            	plateau.zone[this.posY][this.posX] = "null";
                plateau.zone[nvlposY][pion.posX] = "null" ;
             }
           else if ( comparelvl(pion).equals(this.toString()) ) {
                plateau.zone[this.posY][this.posX] = "null" ;
                plateau.zone[nvlposY][pion.posX] = this.toString();
              }     
            else 
                plateau.zone[this.posY][this.posX] = "null";            
        }
        else if (direction.equals("LEFT")){
            nvlposX = this.posX-1;
            if (comparelvl(pion).equals("null") ) {
            	plateau.zone[this.posY][this.posX] = "null";
                plateau.zone[pion.posY][nvlposX] = "null" ;
               }
            else if ( comparelvl(pion).equals(this.toString()) ) {
                plateau.zone[this.posY][this.posX] = "null" ;
                plateau.zone[this.posY][nvlposX] = this.toString();
               }     
             else 
                plateau.zone[this.posY][this.posX] = "null";
            }             
        else {
            nvlposX = this.posX+1;
            if (comparelvl(pion).equals("null") ) {
            	plateau.zone[this.posY][this.posX] = "null";
                plateau.zone[this.posY][nvlposX] = "null" ;
               }
            else if ( comparelvl(pion).equals(this.toString()) ) {
                plateau.zone[this.posY][this.posX] = "null" ;
                plateau.zone[pion.posY][nvlposX] = this.toString();
               }     
             else
                plateau.zone[this.posY][this.posX] = "null";
            }             
    }   
    
    public String comparelvl ( Pion piece ) { // MAJ : compare les niveaux et deux objets et retourne le tostring du vainqueur
                                                //       et "null" si les deux ont le même lvl     
    int autrelvl = piece.getlvl();
    int monlvl=this.lvl;
    
    if (monlvl == -1){
        if (autrelvl == 10)
            return this.toString();
        else 
            return piece.toString();
    }
    
    else if ((monlvl == 3) && (autrelvl == 42 )) 
            return this.toString();
   
    else if ( monlvl ==autrelvl )
        return "null";    
    else if (autrelvl < monlvl)
        return this.toString();
    else 
        return piece.toString();
    
    } 
    
}    

