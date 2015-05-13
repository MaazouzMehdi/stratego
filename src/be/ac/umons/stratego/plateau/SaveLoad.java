package be.ac.umons.stratego.plateau;

import be.ac.umons.stratego.pion.Cell;

import java.io.*;

/**
 * Created by marco on 13/05/15.
 */
public class SaveLoad {
    public void SaveGame() throws IOException,ClassNotFoundException {
        Cell[][] gameBoard = PlateauBase.board;
        OutputStream file = new FileOutputStream("Sauvegarde");
        ObjectOutputStream oursave = new ObjectOutputStream(file); //effectue la sérialistation
        oursave.writeObject(gameBoard);
        oursave.close();

    }

    public Cell[][] LoadGame() throws  IOException,ClassNotFoundException{
        InputStream file = new FileInputStream("Sauvegarde");
        ObjectInputStream ourload= new ObjectInputStream(file); // effectue la désérialistation
        Cell [][] gameBoard = (Cell[][])ourload.readObject();
        ourload.close();
        return gameBoard;
    }
}
