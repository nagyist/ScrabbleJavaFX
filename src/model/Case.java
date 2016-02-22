package model;

/**
 *
 * @author 0404ragrau
 */
public abstract class Case {

    private boolean caseJouée;
    private char lettre = ' ';


    public Case() {
        caseJouée = false;
    }
    
    public char getChar() {
        return this.lettre;
    }
    
    public void setChar(char lettre) { 
        
        if (!caseJouée) {
            this.lettre = lettre;
        } 
        caseJouée = true;
    }


   
  



    
    
    
    
    

}
