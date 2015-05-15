package be.ac.umons.stratego.pawn;

import java.io.Serializable;

/**
 * Created by marco on 6/05/15.
 */
public class Cell implements Serializable {

    private Pawn thispiece;
    private River thisriverpiece;

    public Cell( CellObject pioncase, int posY , int posX , String squad) {
    
        switch (pioncase) {
            case BOMB:
                thispiece = new Bomb(posY, posX, squad);
                break;
            case SCOUT:
                thispiece = new Scout( posY, posX, squad);
                break;
            case CAPTAIN:
                thispiece = new Captain( posY, posX, squad);
                break;
            case SPY:
                thispiece = new Spy(posY, posX, squad);
                break;
            case SERGEANT:
                thispiece = new Sergeant(posY, posX, squad);
                break;
            case MINER:
                thispiece = new Miner(posY, posX, squad);
                break;
            case MARECHAL:
                thispiece = new Marechal(posY, posX, squad);
                break;
            case MAJOR:
                thispiece = new Major(posY, posX, squad);
                break;
            case LIEUTENANT:
                thispiece = new Lieutenant(posY, posX, squad);
                break;
            case GENERAL:
                thispiece = new General(posY, posX, squad);
                break;
            case FLAG:
                thispiece = new Flag( posY, posX, squad);
                break;
            case COLONEL:
                thispiece = new Colonel(posY, posX, squad);
                break;
            case RIVER:
            	thisriverpiece= new River(posY,posX);
            	
        }
    }

    public Cell(CellObject river, int posY , int posX){
        thisriverpiece = new River(posY, posX);
    }

    public Pawn getThispiece() {
        return thispiece;
    }
    
    public void setThispiece(Pawn thispiece) {
    	this.thispiece=thispiece;
    }
    
    public River getThisriverpiece() {
        return thisriverpiece;
    }
    
}
