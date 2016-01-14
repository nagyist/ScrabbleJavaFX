package model;

/**
 *
 * @author 0404ragrau
 */
public abstract class Case {

//    private static final String RESET = "\u001B[0m ";
    private boolean caseJouée;
    private char lettre = ' ';

    

    public Case() {
        getChar();
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
       
//    @Override
//    abstract public String toString();

   
  



    
    
    
    
    

}
