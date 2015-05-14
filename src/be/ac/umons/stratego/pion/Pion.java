package be.ac.umons.stratego.pion;


import be.ac.umons.stratego.ia.Ia_easy;
import be.ac.umons.stratego.plateau.PlateauBase;

import java.io.Serializable;

public abstract class Pion implements Serializable {

	protected int lvl; 
	protected int posY;
	protected int posX;
	protected String squad;

    public int getPosX() {
        return posX;
    }
    
    public void setPosX(int x) {
    	this.posX=x;
    }  	

    public int getPosY() {
        return posY;
    }
    
    public void setPosY(int y) {
    	this.posY=y;
    }

    public Pion( int lvl, int posY ,int posX , String equipe ){
        this.lvl=lvl;
        this.posY=posY;
        this.posX=posX;
        this.squad=equipe;
    }


        
    public int getlvl () {
        return lvl;
    }

    public String getSquad(){ return squad; }
    
	public boolean deplacementPossible (Direction direction, PlateauBase plateau,int number) { // vérifie qu'il n'y a pas de fleuve, dépasse pas le plateau et pas ami et dernière case est un ennemi

        for (int i = 1 ; i <= number ; i++) {
            int newX = posX + i * direction.x;
            int newY = posY + i * direction.y;
            if (newX < 10 && newX >= 0 && newY < 10 && newY >= 0) {
                Cell caseDeJeu = plateau.board[newY][newX]; //A CHANGE
                if (number!=i && caseDeJeu != null )
                    return false;
                else if (number==i && caseDeJeu==null)
                    return true;
                else if ( number==i && ((caseDeJeu.getThisriverpiece()!=null ) || this.squad.equals(caseDeJeu.getThispiece().getSquad())))

                    return false;
            }
            else
                return false;
        }

        return true;
    }
   
    public boolean deplacement ( Direction direction, PlateauBase plateau, int number ) {
        if (deplacementPossible(direction,plateau,number)) {
            posX += direction.x*number;
            posY += direction.y*number;
            Cell excasedejeu= plateau.board[posY-direction.y*number][posX-direction.x*number];//la position initiale avant deplacement
            Cell caseDeJeu= plateau.board [posY][posX];
            if (caseDeJeu == null) {
                plateau.board[posY][posX] = excasedejeu;
                plateau.board[posY - direction.y * number][posX - direction.x * number] = null;
            }
            else
                attaque(direction,caseDeJeu.getThispiece(),plateau , number); // cette méthode comparera le lvl,regardera si c'est un ennemi , mettra le perdant en null et fera un deplacement
            return true;
        }
        return false;
    }
    

    
    private void attaque (Direction direction , Pion pion , PlateauBase plateau , int number) { //MAJ
    // appelle une methode comparelvl et conversion pour voir qui a le lvl le plus grand ( attention cas spéciaux ) SSI c'est un ennemi qui compare les niveaux des objets et retourne le vainqueur  et AVANT regarde si friend or ennemi true( à faire dans le constructeur)

        Cell excasedejeu= plateau.board[posY-direction.y*number][posX-direction.x*number];


        if (comparelvl(pion).equals("null")) {
            plateau.board[posY][posX] = null;
            plateau.board[posY - direction.y * number][posX - direction.x * number] = null;
        }
        else if (comparelvl(pion).equals(this.toString())) {//retourne le string vainqueur
           plateau.board[posY-direction.y*number][posX-direction.x*number]=null;
           plateau.board[posY][posX] = excasedejeu;
        }
        else 
        	plateau.board[posY-direction.y*number][posX-direction.x*number]=null;
    }

    
    public String comparelvl ( Pion piece ) { // MAJ : compare les niveaux et deux objets et retourne le tostring du vainqueur
                                                //       et "null" si les deux ont le même lvl     
        int autrelvl = piece.getlvl();
        int monlvl=this.lvl;

        if ((monlvl == 1) && (autrelvl == 10))
                return this.toString();

        else if ((monlvl == 3) && (autrelvl == 42))
                return this.toString();

        else if ( monlvl == autrelvl )
            return "null";

        else if (autrelvl < monlvl)
            return this.toString();
        else
            return piece.toString();

    }
    
}

