/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package scucina;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;

/**
 *
 * @author vincentboulanger
 */
public class DessinFin implements DessinAbstract {
    
    
    JeuFin jeu;
    Cases[][] cases;
    String nom_img = "fin";
    String chemin_map = "/img/fin.jpg";
    Bouton b2;
    
    
    public DessinFin(JeuFin j) {
        this.jeu = j;
        this.b2 = jeu.b2;
    }
    
    @Override
    public void dessiner(BufferedImage image) {
        // on recupere le graphics
        Graphics2D g=(Graphics2D)image.getGraphics();
        //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
        Sprites.dessiner(g, "fin", 0 , 0);
        
        g.dispose();
        
        
        
        //jeu.print();
    }
    
    
}