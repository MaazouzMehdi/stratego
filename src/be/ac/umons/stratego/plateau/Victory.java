package be.ac.umons.stratego.plateau;

import  be.ac.umons.stratego.ia.Ia_easy;

import be.ac.umons.stratego.ia.Ia_easy;
import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.pion.Direction;
import be.ac.umons.stratego.pion.Pion;

import java.util.ArrayList;

/**
 * Created by marco on 11/05/15.
 */
public class Victory {

    public static boolean FlagDisponible ( String squad,PlateauBase plateau){
        if (squad.equals("Friend")){
             for (int i = 8;i<10;i++) {// regarde si le drapeau est toujours présent
                 for (int j=0;j<10;j++) {
                     Cell cell = plateau.board[i][j];
                     if (cell==null )
                         continue;
                     else {
                         if (cell.getThispiece().toString().equals("FLAG")) // on ne regarde pas l'équipe car le flag est toujours soit haut soit bas
                             return true;
                     }
                 }
             }
            return false;
        }
        else {
            for (int i = 0;i<4;i++) {// regarde si le drapeau est toujours présent
                for (int j=0;j<10;j++) {
                    Cell cell = plateau.board[i][j];
                    if (cell!=null && cell.getThispiece().toString().equals("FLAG"))
                        return true;
                }
            }
            return false;
        }
    }

    public static boolean MyPawnsCanMoves( PlateauBase plateau){

        for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                Cell cell = plateau.board[i][j];
                if ((cell==null) ||  cell.getThisriverpiece()!=null ||(cell.getThispiece().getSquad().equals("Ennemy")))
                	continue;
                if (!((cell==null) ||  cell.getThisriverpiece()!=null ||(cell.getThispiece().getSquad().equals("Ennemy"))) &&
                        (cell.getThispiece().deplacementPossible(Direction.NORTH, plateau, 1)
                                || cell.getThispiece().deplacementPossible(Direction.SOUTH, plateau, 1)
                                || cell.getThispiece().deplacementPossible(Direction.EAST, plateau, 1)
                                || cell.getThispiece().deplacementPossible(Direction.WEST, plateau, 1)))
                    return true;
            }
        }
        return false;
    }

    public static boolean ComputerPawnsCanMoves( PlateauBase plateau) {
    	for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                Cell cell = plateau.board[i][j];
                if (!((cell==null) ||  cell.getThisriverpiece()!=null ||(cell.getThispiece().getSquad().equals("Friend"))) &&
                        (cell.getThispiece().deplacementPossible(Direction.NORTH, plateau, 1)
                                || cell.getThispiece().deplacementPossible(Direction.SOUTH, plateau, 1)
                                || cell.getThispiece().deplacementPossible(Direction.EAST, plateau, 1)
                                || cell.getThispiece().deplacementPossible(Direction.WEST, plateau, 1) ))
                    return true;
                
            }
    	}
    	return false;
    }

}
