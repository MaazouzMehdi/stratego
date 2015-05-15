package be.ac.umons.stratego.pawn;

import be.ac.umons.stratego.board.BaseBoard;

import java.io.*;

/**
 * Created by marco on 13/05/15.
 */

/**
 * this class contains methods for save the game or load the game
 */
public class SaveLoad implements Serializable{
    /**
     * Save the board contains in BaseBoard
     * @param plateau represents the game board to save
     * @throws IOException @see ObjectOutputStream
     */
    public static void SaveGame(BaseBoard plateau) throws IOException {
        Cell[][] gameBoard = plateau.board;
        OutputStream file = new FileOutputStream("Sauvegarde");
        ObjectOutputStream oursave = new ObjectOutputStream(file); //effectue la sérialistation
        oursave.writeObject(gameBoard);
        oursave.close();

    }

    /**
     *Load the game saved by SaveGame()
     * @return the board saved
     * @throws IOException @see FileInputStream
     * @throws ClassNotFoundException @see ObjectInputStream
     */
    public static BaseBoard LoadGame() throws  IOException,ClassNotFoundException{
        InputStream file = new FileInputStream("Sauvegarde");
        ObjectInputStream ourload= new ObjectInputStream(file); // effectue la désérialistation
        Cell [][] gameBoard = (Cell[][])ourload.readObject();
        BaseBoard x = new BaseBoard();
        x.board = gameBoard;
        ourload.close();
        return x;
    }

}
