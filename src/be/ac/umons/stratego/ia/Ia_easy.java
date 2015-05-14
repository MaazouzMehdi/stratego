package be.ac.umons.stratego.ia;

import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.Direction;
import be.ac.umons.stratego.pion.Pion;
import be.ac.umons.stratego.plateau.PlateauBase;

import java.util.ArrayList;


import java.util.Random;



public class Ia_easy {

    public static ArrayList<Pion> pawnsDisponible = new ArrayList<>(40); // VOIR SYNTAXE
    public static ArrayList<Pion> pawnsCanMove = new ArrayList<>(40);


    public static void play(PlateauBase plateau) {
    	pawnsDisponible.clear();
    	pawnsCanMove.clear();
        Pion pion = choice(plateau);// truc qui choisis le pion de liste dispo
        Random myrandomdeplacement = new Random();
        int direction = myrandomdeplacement.nextInt(4);
        System.out.println(pion.toString());
        System.out.println(pion.getPosY());
        System.out.println(pion.getPosX());
            if (pion.toString().equals("SCOUT")) {

                Random mynumbercases = new Random();
                int nbrcases = mynumbercases.nextInt(5);
                if (direction == 0) {
                	
                    if (pion.deplacementPossible(Direction.NORTH, plateau, nbrcases))
                        pion.deplacement(Direction.NORTH, plateau, nbrcases);
                    else
                    	play(plateau);
                } else if (direction == 2) {
                	
                    if (pion.deplacementPossible(Direction.SOUTH, plateau, nbrcases))
                        pion.deplacement(Direction.SOUTH, plateau, nbrcases);
                    else
                    	play(plateau);
                } else if (direction == 1) {
                	
                    if (pion.deplacementPossible(Direction.WEST, plateau, nbrcases))
                        pion.deplacement(Direction.WEST, plateau, nbrcases);
                    else
                    	play(plateau);
                } else {
                	
                    if (pion.deplacementPossible(Direction.EAST, plateau, nbrcases))
                        pion.deplacement(Direction.EAST, plateau, nbrcases);
                    else
                    	play(plateau);
                }
            }
            else {

                if (direction == 0) {
                	System.out.println("test au nord");
                    if (pion.deplacementPossible(Direction.NORTH, plateau,1))
                        pion.deplacement(Direction.NORTH, plateau,1);
                    else
                    	play(plateau);
                } else if (direction == 2) {
                	System.out.println("test au sud");
                    if (pion.deplacementPossible(Direction.SOUTH, plateau,1))
                        pion.deplacement(Direction.SOUTH, plateau,1);
                    else
                    	play(plateau);
                } else if (direction == 1) {
                	System.out.println("test au ouest");
                    if (pion.deplacementPossible(Direction.WEST, plateau,1))
                        pion.deplacement(Direction.WEST, plateau,1);
                    else
                    	play(plateau);
                } else {
                	System.out.println("test a est");
                    if (pion.deplacementPossible(Direction.EAST, plateau,1))
                        pion.deplacement(Direction.EAST, plateau,1);
                    else
                    	play(plateau);
                }
            }
        }

        private static Pion choice(PlateauBase plateau) { // pour le momment on fait la supposition qu'il possède toujours des pions, victory gère ca
            generatePossibilties(plateau);
            Random choicepion = new Random();
            int myindex = choicepion.nextInt(pawnsCanMove.size());
            Pion mychoice = pawnsCanMove.get(myindex);
            //for( int i=0; i< pawnsCanMove.size();i++)
            	//System.out.println(pawnsCanMove.get(i).toString());
            return mychoice;

        }

        private static void generatePossibilties(PlateauBase plateau){

            for (int i=0;i<10;i++) {
                for (int j = 0; j < 10; j++) {
                    Cell cellpion = plateau.board[i][j];
                    if (cellpion!=null && cellpion.getThisriverpiece()==null) {
                        Pion monpion = cellpion.getThispiece();
                        if (monpion.getSquad().equals("Ennemy")) {
                            pawnsDisponible.add(monpion);
                        }
                    }
                }
            }
            for (Pion pawns:pawnsDisponible) {
                if (pawns.deplacementPossible(Direction.NORTH,plateau,1)
                        ||pawns.deplacementPossible(Direction.SOUTH,plateau,1)
                        ||pawns.deplacementPossible(Direction.WEST,plateau,1)
                        ||pawns.deplacementPossible(Direction.EAST,plateau,1) )
                    pawnsCanMove.add(pawns);
            }
        }
}
