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
public class JeuFin implements JeuAbstract {
    
/**
	 * affiche la souris
	 */
	int sx, sy;
	Color c = Color.RED;
        Bouton b2;
        
        

	/**
	 * le mode
	 */
	String mode="fin";

    public JeuFin() {
       
        this.mode="fin";
    }

	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		this.mode="fin";
		// evoluer stocke la souris
		this.sx = souris.getX();
		this.sy = souris.getY();
		return (this.mode);

	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
