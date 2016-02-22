package view;

/**
 *
 * @author 0404ragrau
 */
public class ViewMotTriple extends ViewCase {
    
    private static final String MOTTRIPLE = "\u001b[41m";
    private static final String RESET = "\u001B[0m";
    
    
    public ViewMotTriple(char lettre) {
        super(lettre);
    }
   
    @Override
    public String toString() {
        return MOTTRIPLE + " " + getLettre() + " " + RESET;
    }
    
}
