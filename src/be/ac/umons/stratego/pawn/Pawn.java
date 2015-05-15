package be.ac.umons.stratego.pawn;

import be.ac.umons.stratego.plateau.BaseBoard;

import java.io.Serializable;

public abstract class Pawn implements Serializable {

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

    public Pawn( int lvl, int posY ,int posX , String squad ){
        this.lvl=lvl;
        this.posY=posY;
        this.posX=posX;
        this.squad=squad;
    }


        
    public int getlvl () {
        return lvl;
    }

    public String getSquad(){ return squad; }
    
	public boolean deplacementPossible (Direction direction, BaseBoard plateau,int number) { // vérifie qu'il n'y a pas de fleuve, dépasse pas le plateau et pas ami et dernière case est un ennemi

        for (int i = 1 ; i <= number ; i++) {
            int newX = posX + i * direction.x;
            int newY = posY + i * direction.y;
            if (newX < 10 && newX >= 0 && newY < 10 && newY >= 0) {
                Cell thisCell = plateau.board[newY][newX]; //A CHANGE
                if (number!=i && thisCell != null )
                    return false;
                else if (number==i && thisCell==null)
                    return true;
                else if ( number==i && ((thisCell.getThisriverpiece()!=null ) || this.squad.equals(thisCell.getThispiece().getSquad())))

                    return false;
            }
            else
                return false;
        }

        return true;
    }
   
    public boolean deplacement ( Direction direction, BaseBoard plateau, int number ) {
        if (deplacementPossible(direction,plateau,number)) {
            posX += direction.x*number;
            posY += direction.y*number;
            Cell exCell= plateau.board[posY-direction.y*number][posX-direction.x*number];//la position initiale avant deplacement
            Cell thisCell= plateau.board [posY][posX];
            if (thisCell == null) {
                plateau.board[posY][posX] = exCell;
                plateau.board[posY - direction.y * number][posX - direction.x * number] = null;
            }
            else
                attack(direction, thisCell.getThispiece(), plateau, number); // cette méthode comparera le lvl,regardera si c'est un ennemi , mettra le perdant en null et fera un deplacement
            return true;
        }
        return false;
    }
    

    
    private void attack (Direction direction , Pawn pawn , BaseBoard plateau , int number) { //MAJ
    // appelle une methode comparelvl et conversion pour voir qui a le lvl le plus grand et prends sa place , meurt , ou match nul

        Cell exCell= plateau.board[posY-direction.y*number][posX-direction.x*number];


        if (comparelvl(pawn).equals("null")) {
            plateau.board[posY][posX] = null;
            plateau.board[posY - direction.y * number][posX - direction.x * number] = null;
        }
        else if (comparelvl(pawn).equals(this.toString())) {//retourne le string vainqueur
           plateau.board[posY-direction.y*number][posX-direction.x*number]=null;
           plateau.board[posY][posX] = exCell;
        }
        else 
        	plateau.board[posY-direction.y*number][posX-direction.x*number]=null;
    }

    
    public String comparelvl ( Pawn piece ) { // MAJ : compare les niveaux et deux objets et retourne le tostring du vainqueur
                                                //       et "null" si les deux ont le même lvl     
        int otherLvl = piece.getlvl();
        int myLvl=this.lvl;

        if ((myLvl == 1) && (otherLvl == 10))
                return this.toString();

        else if ((myLvl == 3) && (otherLvl == 42))
                return this.toString();

        else if ( myLvl == otherLvl )
            return "null";

        else if (otherLvl < myLvl)
            return this.toString();
        else
            return piece.toString();

    }
    
}

