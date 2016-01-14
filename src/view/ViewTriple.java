package view;

import model.*;

/**
 *
 * @author 0404ragrau
 */
public class ViewTriple extends ViewCase {
    
    private static final String TRIPLE = "\u001b[44m"; 
    private static final String RESET = "\u001B[0m";

    
    public ViewTriple(char lettre) {
        super(lettre);
    }

    @Override
    public String toString() {
        return TRIPLE + " " + getLettre() + " " + RESET;
    }

    
}
