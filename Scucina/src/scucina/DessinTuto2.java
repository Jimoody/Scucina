/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package scucina;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;


/**
 *
 * @author vincentboulanger
 */
public class DessinTuto2 implements DessinAbstract {
    
    JeuTuto2 jeu;
    Cases[][] cases;
    String nom_img = "map-tuto2";
    String fleche = "next1";
    String chemin_map = "/img/map_tuto2.png";
    String chemin_next = "/img/next1.png";
    int score, bm, mm;
    
    
    public DessinTuto2(JeuTuto2 j) {
        this.jeu = j;
        this.cases= jeu.getPlateau();
        // charger sprites
//        Sprites.chargerImage("map-tuto1", "img/map_tuto1.png");
//        Sprites.chargerImage("personnage", "img/perso.png");
//        Sprites.chargerFeuille("perso", "img/trainer.png",3, 4);
//        Sprites.chargerFeuille("arrow", "img/arrows.png", 12, 8);

    }
    
    @Override
    public void dessiner(BufferedImage image) {
        // on recupere le graphics
        Graphics2D g=(Graphics2D)image.getGraphics();
        this.score = this.jeu.score;
        int x=(int)this.jeu.x;
        int y=(int)this.jeu.y;
        int map_x = this.jeu.map_x;
        int map_y = this.jeu.map_x;
        ArrayList<String> touche = this.jeu.touche;
        
        
        Sprites.dessiner(g, "map-tuto2", map_x , map_y);
        g.setColor(Color.WHITE);
        g.drawString("Score : " + String.valueOf(this.score), 320, 20);
        String chaine="";
        if (this.jeu.direction==0) // haut
            chaine="perso_1_0";
        if (this.jeu.direction==1) // bas
            chaine="perso_1_3";
        if (this.jeu.direction==2) // gauche
            chaine="perso_1_1";
        if (this.jeu.direction==3) // droite
            chaine="perso_1_2";
        
        Sprites.dessinerCentre(g, chaine, x, y+20);
        
        if(this.jeu.ok())
        Sprites.dessinerCentre(g, "next1", 525, 450);
        
        int img_x = 30;
        int img_y = 360;
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
        
        
        g.dispose();
        
        
        
        //jeu.print();
    }
    
    
}
