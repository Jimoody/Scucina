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
public class Jeu implements JeuAbstract {
    
    
    /**
     * affiche la souris
     */
    int sx, sy;
    Color c = Color.RED;
    
    /**
     * mode de jeu
     */
    String mode;
    
    /**
     * les sous jeu
     */
    JeuMenu jm;
    JeuTuto1 jt1;
    JeuTuto2 jt2;
    
    /**
     * on creer un jeu au debut
     */
    public Jeu() {
        this.mode = "Menu";
        this.jm = new JeuMenu();
        this.jt1 = new JeuTuto1();
        this.jt2 = new JeuTuto2();
        
    }
    
    @Override
    public String evoluer(CClavier controle, CSouris souris) {
        switch (this.mode) {
            
            case "menu":
                this.mode = this.jm.evoluer(controle, souris);
                break;
                
            case "t1":
                this.mode = this.jt1.evoluer(controle, souris);
                break;
                
            case "t2":
                this.mode = this.jt2.evoluer(controle, souris);
                break;
        }
        return ("");
    }
    
    
    @Override
    public boolean etreFini() {
        // le jeu n'est jamais fini
        return false;
    }
    
}
