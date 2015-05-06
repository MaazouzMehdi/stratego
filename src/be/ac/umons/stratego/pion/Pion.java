package be.ac.umons.stratego.pion;


import be.ac.umons.stratego.plateau.PlateauBase;

public abstract class Pion {

	protected int lvl; 
	protected int posY;
	protected int posX;
	protected String equipe;

    public Pion( int lvl, int posY ,int posX , String equipe ){
        this.lvl=lvl;
        this.posY=posY;
        this.posX=posX;
        this.equipe=equipe;
    }

	public int getpositionX () {
	    return posX;
	}

    public int getpositionY () {
        return posY;
    }

    public void setposition ( int x , int y ) {    
        posX = x;
        posY = y;        
    }
        
    public int getlvl () {
        return lvl;
    }

    public String getSquad(){ return equipe; }
    
    public static Pion conversion ( String quase, int y , int x ) { // prends le string de la case et retourne un objet du pion correspondant


    	if (quase.equals("B-F"))
    	        return new Bomb(-42,y,x,"Friend");
    	else  if (quase.equals("C-F"))
    	        return new Captain(6,y,x,"Friend");
    	else if (quase.equals("S-F"))
    	        return new Spy(-1,y,x,"Friend");
    	else if (quase.equals("SE-F"))
    	        return new Sergeant(4,y,x,"Friend");
    	else if (quase.equals("M-F"))
    	        return new Miner(3,y,x,"Friend");
    	else if (quase.equals("MA-F"))
    	        return new Marechal(10,y,x,"friend");
    	else if (quase.equals("MJ-F"))
    	        return new Major(7,y,x,"Friend");
    	else if (quase.equals("L-F"))
    	        return new Lieutenant(5,y,x,"Friend");
    	else if (quase.equals("G-F"))
    	        return new General(9,y,x,"Friend");
    	else if (quase.equals("F-F"))
    	        return new Flag(0,y,x,"Friend");
    	else if (quase.equals("CO-F"))
    	        return new Colonel(8,y,x,"Friend");


    	else if (quase.equals("B-E"))
    	        return new Bomb(42,y,x,"Ennemy");
    	else if (quase.equals("C-E"))
    	        return new Captain(6,y,x,"Ennemy");
    	else if (quase.equals("S-E"))
    	        return new Spy(-1,y,x,"Ennemy");
    	else if (quase.equals("SE-E"))
    	        return new Sergeant(4,y,x,"Ennemy");
    	else if (quase.equals("M-E"))
    	        return new Miner(3,y,x,"Ennemy");
    	else if (quase.equals("MA-E"))
    	        return new Marechal(10,y,x,"Ennemy");
    	else if (quase.equals("MJ-E"))
    	        return new Major(7,y,x,"Ennemy");
    	else if (quase.equals("L-E"))
    	        return new Lieutenant(5,y,x,"Ennemy");
    	else if (quase.equals("G-E"))
    	        return new General(9,y,x,"Ennemy");
    	else if (quase.equals("F-E"))
    	        return new Flag(0,y,x,"Ennemy");
    	else
    	        return new Colonel(8,y,x,"Ennemy");
    	}
    
	public boolean deplacementPossible (Direction direction, PlateauBase plateau,int number) { // vérifie qu'il n'y a pas de fleuve, dépasse pas le plateau et pas ami

        for (int i = 1 ; i <= number ; i++) {
            int newX = posX + i * direction.x;
            int newY = posY + i * direction.y;
            if (newX < 10 && newX >= 0 && newY < 10 && newY >= 0) {
                String caseDeJeu = plateau.zone[newY][newX]; //A CHANGER
                int lengthCase = caseDeJeu.length();
                if (caseDeJeu.equals("FLEUVE") || equipe.charAt(0)==caseDeJeu.charAt(lengthCase-1))
                    return false;
            }
            else
                return false;
        }
        return true;
    }
   
    public boolean deplacement ( Direction direction, PlateauBase plateau, int number ) {
        if (deplacementPossible(direction,plateau,number)==true) {
            posX += direction.x*number;
            posY += direction.y*number;
            plateau.zone[posY-direction.y*number][posX-direction.x*number]="null"; //la position initiale avant deplacement
            String caseDeJeu= plateau.zone [posY][posX];
            if (caseDeJeu.equals("null"))
                plateau.zone[posY][posX]=toString();
            else
                attaque(direction,conversion(caseDeJeu,posY,posX),plateau); // cette méthode comparera le lvl,regardera si c'est un ennemi , mettra le perdant en null et fera un deplacement
            return true;
        }
        return false;
    }
    

    
    private void attaque (Direction direction , Pion pion , PlateauBase plateau) { //MAJ
    // appelle une methode comparelvl et conversion pour voir qui a le lvl le plus grand ( attention cas spéciaux ) SSI c'est un ennemi qui compare les niveaux des objets et retourne le vainqueur  et AVANT regarde si friend or ennemi true( à faire dans le constructeur)

        if (comparelvl(pion).equals("null"))
            plateau.zone[posY][posX] = "null";
        else
            plateau.zone[posY][posX] = comparelvl(pion) ; //retourne le string vainqueur
    }

    
    public String comparelvl ( Pion piece ) { // MAJ : compare les niveaux et deux objets et retourne le tostring du vainqueur
                                                //       et "null" si les deux ont le même lvl     
        int autrelvl = piece.getlvl();
        int monlvl=this.lvl;

        if (monlvl == -1){
            if (autrelvl == 10)
                return this.toString();
            else
                return piece.toString();
        }

        else if ((monlvl == 3) && (autrelvl == -42 ))
                return this.toString();

        else if ( monlvl ==autrelvl )
            return "null";
        else if (autrelvl < monlvl)
            return this.toString();
        else
            return piece.toString();

    }
    
}

