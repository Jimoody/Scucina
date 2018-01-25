package scucina;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;

public class DessinTuto1 implements DessinAbstract {
    
    JeuTuto1 jeu;
    
    int score;
    public DessinTuto1(JeuTuto1 j) {
        this.jeu = j;
        
        // charger sprites
//        Sprites.chargerImage("map-tuto1", "img/map_tuto1.png");
//        Sprites.chargerImage("personnage", "img/perso.png");
//        Sprites.chargerFeuille("perso", "img/trainer.png",3, 4);
//        Sprites.chargerFeuille("arrow", "img/arrows.png", 12, 8);
    }
    
    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g=(Graphics2D)image.getGraphics();
        Bouton b1 = this.jeu.b1;
        this.score = this.jeu.score;
        int x=(int)this.jeu.x;
        int y=(int)this.jeu.y;
        int map_x = this.jeu.map_x;
        int map_y = this.jeu.map_x;
        ArrayList<String> touche = this.jeu.touche;
        
        g.setColor(Color.BLACK);
        g.drawString("Score : " + String.valueOf(this.score)+"\n\n Appuyez sur la touche ESPACE pour confirmer votre séquence"
                + "\n\n OBJECTIF : \nRendez vous sur la case bleue", 320, 20);
        
        Sprites.dessiner(g, "map-tuto1", map_x , map_y);
        String chaine="";
        if (this.jeu.direction==0) // haut
            chaine="perso_1_0";
        if (this.jeu.direction==1) // bas
            chaine="perso_1_3";
        if (this.jeu.direction==2) // gauche
            chaine="perso_1_1";
        if (this.jeu.direction==3) // droite
            chaine="perso_1_2";
        
        Sprites.dessinerCentre(g, chaine, x, y);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("helvetica", Font.PLAIN, 20));
        if(this.jeu.ok())
        g.drawString(b1.txt, b1.txtx, b1.txty);
        
        int img_x = 30;
        int img_y = 350;
        int a = 0;
        boolean ligne = true;
        boolean ligne1 = true;
        boolean ligne2 = true;
        if(!touche.isEmpty()){
            for (int i = 0; i < touche.size(); i++) {
                String get = touche.get(i);
                if(i>7 && i <= 15 && ligne){
                    a = 8;
                    img_y = img_y + 50;
                    img_x = 30;
                    ligne = false;
                }
                else if (i>15 && i <= 23 && ligne1){
                    a=16;
                    img_y = img_y + 50;
                    img_x = 30;
                    ligne1 = false;
                }
                else if (i>23 && ligne2){
                    a=24;
                    img_y = img_y + 50;
                    img_x = 30;
                    ligne2 = false;
                }
                switch (get) {
                    case "Droite":  Sprites.dessinerCentre(g, "arrow_10_2", img_x+((i-a)*50), img_y);
                    break;
                    case "Gauche":  Sprites.dessinerCentre(g, "arrow_10_1", img_x+((i-a)*50), img_y);
                    break;
                    case "Bas":  Sprites.dessinerCentre(g, "arrow_10_0", img_x+((i-a)*50), img_y);
                    break;
                    case "Haut":  Sprites.dessinerCentre(g, "arrow_10_3", img_x+((i-a)*50), img_y);
                    break;
                    default: System.out.println("NOPE");
                    break;
                }
            }
        }
        //g.drawString(this.jeu.touche.toString(), 10, 400);
        

//        for (int i = 0; i < j; i++) {
//            String get = touche.get(i);
//            switch (get) {
//                case "Droite":  Sprites.dessinerCentre(g, "arrow_10_2", 200, 200);
//                break;
//                case "Gauche":  Sprites.dessinerCentre(g, "arrow_10_1", 230, 230);;
//                break;
//                case "Bas":  Sprites.dessinerCentre(g, "arrow_10_0", 210, 210);
//                break;
//                case "Haut":  Sprites.dessinerCentre(g, "arrow_10_3", 240, 240);
//                break;
//                default: System.out.println("NOPE");
//                break;
//            }
//        }

//double vit=(int)(this.jeu.v*100)/100.;
//g.drawString("vit:"+vit,50,10);

/*
g.setColor(Color.BLUE);
int dx=(int)this.jeu.objectifx;
int dy=(int)this.jeu.objectify;
int r=(int)this.jeu.rayon;
g.drawOval(dx-r,dy-r,2*r,2*r);
*/


g.dispose();
    }
    
}
