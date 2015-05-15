package be.ac.umons.stratego.ia;

import be.ac.umons.stratego.pawn.Cell;
import be.ac.umons.stratego.pawn.Direction;
import be.ac.umons.stratego.pawn.Pawn;
import be.ac.umons.stratego.board.BaseBoard;

/**
 * Created by marco on 13/05/15.
 */

/**
 * this class is a artificial intelligent that analyse the best move to do and see the ennemy pion next his pawn
 */
public class Ia_Hard {
    /**
     * <p>This method drives the IA for play</p>
     * <p>this method determines for the most farthest pawn what is the best choice to do  </p>
     * <p>if the pawn can't move , the method choice the next pawn most farthest</p>
     * <p>otherwise , do a random move </p>
     * @param plateau represents the game board
     */
    public static void play(BaseBoard plateau){

        for (int i=9;i>=0;i--){
            for (int j=0;j<9;j++){
                if (plateau.board[i][j] != null && plateau.board[i][j].getThisriverpiece()==null ) {
                    Cell thiscell = plateau.board[i][j];
                    Pawn thispawn = thiscell.getThispiece();
                    Pawn ennemy;
                    if (thispawn.getSquad().equals("Ennemy") && (ennemy=spiraleAnalyse(thispawn, plateau))!=null) {
                        analyseBestChoice(thispawn, ennemy, plateau);
                        if (plateau.board[i][j] == null)
                            return; // because action executed
                    }
                }
            }
        }
        //Here we do a random deplacement through the Ia_easy if no one ennemy is detected near all the pawns or there isn't no intelligent possibilities of deplacement
        Ia_easy.play(plateau);
    }

    /**
     * this method analyse in spiral the most closed ennemy pawn ( call analyseLigne() ) of my pawn
     * @param pion
     * @param plateau
     * @return the most closed pawn or otherwise null
     */
    public static Pawn spiraleAnalyse(Pawn pion, BaseBoard plateau){
        int posX_Init = pion.getPosX();
        int posY_Init = pion.getPosY();
        int i = 1;

        if (analyseLigne(Direction.EAST,posX_Init,posY_Init,i,plateau) != null) {
            return analyseLigne(Direction.EAST, posX_Init, posY_Init, i, plateau);
        }
        posX_Init += 1;

        if (analyseLigne(Direction.NORTH,posX_Init,posY_Init,i,plateau) != null) {
            return analyseLigne(Direction.NORTH, posX_Init, posY_Init, i, plateau);
        }
        posY_Init += 1;
        i++;

        if (analyseLigne(Direction.WEST,posX_Init,posY_Init,i+1,plateau)!= null) {
            return analyseLigne(Direction.WEST, posX_Init, posY_Init, i + 1, plateau);
        }
        posX_Init -= 2;

        if (analyseLigne(Direction.SOUTH,posX_Init,posY_Init,i+1,plateau)!= null) {
            return analyseLigne(Direction.SOUTH, posX_Init, posY_Init, i + 1, plateau);
        }
        posY_Init -= 2;
        i++;

        if (analyseLigne(Direction.EAST,posX_Init,posY_Init,i,plateau) != null) {
            return analyseLigne(Direction.EAST, posX_Init, posY_Init, i, plateau);
        }
        posX_Init += 3;

        if (analyseLigne(Direction.NORTH,posX_Init,posY_Init,i,plateau) != null) {
            return analyseLigne(Direction.NORTH, posX_Init, posY_Init, i, plateau);
        }
        posY_Init += 3;
        i++;

        if (analyseLigne(Direction.WEST,posX_Init,posY_Init,i+1,plateau)!= null) {
            return analyseLigne(Direction.WEST, posX_Init, posY_Init, i + 1, plateau);
        }
        posX_Init -= 4;

        if (analyseLigne(Direction.SOUTH,posX_Init,posY_Init,i+1,plateau)!= null) {
            return analyseLigne(Direction.SOUTH, posX_Init, posY_Init, i + 1, plateau);
        }
        posY_Init -= 4;

        if (analyseLigne(Direction.EAST,posX_Init,posY_Init,i,plateau) != null) {
            return analyseLigne(Direction.EAST, posX_Init, posY_Init, i, plateau);
        }
        return null;
    }

    /**
     * this method determines the most closed pawn in the line of the chosen direction,
     * the length of the line depends on numbercells
     * @param direction represents the direction of the move
     * @param posX_Init represents the initial x position of the pawn
     * @param posY_Init represents the initial y posiiton of the pawn
     * @param numbercells represents the numbers of cells to analyse in the line
     * @param plateau represents the game board
     * @return the most closed pawn or otherwise null
     */
    public static Pawn analyseLigne(Direction direction ,int posX_Init,int posY_Init ,int numbercells, BaseBoard plateau){
        for (int add=1;add<=numbercells;add++) {
            int y = posY_Init + add*direction.y;
            int x = posX_Init + add*direction.x;
            Cell c;
            Pawn p;
            if (x>=0 && x<10 && y>=0 && y<10 &&
                    (c=plateau.board[y][x])!=null &&
                    (p = c.getThispiece())!=null && p.equals("Friend"))
                return plateau.board[posY_Init][posX_Init].getThispiece();
        }
        return null;
    }

    /**
     * this method attack the piontoattack (or go in his direction) if we beat him ,
     * or move to the opposed direction if he beat our
     * otherwise the method can't move dans do nothing
     * @param ourpawn represents our pawn
     * @param piontoattack represents the most closed pion
     * @param plateau represents the game board
     */
    public static void analyseBestChoice(Pawn ourpawn , Pawn piontoattack, BaseBoard plateau){
        String whatHaveToDo = ourpawn.comparelvl(piontoattack);
        // our position move first to the same line(y) and then to the same colon (x)

        if (whatHaveToDo.equals(ourpawn.toString()) || whatHaveToDo.equals("null") ){

            if (ourpawn.getPosY() > piontoattack.getPosY() ) { // if the ennemy pawn is up
                if (ourpawn.deplacementPossible(Direction.NORTH, plateau, 1) )
                    ourpawn.deplacement(Direction.NORTH, plateau, 1);

            }
            else if (ourpawn.getPosY() < piontoattack.getPosY() ) { // if the ennemy pawn is down
                if (ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1) )
                    ourpawn.deplacement(Direction.SOUTH, plateau, 1);
            }
            else if (ourpawn.getPosX() < piontoattack.getPosX() ) { //if the ennemy pawn is on the right
                if (ourpawn.deplacementPossible(Direction.EAST,plateau,1) )
                    ourpawn.deplacement(Direction.EAST,plateau,1);
            }
            else if (ourpawn.getPosX() > piontoattack.getPosX() ) { // if the ennemy pawn is on the left
                if (ourpawn.deplacementPossible(Direction.WEST,plateau,1) )
                    ourpawn.deplacement(Direction.WEST,plateau,1);
            }
        }
        else {
            if (ourpawn.getPosY() > piontoattack.getPosY() ) {
                if (ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1) )
                    ourpawn.deplacement(Direction.SOUTH, plateau, 1);
                else if (ourpawn.deplacementPossible(Direction.EAST, plateau, 1) )
                    ourpawn.deplacement(Direction.EAST, plateau, 1);
                else if (ourpawn.deplacementPossible(Direction.WEST, plateau, 1) )
                    ourpawn.deplacementPossible(Direction.WEST, plateau, 1);
            }
            else if (ourpawn.getPosY() < piontoattack.getPosY() ) {
                if (ourpawn.deplacementPossible(Direction.NORTH, plateau, 1) )
                    ourpawn.deplacement(Direction.NORTH, plateau, 1);
                else if (ourpawn.deplacementPossible(Direction.EAST, plateau, 1) )
                    ourpawn.deplacement(Direction.EAST,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.WEST, plateau, 1) )
                    ourpawn.deplacementPossible(Direction.WEST, plateau, 1);
            }
            else if (ourpawn.getPosX() < piontoattack.getPosX() ) {
                if (ourpawn.deplacementPossible(Direction.WEST,plateau,1) )
                    ourpawn.deplacement(Direction.WEST,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.NORTH, plateau, 1) )
                    ourpawn.deplacement(Direction.NORTH,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1) )
                    ourpawn.deplacementPossible(Direction.NORTH, plateau, 1);
            }
            else if (ourpawn.getPosX() > piontoattack.getPosX() ) {
                if (ourpawn.deplacementPossible(Direction.EAST,plateau,1) )
                    ourpawn.deplacement(Direction.EAST,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.NORTH, plateau, 1) )
                    ourpawn.deplacement(Direction.NORTH,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1) )
                    ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1);
            }
        }
    }
}
