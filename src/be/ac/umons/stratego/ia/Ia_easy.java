package be.ac.umons.stratego.ia;
import be.ac.umons.stratego.graphic.DrawPlateau;
import be.ac.umons.stratego.graphic.PlacementPawn;
import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.Direction;
import be.ac.umons.stratego.pion.Pion;
import be.ac.umons.stratego.plateau.PlateauBase;

import java.util.ArrayList;


import java.util.Random;



public class Ia_easy {

    private static ArrayList<Pion> piondispo = new ArrayList<>(40); // VOIR SYNTAXE



    public static void play (PlateauBase plateau) {


        Pion pion = choice(plateau);// truc qui choisis le pion de liste dispo
        Random myrandomdeplacement = new Random();
        int direction = myrandomdeplacement.nextInt(4);

            if (pion.toString().equals("SC")) {

                Random mynumbercases = new Random();
                int nbrcases = mynumbercases.nextInt(5);

                if (direction == 0) {
                    if (pion.deplacementPossible(Direction.NORTH, plateau, nbrcases))
                        pion.deplacement(Direction.NORTH, plateau, nbrcases);
                    else
                        play(plateau); // ainsi on est sur qu'il se deplace bien
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
            	System.out.println(pion.toString());

                if (direction == 0) {
                    if (pion.deplacementPossible(Direction.NORTH, plateau,1))
                        pion.deplacement(Direction.NORTH, plateau,1);
                    else
                        play(plateau); // ainsi on est sur qu'il se deplace bien
                } else if (direction == 2) {
                    if (pion.deplacementPossible(Direction.SOUTH, plateau,1))
                        pion.deplacement(Direction.SOUTH, plateau,1);
                    else
                        play(plateau);
                } else if (direction == 1) {
                    if (pion.deplacementPossible(Direction.WEST, plateau,1))
                        pion.deplacement(Direction.WEST, plateau,1);
                    else
                        play(plateau);
                } else {
                    if (pion.deplacementPossible(Direction.EAST, plateau,1))
                        pion.deplacement(Direction.EAST, plateau,1);
                    else
                        play(plateau);
                }
            }
        }

        private static Pion choice (PlateauBase plateau) { // pour le momment on fait la supposition qu'il possède toujours des pions
            generatePossibilties(plateau); // pas très grande complexité je sais mais pas lent si ?
            Random choicepion = new Random();
            int myindex = choicepion.nextInt(piondispo.size());
            Pion mychoice = piondispo.get(myindex);
            return mychoice;

        }

        private static void generatePossibilties(PlateauBase plateau ){

            for (int i=0;i<10;i++) {
                for (int j = 0; j < 10; j++) {
                    Cell cellpion = plateau.board[i][j];
                    if (cellpion!=null && cellpion.getThisriverpiece()==null) {
                        Pion monpion = cellpion.getThispiece();
                        if (monpion.getSquad().equals("Ennemy")) {
                            piondispo.add(monpion);

                        }
                    }

                }
            }
        }
        public static void main(String argv[]) {
        	PlateauBase plateau = new PlateauBase();
        	DrawPlateau plateauBaseGraphic = new DrawPlateau(plateau);
        	PlacementPawn.PlacementEnnemyPawn(plateauBaseGraphic);
        	play(plateau);
        	PlateauBase.afficherTab(plateau);
        }
}
