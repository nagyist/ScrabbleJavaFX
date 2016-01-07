
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
    
//    public Case(char lettre, boolean caseJouée) {
//        this.caseJouée = false;
//        this.lettre = lettre;
//    }  
    
    public void setChar(char lettre) { 
        this.lettre = lettre; 
    }
    
    abstract public void printCase();

    abstract public char getChar();
   
  



    
    
    
    
    

}
