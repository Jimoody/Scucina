/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scucina;

import java.util.ArrayList;

/**
 *
 * @author vincentboulanger
 */
public class Cases {
    
    private boolean peutMarcher;
    private ArrayList<Outils> outils = new ArrayList<Outils>(); 
    private boolean porte;
    private int x = 100;
    private int y = 100;
    private boolean joueur;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Cases(boolean peutMarcher, String outils) {
        this.peutMarcher = peutMarcher;
        if(outils.isEmpty()){
           System.out.println("");
        }
        else{
            Outils o = new Outils(outils); 
            this.outils.add(o);
        }
        this.joueur = false;
        
    }

    public boolean isJoueur() {
        return joueur;
    }

    public void setJoueur(boolean joueur) {
        this.joueur = joueur;
    }

    public boolean isPeutMarcher() {
        return peutMarcher;
    }

    public void setPeutMarcher(boolean peutMarcher) {
        this.peutMarcher = peutMarcher;
    }

    public ArrayList<Outils> getOutils() {
        return outils;
    }

    public void setOutils(ArrayList<Outils> outils) {
        this.outils = outils;
    }



    public void addOutils(String o){
        Outils out = new Outils(o);
        this.outils.add(out);
    }

    public boolean isPorte() {
        return porte;
    }

    public void setPorte(boolean porte) {
        this.porte = porte;
    }

    @Override
    public String toString() {
        if(this.joueur){
            return "p";
        }
        else if(!this.peutMarcher){
            return "X";
        }
        else if(!this.porte){
            return " ";
        }
        else if(this.porte ){
            return "o";
        }
        else {
            return "#";
        }
    }
    
    
}
