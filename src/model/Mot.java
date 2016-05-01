package model;

import controllerGUI.ControllerGUI;
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


    public Mot() {
    }
    
    public void fill(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons)
            mot.add(j); 
    }

    public Mot(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons)
            mot.add(j);      
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
    
    public int size() {
        if (vertical)
            return getYFin() - getYDeb() + 1;
        else if (!vertical)
            return getXFin() - getXDeb() + 1;
        else
            return -1;        
    }
    
    
    public String getString() {

        StringBuilder sb = new StringBuilder();
        
        for (Jeton j : mot) {
            sb.append(j.getStr());
        }

        return sb.toString();
    }
    
    
 
}
