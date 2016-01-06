
package model;

/**
 *
 * @author 0404ragrau
 */
abstract class Case {
    

    private boolean caseJouée;
    char lettre;
    
    
    private static final String SIMPLE = "\u001b[40m ";
    private static final String TRIPLE = "\u001b[44m "; 
    private static final String DOUBLE = "\u001b[46m "; 
//    private static final String MOTTRIPLE = "\u001b[41m "; 
//    private static final String MOTDOUBLE = "\u001b[45m "; 
//    private static final String CASECENTRE = "\u001b[43m ";
    private static final String RESET = "\u001B[0m ";
    
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
