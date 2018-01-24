/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scucina;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;

/**
 *
 * @author vincentboulanger
 */
public class DessinMenu implements DessinAbstract {

    
    JeuMenu jeu;
    Cases[][] cases;
    String nom_img = "map_tuto1";
    String chemin_map = "/img/map_tuto1.png";
    int score, bm, mm;
    
    
    public DessinMenu(JeuMenu j) {
        this.jeu = j;
        
        
    }
    
    @Override
    public void dessiner(BufferedImage image) {
        // on recupere le graphics
        Graphics2D g=(Graphics2D)image.getGraphics();
        
        /**
         * Récupéré bouton à partir de JeuMenu en attribut
         * --> Dessiner depuis les attributs des boutons ! 
         */
        g.dispose();
        
        
        
        //jeu.print();
    }
    
    
}

}
