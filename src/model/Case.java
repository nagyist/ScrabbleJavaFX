
package model;

/**
 *
 * @author 0404ragrau
 */
public abstract class Case {

    private static final String RESET = "\u001B[0m ";
    private boolean caseJouée;
    public char lettre = ' ';
    

    public Case() {
        this.lettre = lettre;
        caseJouée = false;
    }
    
    
    public void setChar(char lettre) { 
        
        if (!caseJouée) {
            this.lettre = lettre;
        } 
        caseJouée = true;
    }
       
    @Override
    abstract public String toString();

    abstract public char getChar();
   
  



    
    
    
    
    

}
