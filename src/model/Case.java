
package model;

/**
 *
 * @author 0404ragrau
 */
public class Case {
    

    private enum CASETYPE {
        CASENORMALE, CASEMOTTRIPLE, CASEMOTDOUBLE, CASELETTRETRIPLE, CASELETTREDOUBLE,
        CASECENTRE, RESET 
    }
    private boolean caseJouée;
    private String lettre;
    
    
    
    public Case(String lettre, boolean caseJouée, enum CASETYPE) {
        this.caseJouée = false;
        this.lettre = lettre;
        this.CASETYPE = CASETYPE;
    }  
    
    
    
    // methode qui va prendre la lettre du Jeton et l'ajouter à la case jouée
    public String getLettre() {
        
    }
    
    

//    Case() {
//        setLetter(null);
//        setId(0);
//    }
//    
//    public String getLetter() {
//        return letter;
//    }
//    
//    public int getId() {
//        return id;
//    }
//    
//    public void setLetter(String lettre) {
//        this.lettre = lettre;
//    }


    
}
