package model;

/**
 *
 * @author 0404ragrau
 */
public abstract class Case {

    private boolean caseJouee;
    private char lettre = ' ';
    private Jeton jeton = null;


    public Case() {
        caseJouee = false;
    }
    
    public char getChar() {
        return this.lettre;
    }
    
    public Jeton getJeton() {
        return this.jeton;
    }
    
//    public void setChar(char lettre) { 
//        
//        if (!caseJouee) {
//            this.lettre = lettre;
//        } 
//        caseJouee = true;
//    }
    
    public boolean caseLibre() {
        return !caseJouee;
    }
    
    public void setJeton(Jeton j) {
        if (caseLibre()) {
            this.jeton = j;
            this.lettre = j.getChar();
        }
            
        caseJouee = true;
    }
//   
//    public void setLettre(char lettre) {
//        if (caseLibre())
//            this.lettre = lettre;        
//        caseJouee = true;
//    }


   
  



    
    
    
    
    

}
