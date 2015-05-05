package be.ac.umons.stratego.ia;

import java.lang.String;
import java.util.HashMap;
import java.util.Random;

import be.ac.umons.stratego.plateau.PlateauBase;
import be.ac.umons.stratego.pion.Pion;
import static be.ac.umons.stratego.pion.Pion.*;



public class Ia_easy {

    private HashMap < Integer,Pion > piondispo = new HashMap < Integer,Pion > (40) ; // vérifier syntaxe

        public void play (PlateauBase plateau) {
        Pion pion = choice(plateau);// truc qui choisis le string pion de liste dispo
        Random myrandomdeplacement = new Random();
        int deplacement = myrandomdeplacement.nextInt(3);
        if (deplacement == 0) {
            if (pion.deplacementPossible("UP",plateau))
                pion.deplacement("UP",plateau);
            else
                play(plateau); // ainsi on est sur qu'il se deplace bien
        }else if (deplacement == 2) {
            if (pion.deplacementPossible("DOWN", plateau))
                pion.deplacement("DOWN",plateau);
            else
                play(plateau);
        }else if (deplacement == 1) {
            if (pion.deplacementPossible("LEFT", plateau))
                pion.deplacement("LEFT",plateau);
            else
                play(plateau);
        }else {
            if (pion.deplacementPossible("RIGHT", plateau))
                pion.deplacement("RIGHT",plateau);
            else
                play(plateau);

        }

    }

        public Pion choice (PlateauBase plateau) { // pour le momment on fait la supposition qu'il possède toujours des pions
            generatePossibilties(plateau); // pas très grande complexité je sais mais pas lent si ?
            Random choicepion = new Random();
            int myindex = choicepion.nextInt(piondispo.size());
            Integer intObj2 = new Integer(myindex);
            Pion mychoice = piondispo.get(intObj2);
            piondispo.clear(); // vérifier syntaxe , vide la liste car à chaque tour elle change
            return mychoice;

        }

        public void generatePossibilties(PlateauBase plateau ){
            int index = 0;
            for (int i=0;i<10;i++) {
                for (int j = 0; j < 10; j++) {
                    String ipion = plateau.zone[i][j];
                    if ( ( ipion.equals("null") == false) && (ipion.equals("FLEUVE")==false) ) {
                        Pion monpion = conversion(ipion, i, j);
                        if (monpion.getSquad().equals("Ennemy")) {
                            Integer intObj = new Integer(index);
                            piondispo.put(intObj, monpion); // vérifer syntaxe
                            index++;
                        }
                    }

                }
            }
        }
}
