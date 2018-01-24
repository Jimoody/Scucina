package scucina;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;

public class DessinPJ implements DessinAbstract {

	JeuPersonnage jeu;

	public DessinPJ(JeuPersonnage j) {
		this.jeu = j;
		
		// charger sprites
		Sprites.chargerImage("map-tuto1", "img/map_tuto1.png");
                Sprites.chargerImage("personnage", "img/perso.png");
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g=(Graphics2D)image.getGraphics();
		
		int x=(int)this.jeu.x;
		int y=(int)this.jeu.y;
                int map_x = this.jeu.map_x;
                int map_y = this.jeu.map_x;
		g.setColor(Color.PINK);
		Sprites.dessiner(g, "map-tuto1", map_x , map_y);
                Sprites.dessinerCentre(g, "personnage", x, y);

		g.setColor(Color.BLACK);
		//double vit=(int)(this.jeu.v*100)/100.;
		//g.drawString("vit:"+vit,50,10);
		
                /*
		g.setColor(Color.BLUE);
		int dx=(int)this.jeu.objectifx;
		int dy=(int)this.jeu.objectify;
		int r=(int)this.jeu.rayon;
		g.drawOval(dx-r,dy-r,2*r,2*r);
		*/
		
		
		g.dispose();
	}

}
