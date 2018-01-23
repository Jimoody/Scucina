/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scucina;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.moteur.DessinAbstract;


/**
 *
 * @author vincentboulanger
 */
public class DessinTuto1 implements DessinAbstract {
    
    JeuTuto1 jeu;
    Cases[][] cases;

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
                
		//g.fillRect(100, 100, 300, 100);
                g.fillRect(jeu.getPlateau()[1][1].getX(), jeu.getPlateau()[1][1].getY(), cases[1][1].getX(), cases[1][1].getY());

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

	}

    
}
