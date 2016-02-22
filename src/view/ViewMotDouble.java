package view;

/**
 *
 * @author 0404ragrau
 */
public class ViewMotDouble extends ViewCase {
    
    private static final String MOTDOUBLE = "\u001b[45m"; 
    private static final String RESET = "\u001B[0m";
    
    
    public ViewMotDouble(char lettre) {
        super(lettre);
    }
   
    @Override
    public String toString() {
        return MOTDOUBLE + " " + getLettre() + " " + RESET;
    }
    
}
