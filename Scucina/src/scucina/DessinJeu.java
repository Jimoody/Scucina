package scucina;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.moteur.DessinAbstract;

public class DessinJeu implements DessinAbstract {
    
    /**
	 * lien vers le jeu
	 */
	public Jeu jeu;

	/**
	 * dessin debut et fin
	 */
        public DessinMenu dm;
	public DessinTuto1 dt1;
	public DessinTuto2 dt2;

	/**
	 * constructeur
	 */
	public DessinJeu(Jeu j) {
		this.jeu = j;
                this.dm = new DessinMenu(this.jeu.jm);
		this.dt1 = new DessinTuto1(this.jeu.jt1);
		this.dt2 = new DessinTuto2(this.jeu.jt2);

	}

	/**
	 * permet de dessiner
	 */
	public void dessiner(BufferedImage image) {

		// on choisit le mode de dessin
		if (this.jeu.mode.equals("menu")) {
			this.dm.dessiner(image);
		}

		if (this.jeu.mode.equals("t1")) {
			this.dt1.dessiner(image);
		}
                
                if (this.jeu.mode.equals("t2")){
                    this.dt2.dessiner(image);
                }

	}
    
}
