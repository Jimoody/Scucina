package scucina;

import java.awt.Color;
import java.awt.event.KeyEvent;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class JeuPersonnage implements JeuAbstract {

	double x, y;
	double v = 60;
        int largeur_case = 45;
        int hauteur_case = 50;
	double objectifx = 500;
	double objectify = 300;
	double rayon = 50;
        String mode="debut"; 
        int map_x;
        int map_y;
        int direction; 
        /*
        0 = face
        1 = dos
        2 = gauche
        3 = droite
        */
        
        Cases[][] plateau ;
        Cases[][] portes;
        int personnage_x;
        int personnage_y;
        

	public JeuPersonnage() {
                this.personnage_x = 4;
                this.personnage_y = 1;
                x = (this.personnage_x) * this.largeur_case + this.largeur_case;
                y = (this.personnage_y) * this.hauteur_case + this.hauteur_case/2;
                
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
                this.plateau[this.personnage_x][this.personnage_y].setJoueur(true);
                //print();
                //this.map_x = 200;
                //this.map_y = 150;
                this.map_x = 0;
                this.map_y = 0;
                this.direction = 0;
                this.perso();
                
	}

        public void perso(){
            System.out.println("Colonne : "+ (this.personnage_x+1)+" \nLigne : " + (this.personnage_y+1)+"\n");
        }
        
	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
            this.mode="PJ";

		// decale le personnage en fonction des touches
		if (clavier.getTyped(KeyEvent.VK_LEFT)) {
                    System.out.println("Gauche");
                    System.out.println("mon x est de : "+ this.personnage_x);
                    if (this.plateau[personnage_x-1][personnage_y].isPeutMarcher() && this.personnage_x > -1){
                        System.out.println("Gauche1");
			this.x = this.x - v+10;
                        this.personnage_x--;
			if (this.x < 0)
				this.x = 0;
                        this.direction=2;
                }
		}

		if (clavier.getTyped(KeyEvent.VK_RIGHT)) {
                    System.out.println("Droite");
                    System.out.println("mon x est de : "+ this.personnage_x);
                    if (this.plateau[personnage_x+1][personnage_y].isPeutMarcher() && this.personnage_x < 5){
                        System.out.println("Droite1");
			this.x = this.x + v-10;
                        this.personnage_x++;
			if (this.x > 314)
				this.x = 314;
                        this.direction=3;
                    }
		}

		if (clavier.getTyped(KeyEvent.VK_UP)) {
                    System.out.println("Haut");
                    System.out.println("mon y est de : "+ this.personnage_y);
                    if (this.plateau[personnage_x][personnage_y-1].isPeutMarcher() && this.personnage_y-1 > -2){
                        System.out.println("Haut1");
			this.y = this.y - v;
                        this.personnage_y--;
			if (this.y < 0)
				this.y = 0;
                        this.direction=1;
                    }
		}

		if (clavier.getTyped(KeyEvent.VK_DOWN)) {
                    System.out.println("Bas");
                    System.out.println("mon y est de : "+ this.personnage_y);
                    if (this.plateau[personnage_x][personnage_y].isPeutMarcher() && (this.personnage_y < 5)){
                        System.out.println("Bas1");
			this.y = this.y + v;
                        this.personnage_y++;
			if (this.y > 328)
				this.y = 328;
                        this.direction=0;
                        this.perso();
                    }
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
        
        
   public int getPersonnage_x() {
        return personnage_x;
    }

    public void setPersonnage_x(int personnage_x) {
        this.personnage_x = personnage_x;
    }

    public int getPersonnage_y() {
        return personnage_y;
    }

    public void setPersonnage_y(int personnage_y) {
        this.personnage_y = personnage_y;
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}

}
