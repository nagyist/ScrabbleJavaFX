package model;

import java.util.Comparator;

/**
 *
 * @author 0404ragrau
 */
public class Jeton {
    
    private final char lettre;
    private int x, y;
   
    public Jeton(char c, int x, int y) {
        this.lettre = c;
        this.x = x;
        this.y = y;
    }
    
    public char getChar() {
        return lettre;
    }
    
    public String getStr() {
        return ""+lettre;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }      
    
    public static Comparator<Jeton> COMPARE_BY_X = (Jeton j, Jeton jj) -> {
        Integer jx = j.x;
        Integer jjx = jj.x;
        return jx.compareTo(jjx);
    };

    public static Comparator<Jeton> COMPARE_BY_Y = (Jeton j, Jeton jj) -> {
        Integer jy = j.y;
        Integer jjy = jj.y;
        return jy.compareTo(jjy);
    };
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.lettre;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jeton other = (Jeton) obj;
        return this.lettre == other.lettre;
    }


    
    
}
