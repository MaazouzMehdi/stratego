package be.ac.umons.stratego.pawn;

import be.ac.umons.stratego.board.BaseBoard;

import java.io.Serializable;

/**
 * <p>This class represents a pawn in Stratego and the differents actions done in the game</p>
 * <p>All the pawns of the stratego game extends this abstract class through PawnGeneral and PawnNoMove  </p>
 */
public abstract class Pawn implements Serializable {

	protected int lvl; 
	protected int posY;
	protected int posX;
    /**
     * the squad can be a "Friend"(player) or a "Ennemy"(Computer)
     */
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

    /**
     * <p>Determines whether the deplacement of the pawn on the board is possible to the chosen direction (and the chosen number of cell for the scout) </p>
     * @param direction represents the direction of the deplacement
     * @param plateau represents the game board
     * @param number represents the number of cells we move
     * @return Whether the chosen deplacement is possible
     */
	public boolean deplacementPossible (Direction direction, BaseBoard plateau,int number) { // vérifie qu'il n'y a pas de fleuve, dépasse pas le board et pas ami et dernière case est un ennemi

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

    /**
     * <p></p>Call only if {@link #deplacementPossible(Direction, BaseBoard, int)}  }</p>
     * <p>Move the pawn on the board to the chosen direction or {@link #attack} if  there is a ennemy</p>
     * @param direction reprensents the direction of the deplacement
     * @param plateau represents the game board
     * @param number represents the number of cells we move
     * @return whether the deplacement is done
     */
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


    /**
     * <p>Call only if the player move his pawn on a ennemy</p>
     * <p>call {@link #comparelvl(Pawn)} for knowing who win the battle </p>
     * <p>see the stratego rules for more informations about the battle between the pawns</p>
     * @param direction reprensents the direction of the deplacement
     * @param pawn represents the pawn that we attack
     * @param plateau represents the game board
     * @param number represents the number of cells we move
     */
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

    /**
     * <p>Compare the levels of the pawns to know who win the battle<p/>
     * <p>See the rules of Stratego about the attack</p>
     * @param piece
     * @return "null" if the paws have the same lvl or the toString() of the winner of the battle
     */
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

