package view;

/**
 *
 * @author 0404ragrau
 */
public abstract class ViewCase {

    
    private final char lettre;
    
    public ViewCase(char lettre) {
        this.lettre = lettre;
    }
    
    public char getLettre() {
        return lettre;
    }

    @Override
    abstract public String toString();
  

}
