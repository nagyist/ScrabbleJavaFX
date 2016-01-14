package view;

import model.*;

/**
 *
 * @author 0404ragrau
 */
public class ViewSimple extends ViewCase {

    private static final String SIMPLE = "\u001b[40m";
    private static final String RESET = "\u001B[0m";


    
    public ViewSimple(char lettre) {
        super(lettre);
    }
    
    @Override
    public String toString() {
        return SIMPLE + " " + getLettre() + " " + RESET;
    }

    
}
