package be.ac.umons.stratego.pion;
import static be.ac.umons.stratego.pion.Pion.*;
import static be.ac.umons.stratego.pion.SpecialPion.conversion;
import static be.ac.umons.stratego.plateau.PlateauBase.*;
import be.ac.umons.stratego.plateau.PlateauBase;
import java.util.Scanner;

public class Game {

  /*  public static void main(String[] arg) {
        System.out.println(EnumExample.NORTH);
        System.out.println(EnumExample.EAST);
        System.out.println(EnumExample.SOUTH);
        System.out.println(EnumExample.WEST);
    }*/

    public static void jeu(){

            boolean tour_joueur = false;

            System.out.println("Le jeu commence !!! vive marco ce beau goss universel ");
            System.out.println("aide de jeu en console : tu devras dire les coodornnées du pion que tu veux bouger ( x et y(inverser) ) \n et le deplacement que tu veux effectuer (HAUT,BAS,GAUCHE,DROITE) ");
            System.out.println("rappel : si c'est un pion , on te demandera aussi le nombres de cases (voir règles jeu"); 
            PlateauBase po = new PlateauBase(); 
            String [][] plateau = po.zone;
            
            while (!plateau[PlateauBase.posD_Y][PlateauBase.posD_X].equals("null")) {// MAJ
                if (!tour_joueur ){
                    
                    System.out.println("Joueur 1 , à vous de jouer ! ");
                    Scanner x = new Scanner(System.in);
                    System.out.println("Entrez la position en x : ");
                    int monpionX = x.nextInt(); // nextLine() pour String 
                    Scanner y = new Scanner(System.in);
                    System.out.println("Entrez la position en y : ");
                    int monpionY = y.nextInt();
                    Scanner one = new Scanner (System.in);
                    System.out.println ("Entrez votre Déplacement : ");
                    String direction = one.nextLine();
                    String monstring = plateau [monpionY] [monpionX];
                    if (monstring.equals("SC-F")) {
                        SpecialPion monpion = conversion (monstring ,monpionY ,monpionX);
                        Scanner arg2 = new Scanner (System.in);
                        System.out.println("Nombres de cases : ");
                        int nbre = arg2.nextInt();
                        monpion.deplacement(Direction.valueOf(monstring),po,nbre);
                        afficherTab(po);
                    }
                    else {
                        Pion monpion = conversion( monstring , monpionY , monpionX );
                        monpion.deplacement(Direction.valueOf(monstring),po, 1);
                        afficherTab(po);
                    }
                    tour_joueur = true; 
                }
                else {
                    System.out.println("joueur 2 , à vous de jouer ! ( 02/12/96 jolie date )");
                    Scanner x = new Scanner(System.in);
                    System.out.println("Entrez la position en x : ");
                    int monpionX = x.nextInt(); // nextLine() pour String 
                    Scanner y = new Scanner(System.in);
                    System.out.println("Entrez la position en y : ");
                    int monpionY = y.nextInt();
                    Scanner one = new Scanner (System.in);
                    System.out.println ("Entrez votre Déplacement : ");
                    Direction direction = Direction.valueOf(one.nextLine());
                    String monstring = plateau [monpionY] [monpionX];
                    if (monstring.equals("SC-E")) {
                        SpecialPion monpion = conversion (monstring ,monpionY ,monpionX);
                        Scanner arg2 = new Scanner (System.in);
                        System.out.println("Nombres de cases : ");
                        int nbre = arg2.nextInt();
                        monpion.deplacement(direction,po,nbre);
                        afficherTab(po);                                     
                    }
                    else {
                        Pion monpion = conversion ( monstring , monpionY , monpionX );
                        monpion.deplacement(direction,po,1);
                        afficherTab(po);
                    }
                    tour_joueur = false; 
                }    
            }
    }
}