package scucina;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class JeuTuto1 implements JeuAbstract {
    
    double x, y;
    int sx, sy;
    Color c = Color.RED;
    double v = 60;
    int largeur_case = 45;
    int hauteur_case = 50;
    int objectifx = 1;
    int objectify = 2;
    double rayon = 50;
    int map_x;
    int map_y;
    int direction;
    int score = 0;
    int nb_move; // = touche.size();
    int bon_move = 0;
    int mauvaise_move;
    boolean lire=true;
    boolean ok;
    int tps = 400;
    String mode;
    
    boolean sequence = false;
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
    Bouton b1;
    
    
    public JeuTuto1() {
        this.b1 = new Bouton(380, 300, 50, 70, "Passer au niveau suivant");
        this.score = 100;
        this.personnage_x = 4;
        this.personnage_y = 1;
        x = (this.personnage_x) * this.largeur_case + this.largeur_case;
        y = (this.personnage_y) * this.hauteur_case + this.hauteur_case/2;
        this.mode = "t1";
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
        this.mode = "t1";
        this.sx = souris.getX();
        this.sy = souris.getY();
        // decale le personnage en fonction des touches
        if (clavier.getTyped(KeyEvent.VK_LEFT)) {
            this.allerGauche(true, false);
        }
        
        if (clavier.getTyped(KeyEvent.VK_RIGHT)) {
            this.allerDroite(true, false);
        }
        
        if (clavier.getTyped(KeyEvent.VK_UP)) {
            this.allerHaut(true, false);
        }
        
        if (clavier.getTyped(KeyEvent.VK_DOWN)) {
            this.allerBas(true, false);
        }
        if (clavier.getTyped(KeyEvent.VK_BACK_SPACE)) {
            touche.remove(touche.size()-1);
        }
        
        if (clavier.getTyped(KeyEvent.VK_SPACE)) {
            // JOUER LA SEQUENCE !
            //System.out.println("Je lis la séquence ?");
            System.out.println(touche);
            sequence = true;
            /*
            int j = touche.size();
            for (int i = 0; i < j; i++) {
            System.out.println("Ca, c'est i ? " + i);
            System.out.println(touche);
            String get = touche.remove(0);
            switch (get) {
            case "Droite":  this.allerDroite(false, true);
            break;
            case "Gauche":  this.allerGauche(false, true);
            break;
            case "Bas":  this.allerBas(false, true);
            break;
            case "Haut":  this.allerHaut(false, true);
            break;
            default: System.out.println("NOPE");
            break;
            }
            try {
            Thread.sleep(tps);
            } catch (InterruptedException ex) {
            Logger.getLogger(JeuTuto1.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            */
            //System.out.println("j'ai lu");
        }
        if (sequence){
            if(!touche.isEmpty()){
                String get = touche.remove(0);
                switch (get) {
                    case "Droite":  this.allerDroite(false, true);
                    break;
                    case "Gauche":  this.allerGauche(false, true);
                    break;
                    case "Bas":  this.allerBas(false, true);
                    break;
                    case "Haut":  this.allerHaut(false, true);
                    break;
                    default: System.out.println("NOPE");
                    break;
                }
                try {
                    Thread.sleep(tps);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JeuTuto1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                sequence = false;
            }
        }
        
        if(ok()){
            /**
             * try {
             * Thread.sleep(tps*2);
             * } catch (InterruptedException ex) {
             * Logger.getLogger(JeuTuto1.class.getName()).log(Level.SEVERE, null, ex);
             * }
             */
            //this.mode = "t2";
            if ((sx > 380) && (sy > 430) && (sy < 525) && (sx < 600) && (souris.getClicked())) {
                // on change de mode de jeu
                System.out.println("passer au second tutoriel");
                this.mode = "t2";
            }
        }
        else{
            this.mode = "t1";
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
        //System.out.println(this.mode);
        return (this.mode);
    }
    
    public boolean ok(){
        if(this.personnage_x==this.objectifx && this.personnage_y==this.objectify){
            ok = true;
            //System.out.println("GG");
        }
        else{
            ok=false;
        }
        return ok;
    }
    
    public void allerDroite(boolean add, boolean dep){
        t = "Droite";
        //System.out.println("Droite");
        //System.out.println("mon x est de : "+ this.personnage_x);
        if (this.personnage_x-1 < 5 && this.plateau[personnage_x+1][personnage_y].isPeutMarcher() && dep ){
            //System.out.println("Droite1");
            this.x = this.x + v-10;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_x++;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.x > 314)
                this.x = 314-this.largeur_case;
            this.direction=3;
            this.moveReussi(t,dep);
            
        }
        else if (this.personnage_x-1 < 5 && this.plateau[personnage_x+1][personnage_y].isPeutMarcher() && !dep ){
            //System.out.println("Droite1");
            /*
            this.x = this.x + v-10;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_x++;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.x > 314)
            this.x = 314-this.largeur_case;
            this.direction=3;
            */
            this.moveReussi(t,dep);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            if(dep)
                this.score = score-3;
            this.direction=3;
        }
        if(add)
            this.touche.add(t);
        
        
    }
    
    public void allerHaut(boolean add, boolean dep){
        t = "Haut";
        //System.out.println("Haut");
        //System.out.println("mon y est de : "+ this.personnage_y);
        if ( this.personnage_y-1 > -1 && this.plateau[personnage_x][personnage_y-1].isPeutMarcher() && dep){
            //System.out.println("Haut1");
            this.y = this.y - v;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_y--;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.y < 0)
                this.y = 0+this.hauteur_case;
            this.direction=1;
            this.moveReussi(t,dep);
            
        }
        else if ( this.personnage_y-1 > -1 && this.plateau[personnage_x][personnage_y-1].isPeutMarcher() && !dep){
            //System.out.println("Haut1");
            /*
            this.y = this.y - v;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_y--;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.y < 0)
            this.y = 0+this.hauteur_case;
            this.direction=1;
            */
            this.moveReussi(t,dep);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            if(dep)
                this.score = score-3;
            this.direction=1;
        }
        if(add)
            this.touche.add(t);
        
        
    }
    
    public void allerBas(boolean add, boolean dep){
        t = "Bas";
        //System.out.println("Bas");
        //System.out.println("mon y est de : "+ this.personnage_y);
        if ((this.personnage_y < 5) && this.plateau[personnage_x][personnage_y+1].isPeutMarcher() && dep){
            //System.out.println("Bas1");
            this.y = this.y + v;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_y++;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.y > 300)
                this.y = 350-this.hauteur_case;
            this.direction=0;
            this.moveReussi(t,dep);
        }
        else if((this.personnage_y < 5) && this.plateau[personnage_x][personnage_y+1].isPeutMarcher() && !dep){
            //System.out.println("Bas1");
            /*
            this.y = this.y + v;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_y++;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.y > 328)
            this.y = 328-this.hauteur_case;
            this.direction=0;
            */
            this.moveReussi(t,dep);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            if(dep)
                this.score = score-3;
            this.direction=0;
        }
        
        if(add)
            this.touche.add(t);
    }
    
    public void allerGauche(boolean add, boolean dep){
        t = "Gauche";
        //System.out.println("Gauche");
        //System.out.println("mon x est de : "+ this.personnage_x);
        if ( this.personnage_x-1 > -1 && this.plateau[personnage_x-1][personnage_y].isPeutMarcher() && dep ){
            //System.out.println("Gauche1");
            this.x = this.x - v+10;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_x--;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.x < 20)
                this.x = 0+this.largeur_case;
            this.direction=2;
            this.moveReussi(t,dep);
        }
        else if ( this.personnage_x-1 > -1 && this.plateau[personnage_x-1][personnage_y].isPeutMarcher() && !dep ){
            //System.out.println("Gauche1");
            /*
            this.x = this.x - v+10;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(false);
            this.personnage_x--;
            this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
            if (this.x < 0)
            this.x = 0+this.largeur_case;
            this.direction=2;
            */
            this.moveReussi(t,dep);
        }
        else{
            System.out.println("Je ne peux pas y aller");
            if(dep)
                this.score = score-3;
            this.direction=2;
        }
        
        if(add)
            this.touche.add(t);
    }
    
    
    public void moveReussi(String s, Boolean d){
        System.out.println(s);
        if (d){
            this.print();
            System.out.println("Score : " + String.valueOf(score));
            this.bon_move++;
        }
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
