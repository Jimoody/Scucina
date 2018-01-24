package scucina;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class JeuPersonnage implements JeuAbstract {
    
    double x, y;
    double v = 60;
    int largeur_case = 45;
    int hauteur_case = 50;
    double objectifx = 500;
    double objectify = 300;
    double rayon = 50;
    String mode="debut";
    int map_x;
    int map_y;
    int direction;
    int score = 0;
    int nb_move; // = touche.size();
    int bon_move = 0;
    int mauvaise_move;
    boolean lire=true;
    /*
    0 = face
    1 = dos
    2 = gauche
    3 = droite
    */
    
    Cases[][] plateau ;
    Cases[][] portes;
    int personnage_x;
    int personnage_y;
    ArrayList<String> touche = new ArrayList<String>();
    String t = "";
    
    
    public JeuPersonnage() {
        this.personnage_x = 4;
        this.personnage_y = 1;
        x = (this.personnage_x) * this.largeur_case + this.largeur_case;
        y = (this.personnage_y) * this.hauteur_case + this.hauteur_case/2;
        
        this.mode = "debut";
        this.plateau = new Cases[6][6];
        this.portes = new Cases[1][2];
        // plateau[x][y]
        // x = colonne
        // y = ligne
        this.plateau[0][0] = new Cases(false,"");
        this.plateau[1][0] = new Cases(false,"");
        this.plateau[2][0] = new Cases(false,"");
        this.plateau[3][0] = new Cases(false,"");
        this.plateau[4][0] = new Cases(false,"");
        this.plateau[5][0] = new Cases(false,"");
        this.plateau[0][1] = new Cases(false,"");
        this.plateau[1][1] = new Cases(true,"");
        this.plateau[2][1] = new Cases(false,"");
        this.plateau[3][1] = new Cases(false,"");
        this.plateau[4][1] = new Cases(true,"");
        this.plateau[5][1] = new Cases(false,"");
        this.plateau[0][2] = new Cases(false,"");
        this.plateau[1][2] = new Cases(true,"");
        this.plateau[2][2] = new Cases(false,"");
        this.plateau[3][2] = new Cases(false,"");
        this.plateau[4][2] = new Cases(true,"");
        this.plateau[5][2] = new Cases(false,"");
        this.plateau[0][3] = new Cases(false,"");
        this.plateau[1][3] = new Cases(true,"");
        this.plateau[2][3] = new Cases(false,"");
        this.plateau[3][3] = new Cases(false,"");
        this.plateau[4][3] = new Cases(true,"");
        this.plateau[5][3] = new Cases(false,"");
        this.plateau[0][4] = new Cases(true,"");
        this.plateau[1][4] = new Cases(true,"");
        this.plateau[2][4] = new Cases(true,"");
        this.plateau[3][4] = new Cases(true,"");
        this.plateau[4][4] = new Cases(true,"");
        this.plateau[5][4] = new Cases(false,"");
        this.plateau[0][5] = new Cases(true,"");
        this.plateau[1][5] = new Cases(false,"");
        this.plateau[2][5] = new Cases(false,"");
        this.plateau[3][5] = new Cases(false,"");
        this.plateau[4][5] = new Cases(true,"");
        this.plateau[5][5] = new Cases(false,"");
        // On donne les 2 cases de chaque côté de la porte.
        // On supprime la porte pour des raisons de game design
        //this.portes[0][0]=this.plateau[3][4];
        //this.portes[0][0].setPorte(true);
        //this.portes[0][1]=this.plateau[4][4];
        //this.portes[0][1].setPorte(true);
        this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
        //print();
        //this.map_x = 200;
        //this.map_y = 150;
        this.map_x = 0;
        this.map_y = 0;
        this.direction = 0;
        this.perso();
        
    }
    
    public void perso(){
        System.out.println("Colonne : "+ (this.personnage_x+1)+" \nLigne : " + (this.personnage_y+1)+"\n");
    }
    
    @Override
    public String evoluer(CClavier clavier, CSouris souris) {
        this.mode="PJ";
        
        // decale le personnage en fonction des touches
        if (clavier.getTyped(KeyEvent.VK_LEFT)) {
            this.allerGauche(true);
        }
        
        if (clavier.getTyped(KeyEvent.VK_RIGHT)) {
            this.allerDroite(true);
        }
        
        if (clavier.getTyped(KeyEvent.VK_UP)) {
            this.allerHaut(true);
        }
        
        if (clavier.getTyped(KeyEvent.VK_DOWN)) {
            this.allerBas(true);
        }
        if (clavier.getTyped(KeyEvent.VK_BACK_SPACE)) {
            // JOUER LA SEQUENCE !
            if (lire) {
                System.out.println("Je lis la séquence ?");
                System.out.println(touche);
                for (int i = 0; i < touche.size(); i++) {
                    System.out.println("Ca, c'est i ? " + i);
                    String get = touche.get(i);
                    switch (get) {
                        case "Droite":  this.allerDroite(false);
                        break;
                        case "Gauche":  this.allerGauche(false);
                        break;
                        case "Bas":  this.allerBas(false);
                        break;
                        case "Haut":  this.allerHaut(false);
                        break;
                        default: System.out.println("NOPE");
                        break;
                    }
                }
                System.out.println("j'ai lu");
                lire = false;
            }
        }
        
        // si on arrive � la fin
        /*
        double dx = this.x - this.objectifx;
        double dy = this.y - this.objectify;
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance < 50) {
        this.x = 100;
        this.y = 100;
        return ("fin");
        }
        */
        return ("PJ");
    }
    
    public void allerDroite(boolean add){
        t = "Droite";
        //System.out.println("Droite");
        //System.out.println("mon x est de : "+ this.personnage_x);
        if (this.personnage_x-1 < 5 && this.plateau[personnage_x+1][personnage_y].isPeutMarcher()  ){
            //System.out.println("Droite1");
            this.x = this.x + v-10;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_x++;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.x > 314)
                this.x = 314-this.largeur_case;
            this.direction=3;
            this.moveReussi(t);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            this.score = score-3;
        }
        if(add)
        this.touche.add(t);
    }
    
    public void allerHaut(boolean add){
        t = "Haut";
        //System.out.println("Haut");
        //System.out.println("mon y est de : "+ this.personnage_y);
        if ( this.personnage_y-1 > -1 && this.plateau[personnage_x][personnage_y-1].isPeutMarcher()){
            //System.out.println("Haut1");
            this.y = this.y - v;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_y--;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.y < 0)
                this.y = 0+this.hauteur_case;
            this.direction=1;
            this.moveReussi(t);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            this.score = score-3;
        }
        if(add)
        this.touche.add(t);
    }
    
    public void allerBas(boolean add){
        t = "Bas";
        //System.out.println("Bas");
        //System.out.println("mon y est de : "+ this.personnage_y);
        if ((this.personnage_y < 5) && this.plateau[personnage_x][personnage_y+1].isPeutMarcher()){
            //System.out.println("Bas1");
            this.y = this.y + v;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_y++;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.y > 328)
                this.y = 328-this.hauteur_case;
            this.direction=0;
            this.moveReussi(t);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            this.score = score-3;
        }
        if(add)
        this.touche.add(t);
    }
    
    public void allerGauche(boolean add){
        t = "Gauche";
        //System.out.println("Gauche");
        //System.out.println("mon x est de : "+ this.personnage_x);
        if ( this.personnage_x-1 > -1 && this.plateau[personnage_x-1][personnage_y].isPeutMarcher() ){
            //System.out.println("Gauche1");
            this.x = this.x - v+10;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_x--;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.x < 0)
                this.x = 0+this.largeur_case;
            this.direction=2;
            this.moveReussi(t);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            this.score = score-3;
        }
        if(add)
        this.touche.add(t);
    }
    
    public void moveReussi(String s){
        System.out.println(s);
        this.print();
        this.score = score+10;
        this.bon_move++;
    }
    
    public void print() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(plateau[j][i] + " | ");
            }
            System.out.println("");
        }
    }
    
    public int getPersonnage_x() {
        return personnage_x;
    }
    
    public void setPersonnage_x(int personnage_x) {
        this.personnage_x = personnage_x;
    }
    
    public int getPersonnage_y() {
        return personnage_y;
    }
    
    public void setPersonnage_y(int personnage_y) {
        this.personnage_y = personnage_y;
    }
    
    
    public Cases[][] getPlateau() {
        return plateau;
    }
    
    public void setPlateau(Cases[][] plateau) {
        this.plateau = plateau;
    }
    
    public Cases[][] getPortes() {
        return portes;
    }
    
    public void setPortes(Cases[][] portes) {
        this.portes = portes;
    }
    
    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    @Override
    public boolean etreFini() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
