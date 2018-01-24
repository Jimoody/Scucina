/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scucina;

/**
 *
 * @author vincentboulanger
 */
public class Bouton {
    
    int pos_x, pos_y, hauteur, largeur, txtx, txty;
    String txt;

    public Bouton(int pos_x, int pos_y, int hauteur, int largeur, int txtx, int txty, String txt) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.txtx = txtx;
        this.txty = txty;
        this.txt = txt;
    }
    
    
    
}
