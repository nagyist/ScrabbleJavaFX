package model;
/**
 *
 * @author 0404ragrau
 */
public class Jeton {
    
    private final char lettre;
   
    public Jeton(char c) {
        this.lettre = c;
    }
    
    public char getChar() {
        return lettre;
    }
    
    public String getStr() {
        return ""+lettre;
    }

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
