/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scucina;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.moteur.JeuAbstract;
import moteurJeu.moteur.MoteurGraphique;


/**
 *
 * @author vincentboulanger
 */
public class Jeu {
    
    //on cree un jeu
		JeuTuto1 j = new JeuTuto1();
		
		//on cree une interface graphique
		DessinTuto1 d = new DessinTuto1(j);	
				
		//on cree le moteur et on lance le jeu
		MoteurGraphique m = new MoteurGraphique(j, d);
		
		//on lance le moteur
		int fps=100;
		int tailleX=600;
		int tailleY=400;
		m.lancerJeu(tailleX, tailleY, fps);
                
}
