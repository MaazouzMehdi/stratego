package be.ac.umons.stratego.pion;

import be.ac.umons.stratego.pion.Cell;
import be.ac.umons.stratego.plateau.PlateauBase;

import java.io.*;

/**
 * Created by marco on 13/05/15.
 */
public class SaveLoad implements Serializable{
    public static void SaveGame(PlateauBase plateau) throws IOException,ClassNotFoundException {
        Cell[][] gameBoard = plateau.board;
        OutputStream file = new FileOutputStream("Sauvegarde");
        ObjectOutputStream oursave = new ObjectOutputStream(file); //effectue la sérialistation
        oursave.writeObject(gameBoard);
        oursave.close();

    }

    public static PlateauBase LoadGame() throws  IOException,ClassNotFoundException{
        InputStream file = new FileInputStream("Sauvegarde");
        ObjectInputStream ourload= new ObjectInputStream(file); // effectue la désérialistation
        Cell [][] gameBoard = (Cell[][])ourload.readObject();
        PlateauBase x = new PlateauBase();
        x.board = gameBoard;
        ourload.close();
        return x;
    }

}
