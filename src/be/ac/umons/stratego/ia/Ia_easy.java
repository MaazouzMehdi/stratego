package be.ac.umons.stratego.ia;

import be.ac.umons.stratego.pion.Pion;
import be.ac.umons.stratego.plateau.PlateauBase;

import java.lang.String;
import java.util.ArrayList;


import java.util.Random;

import static be.ac.umons.stratego.pion.Pion.conversion;


public class Ia_easy {

    private ArrayList<Pion> piondispo ;

        public void play (PlateauBase plateau) {



            Pion pion = choice(plateau);// truc qui choisis le string pion de liste dispo
            Random myrandomdeplacement = new Random();
            int deplacement = myrandomdeplacement.nextInt(3);

            if (pion.toString().equals("Sc-E")) {

                Random mynumbercases = new Random();
                int nbrcases = mynumbercases.nextInt(5);

                /*if (deplacement == 0) {
                    if (pion.deplacementPossible("UP", plateau, nbrcases))
                        pion.deplacement("UP", plateau, nbrcases);
                    else
                        play(plateau); // ainsi on est sur qu'il se deplace bien
                } else if (deplacement == 2) {
                    if (pion.deplacementPossible("DOWN", plateau, nbrcases))
                        pion.deplacement("DOWN", plateau, nbrcases);
                    else
                        play(plateau);
                } else if (deplacement == 1) {
                    if (pion.deplacementPossible("LEFT", plateau, nbrcases))
                        pion.deplacement("LEFT", plateau, nbrcases);
                    else
                        play(plateau);
                } else {
                    if (pion.deplacementPossible("RIGHT", plateau, nbrcases))
                        pion.deplacement("RIGHT", plateau, nbrcases);
                    else
                        play(plateau);
                }
                } else if (deplacement == 0) {
                    if (pion.deplacementPossible("UP", plateau))
                        pion.deplacement("UP", plateau);
                    else
                        play(plateau); // ainsi on est sur qu'il se deplace bien
                } else if (deplacement == 2) {
                    if (pion.deplacementPossible("DOWN", plateau))
                        pion.deplacement("DOWN", plateau);
                    else
                        play(plateau);
                } else if (deplacement == 1) {
                    if (pion.deplacementPossible("LEFT", plateau))
                        pion.deplacement("LEFT", plateau);
                    else
                        play(plateau);
                } else {
                    if (pion.deplacementPossible("RIGHT", plateau))
                        pion.deplacement("RIGHT", plateau);
                    else
                        play(plateau);
            }*/
            }
        }

        public Pion choice (PlateauBase plateau) { // pour le momment on fait la supposition qu'il possède toujours des pions
            generatePossibilties(plateau); // pas très grande complexité je sais mais pas lent si ?
            Random choicepion = new Random();
            int myindex = choicepion.nextInt(piondispo.size());
            Pion mychoice = piondispo.get(myindex);
            return mychoice;

        }

        public void generatePossibilties(PlateauBase plateau ){

            for (int i=0;i<10;i++) {
                for (int j = 0; j < 10; j++) {
                    String ipion = plateau.zone[i][j];
                    if (!ipion.equals("null") && !ipion.equals("FLEUVE")) {
                        Pion monpion = conversion(ipion, i, j);
                        if (monpion.getSquad().equals("Ennemy")) {
                            piondispo.add(monpion);

                        }
                    }

                }
            }
        }
}
