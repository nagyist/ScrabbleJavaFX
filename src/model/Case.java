
package model;

/**
 *
 * @author 0404ragrau
 */
abstract class Case {

    private boolean caseJouée;
    char lettre;
    

    public Case() {
        this.lettre = lettre;    
    }
    
    
    public void setChar(char lettre) { 
        this.lettre = lettre; 
    }
    
    @Override
    abstract public String toString();

    abstract public char getChar();
   
  



    
    
    
    
    

}
