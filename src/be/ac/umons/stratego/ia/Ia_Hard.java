package be.ac.umons.stratego.ia;

import be.ac.umons.stratego.pawn.Cell;
import be.ac.umons.stratego.pawn.Direction;
import be.ac.umons.stratego.pawn.Pawn;
import be.ac.umons.stratego.plateau.BaseBoard;

/**
 * Created by marco on 13/05/15.
 */
public class Ia_Hard {

    public void play(BaseBoard plateau){

        for (int i=9;i>=0;i--){
            for (int j=0;j<9;j++){
                if (plateau.board[i][j] != null && plateau.board[i][j].getThisriverpiece()==null ) {
                    Cell thiscell = plateau.board[i][j];
                    Pawn thispawn = thiscell.getThispiece();
                    Pawn ennemy;
                    if (thispawn.getSquad().equals("Ennemy") && (ennemy=spiraleAnalyse(thispawn, plateau))!=null) {
                        analyseBestChoice(thispawn, ennemy, plateau);
                        ///si un déplacement n'a pas été réalisé, on continue
                        if (plateau.board[i][j] == null)
                            return; // arrete play car l'action executée
                    }
                }
            }
        }

        //ici on fera un déplacement aléatoire si aucun ennemi est detecter ou aucune solution n'est possible
        Ia_easy.play(plateau);
    }

    public Pawn spiraleAnalyse(Pawn pion, BaseBoard plateau){
        int posX_Init = pion.getPosX();
        int posY_Init = pion.getPosY();
         // 2 boucles de la spirale
        int i = 1;
        if (analyseLigne(Direction.EAST,posX_Init,posY_Init,i,plateau) != null) {  // regarde pour chaque ligne de la spirale si pas ennemi ( Friend car moi )
            return analyseLigne(Direction.EAST, posX_Init, posY_Init, i, plateau);// retourne l'ennemi ou null si pas
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

    public Pawn analyseLigne(Direction direction ,int posX_Init,int posY_Init ,int numbercells, BaseBoard plateau){
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

    public void analyseBestChoice(Pawn ourpawn , Pawn piontoattack, BaseBoard plateau){ // regarde le meilleur déplacement à effectuer , fais rien si aucune bonne solution
        String whatHaveToDo = ourpawn.comparelvl(piontoattack);                           // se possitionne d'abord à la même ligne(y) que le pawn ensuite regarde les colonnes (x)

        if (whatHaveToDo.equals(ourpawn.toString()) || whatHaveToDo.equals("null") ){

            if (ourpawn.getPosY() > piontoattack.getPosY() ) { // si le pawn se trouve plus haut
                if (ourpawn.deplacementPossible(Direction.NORTH, plateau, 1) ) // va dans le sens de l'ennemi pour l'attaquer à chaque tour
                    ourpawn.deplacement(Direction.NORTH, plateau, 1);

            }
            else if (ourpawn.getPosY() < piontoattack.getPosY() ) { // si le pawn se trouve plus bas
                if (ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1) )
                    ourpawn.deplacement(Direction.SOUTH, plateau, 1);
            }
            else if (ourpawn.getPosX() < piontoattack.getPosX() ) { //si le pawn se trouve à droite
                if (ourpawn.deplacementPossible(Direction.EAST,plateau,1) )
                    ourpawn.deplacement(Direction.EAST,plateau,1);
            }
            else if (ourpawn.getPosX() > piontoattack.getPosX() ) { // si le pawn se trouve à gauche
                if (ourpawn.deplacementPossible(Direction.WEST,plateau,1) )
                    ourpawn.deplacement(Direction.WEST,plateau,1);
            }
        }
        else {
            if (ourpawn.getPosY() > piontoattack.getPosY() ) { // si le pawn se trouve plus haut
                if (ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1) ) // va dans le sens opposé ou s'éloigne dans d'autres directions si possible (dans cet ordre)
                    ourpawn.deplacement(Direction.SOUTH, plateau, 1);
                else if (ourpawn.deplacementPossible(Direction.EAST, plateau, 1) )
                    ourpawn.deplacement(Direction.EAST, plateau, 1);
                else if (ourpawn.deplacementPossible(Direction.WEST, plateau, 1) )
                    ourpawn.deplacementPossible(Direction.WEST, plateau, 1);
            }
            else if (ourpawn.getPosY() < piontoattack.getPosY() ) { // si le pawn se trouve plus bas
                if (ourpawn.deplacementPossible(Direction.NORTH, plateau, 1) )
                    ourpawn.deplacement(Direction.NORTH, plateau, 1);
                else if (ourpawn.deplacementPossible(Direction.EAST, plateau, 1) )
                    ourpawn.deplacement(Direction.EAST,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.WEST, plateau, 1) )
                    ourpawn.deplacementPossible(Direction.WEST, plateau, 1);
            }
            else if (ourpawn.getPosX() < piontoattack.getPosX() ) { //si le pawn se trouve à droite
                if (ourpawn.deplacementPossible(Direction.WEST,plateau,1) )
                    ourpawn.deplacement(Direction.WEST,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.NORTH, plateau, 1) )
                    ourpawn.deplacement(Direction.NORTH,plateau,1);
                else if (ourpawn.deplacementPossible(Direction.SOUTH, plateau, 1) )
                    ourpawn.deplacementPossible(Direction.NORTH, plateau, 1);
            }
            else if (ourpawn.getPosX() > piontoattack.getPosX() ) { // si le pawn se trouve à gauche
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
