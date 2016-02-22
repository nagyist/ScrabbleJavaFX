package view;

/**
 *
 * @author 0404ragrau
 */
public class ViewDouble extends ViewCase {

    private static final String DOUBLE = "\u001b[46m"; 
    private static final String RESET = "\u001B[0m";
    
    
    public ViewDouble(char lettre) {
        super(lettre);
    }
    
    
    @Override
    public String toString() {
        return DOUBLE + " " + getLettre() + " " + RESET;
    }

    
}
