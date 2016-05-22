package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 0404ragrau
 */
public class Mot {

    private final List<Jeton> mot = new ArrayList<>();
    private Jeton jDeb;
    private Jeton jFin;
    private boolean vertical;
    private int valeurMot;


    public Mot() {   
    }
    
    public void fill(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons)
            mot.add(j); 
    }
    
    public void add(Jeton j) {
        mot.add(j);
    }

    public void calcPoints(Grille grille) {
        for (Jeton j : mot) {
            if (!grille.caseJouee(j.getX(), j.getY())) {
                if (grille.getCaseType(j).equals("double")) {
                    valeurMot = valeurMot + (j.getPoints()) * 2;
                    System.out.println("double");
                } else if (grille.getCaseType(j).equals("triple")) {
                    valeurMot = valeurMot + (j.getPoints()) * 3;
                    System.out.println("triple");
                } else {
                    System.out.println("simple ou motdouble ou mottriple");
                    valeurMot = valeurMot + j.getPoints();
                }
                
            } else {
                valeurMot = valeurMot + j.getPoints();
                System.out.println("simple ou case déjà jouée");
            }
        }
        for (Jeton j : mot) {
            if (!grille.caseJouee(j.getX(), j.getY())) {
                if (grille.getCaseType(j).equals("motDouble")) {
                    valeurMot = valeurMot * 2;
                } else if (grille.getCaseType(j).equals("motTriple")) {
                    valeurMot = valeurMot * 3;
                }
            }

        }
    }
    
    public int getPointsMot() {
        return valeurMot;
    }
       
    public void setJDeb(Jeton j) {
        this.jDeb = j;
    }
            
    public Jeton getJDeb() {
        return jDeb;
    }
    
    public void setJFin(Jeton j) {
        this.jFin = j;
    }
    
    public Jeton getJFin() {
        return jFin;
    }
    
    public void setAlign() {
        
        if (jDeb.getY() == jFin.getY())
            vertical = false;
        else if (jDeb.getX() == jFin.getX())
            vertical = true;
    }
    
    public void affAlign() {
        if (isVerti())
            System.out.println("mot vertical");
        else
            System.out.println("mot horizontal");
    }
    
    public boolean isVerti() {
        return vertical;
    }
    
    public int getXDeb() {
        return jDeb.getX();
    }
    
    public int getYDeb() {
        return jDeb.getY();
    }
    
    public int getXFin() {
        return jFin.getX();
    }
    
    public int getYFin() {
        return jFin.getY();
    }
    
//    public int size() {
//        if (vertical)
//            return getYFin() - getYDeb() + 1;
//        else if (!vertical)
//            return getXFin() - getXDeb() + 1;
//        else
//            return -1;        
//    }
//    
//    public int si() {
//        int cpt = 0 ;
//        for (Jeton j : mot)
//            cpt++;
//        return cpt;
//    }
    
    public String getMotStr() {
        StringBuilder sb = new StringBuilder();
               
        for (Jeton j : mot) {
            sb.append(j.getStr());
        }
        return sb.toString();
    }
    
    
    
    
    public String getString() {

        StringBuilder sb = new StringBuilder();
               
        for (Jeton j : mot) {
            sb.append(j.getStr());
        }
        
        
        sb.append(" (");
        sb.append(getPointsMot());
        sb.append(")");
        sb.append("\n");

        return sb.toString();
    }
    
    
 
}
