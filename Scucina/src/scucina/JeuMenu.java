/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scucina;

import java.awt.Color;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.DessinAbstract;
import moteurJeu.moteur.JeuAbstract;
import moteurJeu.moteur.MoteurGraphique;


/**
 *
 * @author vincentboulanger
 */
public class JeuMenu implements JeuAbstract {
    
/**
	 * affiche la souris
	 */
	int sx, sy;
	Color c = Color.RED;
        Bouton b1, b2;

	/**
	 * le mode
	 */
	String mode="debut";

	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		this.mode="debut";
		// evoluer stocke la souris
		this.sx = souris.getX();
		this.sy = souris.getY();
                
		
		// si la souris est dans le carre
		if ((sx > 100) && (sy > 100) && (sy < 200) && (sx < 400) && (souris.getClicked())) {
			// on change de mode de jeu
			System.out.println("passe en mode fin");
			this.mode = "t1";
		}

                // si la souris est dans le carre
		if ((sx > 100) && (sy > 100) && (sy < 200) && (sx < 400) && (souris.getClicked())) {
			// on change de mode de jeu
			System.out.println("passe en mode fin");
			this.mode = "t2";
		}

		return (this.mode);

	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
