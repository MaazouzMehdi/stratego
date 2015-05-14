package be.ac.umons.stratego.ia;

import be.ac.umons.stratego.pion.Bomb;
import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.Direction;
import be.ac.umons.stratego.pion.Pion;
import be.ac.umons.stratego.plateau.PlateauBase;

/**
 * Created by marco on 13/05/15.
 */
public class Ia_Hard {

    public void play(PlateauBase plateau){

        boolean noEnnemy = true;
        while(noEnnemy)
        for (int i=9;i>=0;i--){
            for (int j=0;j<9;j++){
                if (plateau.board[i][j] != null && plateau.board[i][j].getThisriverpiece()==null ) {
                    Cell thiscell = plateau.board[i][j];
                    Pion thispawn = thiscell.getThispiece();
                    if (thispawn.getSquad().equals("Ennemy"))
                        while (foundEnnemy(thispawn,plateau)) {

                        /// on regarde le bestchoice , si un déplacement n'a pas été réalisé on

                        }


                }
            }
        }
        noEnnemy=false;
        //ici on fera un déplacement vers le bas ou droite ou gauche "dans cette ordre"

    }

    public boolean foundEnnemy(Pion pion, PlateauBase plateau) { // fais l'analyse en spirale et change ennemy en pion si il trouve un ennemi ( le + proche )
        Pion ennemy = null;
        ennemy = spiraleAnalyse(pion, plateau);
        return (ennemy!=null);

    }

    public Pion choiceAnotherPawnToMove(){ // regarde si une piece du champs d'analyse est apte à battre l'ennemi si on ne peut pas
            return new Bomb(1,1,"blabla");//j'ai mis ca pour pas qu'il m'ennuie ce batard
    }

    public Pion spiraleAnalyse(Pion pion, PlateauBase plateau){
        int posX_Init = pion.getPosX();
        int posY_Init = pion.getPosY();
        boolean notEnd = true;
        int i = 1;
        while (notEnd || i<3) { // 3 boucles
            if (analyseLigne(Direction.EAST,posX_Init,posY_Init,i,plateau) != null) // regarde pour chaque ligne de la spirale si pas ennemi ( Friend car moi )
                return analyseLigne(Direction.EAST,posX_Init,posY_Init,i,plateau);// retourne l'ennemi ou null si pas
            posX_Init += i;
            if (analyseLigne(Direction.NORTH,posX_Init,posY_Init,i,plateau) != null)
                return analyseLigne(Direction.NORTH,posX_Init,posY_Init,i,plateau);
            posY_Init += i;
            if (analyseLigne(Direction.WEST,posX_Init,posY_Init,i+1,plateau)!= null)
                return analyseLigne(Direction.WEST,posX_Init,posY_Init,i+1,plateau);
            posX_Init -= (i+1);
            if (analyseLigne(Direction.SOUTH,posX_Init,posY_Init,i+1,plateau)!= null)
                return analyseLigne(Direction.SOUTH,posX_Init,posY_Init,i+1,plateau);
            posY_Init -= (i+1);
            i++;
        }
        return null;
    }

    public Pion analyseLigne(Direction direction ,int posX_Init,int posY_Init ,int numbercells, PlateauBase plateau){
        for (int add=1;add<numbercells;add++) {
            if (plateau.board[posY_Init + add*direction.y][posX_Init + add*direction.x].getThispiece().equals("Friend"))
                return plateau.board[posY_Init][posX_Init].getThispiece();
        }
        return null;
    }

    public void analyseBestChoice(){

    }


}
