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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import moteurJeu.moteur.DessinAbstract;


/**
 *
 * @author vincentboulanger
 */
public class DessinTuto1 implements DessinAbstract {
    
    JeuTuto1 jeu;
    Cases[][] cases;
    String nom_img = "map_tuto1";
    String chemin_map = "/img/map_tuto1.png";
    
    
    public DessinTuto1(JeuTuto1 j) {
        this.jeu = j;
        this.cases= jeu.getPlateau();
    }
    
    @Override
    public void dessiner(BufferedImage image) {
        // on recupere le graphics
        Graphics2D g = (Graphics2D) image.getGraphics();
        
        // on dessine un rectangle vert
        g.setColor(Color.GREEN);
        
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                int month = 0 + (int)(Math.random() * ((6) + 1));
//                switch (month) {
//                    case 1:  g.setColor(Color.GREEN);
//                    break;
//                    case 2:  g.setColor(Color.YELLOW);
//                    break;
//                    case 3:  g.setColor(Color.GRAY);
//                    break;
//                    case 4:  g.setColor(Color.blue);
//                    break;
//                    case 5:  g.setColor(Color.red);
//                    break;
//                    case 6:  g.setColor(Color.magenta);
//                    break;
//                    case 0:  g.setColor(Color.cyan);
//                    break;
//                }   
//                //g.fillRect(jeu.getPlateau()[j][i].getX(), jeu.getPlateau()[j][i].getY(), i*11, j*11);
//                g.fillRect(i*15, j*15, jeu.getPlateau()[j][i].getX(), jeu.getPlateau()[j][i].getY());
//        
               // fillRect(int x, int y, int width, int height)
               
        
        g.fillRect(100, 100, 300, 100);
        //g.fillRect(jeu.getPlateau()[1][1].getX(), jeu.getPlateau()[1][1].getY(), cases[1][1].getX(), cases[1][1].getY());
        
        // on dessine les cercles au coin
        g.setColor(Color.BLUE);
        int t = 10;
        g.drawOval(100 - t, 100 - t, 2 * t, 2 * t);
        g.drawOval(100 - t, 200 - t, 2 * t, 2 * t);
        g.drawOval(400 - t, 100 - t, 2 * t, 2 * t);
        g.drawOval(400 - t, 200 - t, 2 * t, 2 * t);
        
        // on dessine la souris
        g.setColor(this.jeu.c);
        g.fillOval(this.jeu.sx - t, this.jeu.sy - t, 2 * t, 2 * t);
        
        // on ecrit dans le rectangle
        g.setColor(Color.BLACK);
        g.drawString("Cliquez ici", 150, 155);
        g.dispose();
        
        
        
        //jeu.print();
    }
    
    
}
