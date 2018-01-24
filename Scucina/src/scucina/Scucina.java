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

public class Scucina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           //on cree un jeu
		//JeuTuto1 j = new JeuTuto1();
                JeuPersonnage j = new JeuPersonnage();
		
		//on cree une interface graphique
                    //DessinAbstract d=new DessinTuto1(j);	
                    DessinAbstract d = new DessinPJ(j);
				
		//on cree le moteur et on lance le jeu
		MoteurGraphique m=new MoteurGraphique(j, d);
		
		//on lance le moteur
		int fps=100;
                // 600 x 400
		int tailleX=314;
		int tailleY=328;
		m.lancerJeu(tailleX, tailleY, fps);
    }
    
}
