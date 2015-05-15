package be.ac.umons.stratego.ia;

import be.ac.umons.stratego.pawn.Cell;
import be.ac.umons.stratego.pawn.Direction;
import be.ac.umons.stratego.pawn.Pawn;
import be.ac.umons.stratego.board.BaseBoard;

import java.util.ArrayList;


import java.util.Random;


/**
 * this class is the artificial intelligent that move a random pawn in a random direction(if deplacement possible)
 */
public class Ia_easy {


    public static ArrayList<Pawn> pawnsDisponible = new ArrayList<>(40); // VOIR SYNTAXE
    public static ArrayList<Pawn> pawnsCanMove = new ArrayList<>(40);

    /**
     * <p>This method drives the IA for play</p>
     * <p>if the chosen pawn is a scout , do a deplacement with a random number of cells</p>
     * @param plateau represents the game board
     */
    public static void play(BaseBoard plateau) {
    	pawnsDisponible.clear();
    	pawnsCanMove.clear();
        Pawn pawn = choice(plateau);
        Random myrandomdeplacement = new Random();
        int direction = myrandomdeplacement.nextInt(4);
            if (pawn.toString().equals("SCOUT")) {

                Random mynumbercases = new Random();
                int nbrcases = mynumbercases.nextInt(5);
                if (direction == 0) {
                    if (pawn.deplacementPossible(Direction.NORTH, plateau, nbrcases)) {
                    	   pawn.deplacement(Direction.NORTH, plateau, nbrcases);
                    }
                    else
                    	play(plateau);

                } else if (direction == 2) {
                    if (pawn.deplacementPossible(Direction.SOUTH, plateau, nbrcases)) {
                    	pawn.deplacement(Direction.SOUTH, plateau, nbrcases);
                    }
                    else
                    	play(plateau);

                } else if (direction == 1) {
                    if (pawn.deplacementPossible(Direction.WEST, plateau, nbrcases)) {
                    	pawn.deplacement(Direction.WEST, plateau, nbrcases);
                    }
                    else
                    	play(plateau);

                } else {
                	
                    if (pawn.deplacementPossible(Direction.EAST, plateau, nbrcases)) {
                    	pawn.deplacement(Direction.EAST, plateau, nbrcases);
                    }
                    else
                    	play(plateau);
                }
            }
            else {

                if (direction == 0) {
                    if (pawn.deplacementPossible(Direction.NORTH, plateau,1)) {
                    	
                    	pawn.deplacement(Direction.NORTH, plateau,1);
                    
                        
                    }
                    else
                    	play(plateau);
                } else if (direction == 2) {
                	
                    if (pawn.deplacementPossible(Direction.SOUTH, plateau,1)) {
                    	
                        pawn.deplacement(Direction.SOUTH, plateau,1);
                        
                    }
                    else
                    	play(plateau);
                } else if (direction == 1) {
                	
                    if (pawn.deplacementPossible(Direction.WEST, plateau,1)) {
                    	
                        pawn.deplacement(Direction.WEST, plateau,1);
                       
                    }
                    else
                    	play(plateau);
                } else {
                    if (pawn.deplacementPossible(Direction.EAST, plateau,1)){
                    	
                    	pawn.deplacement(Direction.EAST, plateau, 1);
                    	
                        
                    }
                    else
                    	play(plateau);
                }
            }
        }

    /**
     * This method call the method generatePossibilities(plateau) for chose a random pawn in the attribute to move
     * @param plateau represents the game board
     * @return the chosen pawn
     */
    private static Pawn choice(BaseBoard plateau) { // pour le momment on fait la supposition qu'il possède toujours des pions, victory gère ca
        generatePossibilties(plateau);
        Random choicepion = new Random();
        int myindex = choicepion.nextInt(pawnsCanMove.size());
        Pawn mychoice = pawnsCanMove.get(myindex);
        return mychoice;
    }

    /**
     * This method generate a list that contains all the pawns that can move and initialize the attribute pawnsCanMove
     * @param plateau represents the game board
     */
    private static void generatePossibilties(BaseBoard plateau){

        for (int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                Cell cellpion = plateau.board[i][j];
                if (cellpion!=null && cellpion.getThisriverpiece()==null) {
                    Pawn mypawn = cellpion.getThispiece();
                    if (mypawn.getSquad().equals("Ennemy")) {
                        pawnsDisponible.add(mypawn);
                    }
                }
            }
        }
        for (Pawn pawns:pawnsDisponible) {
            if (pawns.deplacementPossible(Direction.NORTH,plateau,1)
                    ||pawns.deplacementPossible(Direction.SOUTH,plateau,1)
                    ||pawns.deplacementPossible(Direction.WEST,plateau,1)
                    ||pawns.deplacementPossible(Direction.EAST,plateau,1) )
                pawnsCanMove.add(pawns);
        }
    }
}
