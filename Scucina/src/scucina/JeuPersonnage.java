package scucina;

import java.awt.event.KeyEvent;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class JeuPersonnage implements JeuAbstract {

	double x, y;
	double v = 60;
	double objectifx = 500;
	double objectify = 300;
	double rayon = 50;
        String mode="debut"; 
        int map_x;
        int map_y;

	public JeuPersonnage() {
		this.x = 80;
		this.y = 75;
                //this.map_x = 200;
                //this.map_y = 150;
                this.map_x = 0;
                this.map_y = 0;
                
	}

	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
            this.mode="PJ";

		// decale le personnage en fonction des touches
		if (clavier.getTyped(KeyEvent.VK_LEFT)) {
			this.x = this.x - v+10;
			if (this.x < 0)
				this.x = 0;
		}

		if (clavier.getTyped(KeyEvent.VK_RIGHT)) {
			this.x = this.x + v-10;
			if (this.x > 314)
				this.x = 314;
		}

		if (clavier.getTyped(KeyEvent.VK_UP)) {
			this.y = this.y - v;
			if (this.y < 0)
				this.y = 0;
		}

		if (clavier.getTyped(KeyEvent.VK_DOWN)) {
			this.y = this.y + v;
			if (this.y > 328)
				this.y = 328;
		}


		// si on arrive � la fin
		double dx = this.x - this.objectifx;
		double dy = this.y - this.objectify;
		double distance = Math.sqrt(dx * dx + dy * dy);
		if (distance < 50) {
			this.x = 100;
			this.y = 100;
			return ("fin");
		}

		return ("PJ");
	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}

}
