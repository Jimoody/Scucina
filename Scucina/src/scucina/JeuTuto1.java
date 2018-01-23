/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scucina;

import java.awt.Color;
import java.awt.event.KeyEvent;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

/**
 *
 * @author vincentboulanger
 */
public class JeuTuto1 implements JeuAbstract{
    
        private Cases[][] plateau ;
        private Cases[][] portes;

    /**
	 * affiche la souris
	 */
	int sx, sy;
	Color c = Color.RED;

	/**
	 * le mode
	 */
	String mode="debut";
        public JeuTuto1() {
		this.mode = "debut";
                this.plateau = new Cases[6][6];
                this.portes = new Cases[1][2];
                // plateau[x][y]
                // x = colonne 
                // y = ligne
                this.plateau[0][0] = new Cases(false,"");
                this.plateau[1][0] = new Cases(false,"");
                this.plateau[2][0] = new Cases(false,"");
                this.plateau[3][0] = new Cases(false,"");
                this.plateau[4][0] = new Cases(false,"");
                this.plateau[5][0] = new Cases(false,"");
                this.plateau[0][1] = new Cases(false,"");
                this.plateau[1][1] = new Cases(true,"");
                this.plateau[2][1] = new Cases(false,"");
                this.plateau[3][1] = new Cases(false,"");
                this.plateau[4][1] = new Cases(true,"");
                this.plateau[5][1] = new Cases(false,"");
                this.plateau[0][2] = new Cases(false,"");
                this.plateau[1][2] = new Cases(true,"");
                this.plateau[2][2] = new Cases(false,"");
                this.plateau[3][2] = new Cases(false,"");
                this.plateau[4][2] = new Cases(true,"");
                this.plateau[5][2] = new Cases(false,"");
                this.plateau[0][3] = new Cases(false,"");
                this.plateau[1][3] = new Cases(true,"");
                this.plateau[2][3] = new Cases(false,"");
                this.plateau[3][3] = new Cases(false,"");
                this.plateau[4][3] = new Cases(true,"");
                this.plateau[5][3] = new Cases(false,"");
                this.plateau[0][4] = new Cases(true,"");
                this.plateau[1][4] = new Cases(true,"");
                this.plateau[2][4] = new Cases(true,"");
                this.plateau[3][4] = new Cases(true,"");
                this.plateau[4][4] = new Cases(true,"");
                this.plateau[5][4] = new Cases(false,"");
                this.plateau[0][5] = new Cases(true,"");
                this.plateau[1][5] = new Cases(false,"");
                this.plateau[2][5] = new Cases(false,"");
                this.plateau[3][5] = new Cases(false,"");
                this.plateau[4][5] = new Cases(true,"");
                this.plateau[5][5] = new Cases(false,"");
                // On donne les 2 cases de chaque côté de la porte. 
                // On supprime la porte pour des raisons de game design
                //this.portes[0][0]=this.plateau[3][4];
                //this.portes[0][0].setPorte(true);
                //this.portes[0][1]=this.plateau[4][4];
                //this.portes[0][1].setPorte(true);
                
                print();
        }

    public Cases[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Cases[][] plateau) {
        this.plateau = plateau;
    }

    public Cases[][] getPortes() {
        return portes;
    }

    public void setPortes(Cases[][] portes) {
        this.portes = portes;
    }

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    public int getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
        

	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		this.mode="debut";
		// evoluer stocke la souris
		this.sx = souris.getX();
		this.sy = souris.getY();
		if (souris.isPressed())
			c = Color.BLUE;
		else
			c = Color.RED;

		// si la souris est dans le carre
		if ((sx > 100) && (sy > 100) && (sy < 200) && (sx < 400) && (souris.getClicked())) {
			// on change de mode de jeu
			System.out.println("passe en mode fin");
			this.mode = "fin";
		}

		// si espace est une touche appuyee
		if (clavier.getTyped(KeyEvent.VK_SPACE)) {
			System.out.println("espace -> fin");
			this.mode = "fin";
		}
		return (this.mode);

	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}

    public void print() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(plateau[j][i] + " | ");
            }
            System.out.println("");
        }
    }
        
        
    
}
