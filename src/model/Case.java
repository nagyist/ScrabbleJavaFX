package model;

/**
 *
 * @author 0404ragrau
 */
public abstract class Case {

    private boolean caseJouee;
    private char lettre = ' ';


    public Case() {
        caseJouee = false;
    }
    
    public char getChar() {
        return this.lettre;
    }
    
//    public void setChar(char lettre) { 
//        
//        if (!caseJouee) {
//            this.lettre = lettre;
//        } 
//        caseJouee = true;
//    }
    
    public boolean caseLibre() {
        return caseJouee;
    }
    
   
    public void setLettre(char lettre) {
        if (caseLibre())
            this.lettre = lettre;
        
        caseJouee = true;
    }


   
  



    
    
    
    
    

}
