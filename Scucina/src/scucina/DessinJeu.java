package scucina;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;

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
        public DessinIntro intro;
        public DessinFin fin;

	/**
	 * constructeur
	 */
	public DessinJeu(Jeu j) {
		this.jeu = j;
                this.dm = new DessinMenu(this.jeu.jm);
		this.dt1 = new DessinTuto1(this.jeu.jt1);
		this.dt2 = new DessinTuto2(this.jeu.jt2);
                this.intro = new DessinIntro(this.jeu.ji);
                this.fin = new DessinFin(this.jeu.fin);
                
        Sprites.chargerImage("map-tuto1", "img/map_tuto1.png");
        Sprites.chargerImage("map-tuto2", "img/map_tuto2.png");
        Sprites.chargerImage("menu", "img/menu1.png");
        Sprites.chargerImage("intro", "img/intro.png");
        Sprites.chargerImage("fin", "img/fin.png");
        Sprites.chargerImage("personnage", "img/perso.png");
        Sprites.chargerFeuille("perso", "img/trainer.png",3, 4);
        Sprites.chargerFeuille("arrow", "img/arrows.png", 12, 8);

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
                if (this.jeu.mode.equals("intro")){
                    this.intro.dessiner(image);
                }
                if(this.jeu.mode.equals("fin")){
                    this.fin.dessiner(image);
                }

	}
    
}
