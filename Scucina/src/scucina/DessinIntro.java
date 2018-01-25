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
public class DessinIntro implements DessinAbstract {
    
    
    JeuIntro jeu;
    Cases[][] cases;
    String nom_img = "intro";
    String chemin_map = "/img/intro.png";
    Bouton b2;
    
    
    public DessinIntro(JeuIntro j) {
        this.jeu = j;
        this.b2 = jeu.b2;
    }
    
    @Override
    public void dessiner(BufferedImage image) {
        // on recupere le graphics
        Graphics2D g=(Graphics2D)image.getGraphics();
        //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
        Sprites.dessiner(g, "intro", 0 , 0);
        //g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.f));
        /**
         * Récupéré bouton à partir de JeuMenu en attribut
         * --> Dessiner depuis les attributs des boutons !
         */
        
        g.setColor(Color.white);
        g.setFont(new Font("helvetica", Font.PLAIN, 20)); 
        g.drawString(b2.txt, b2.txtx, b2.txty);
        
        
        g.dispose();
        
        
        
        //jeu.print();
    }
    
    
}