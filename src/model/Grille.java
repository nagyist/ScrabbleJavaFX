
package model;

import java.util.Observable;

/**
 *
 * @author 0404ragrau
 */
public class Grille extends Observable {
    

    private Case[][] grille;
    public static final int DIM = 15;

    
    public Grille() {
        this.grille = new Case[DIM][DIM];   
    }
 

    public void notif() {
        setChanged();
        notifyObservers();
    }
    
    public void initGrille() {
        
        for (int li = 0; li < DIM; ++li) {
            for (int co = 0; co < DIM; ++co) {
                if (li == 0 | li == DIM-1 | li == 7 && ( co == 3 | co == 11)   
                || (li == 2 | li == DIM-2) && (co == 6 | co == 8) 
                || (li == 3 | li == DIM-4) && (co == 0 | co == 7 | co == 14)
                || (li == 6 | li == DIM-7) && (co == 2| co == 6 | co == 8 | co == 12))
                
                    
                    grille[li][co] = new Double();
                
                else if ((li == 5 | li == 9 && co == 1 | co == 5 | co == 9 | co == 14) 
                      || (li == 1 | li == 13 && co == 5 | co == 9 ))
                    
                    grille[li][co] = new Triple();
                
                else if ((li == 1 | li == DIM-2 && co == 1 | co == DIM-2 )
                      || (li == 2 | li == DIM-3 && co == 2 | co == DIM-3 )
                      || (li == 3 | li == DIM-4 && co == 3 | co == DIM-4 )
                      || (li == 4 | li == DIM-5 && co == 4 | co == DIM-5 ) 
                      || (li == 7 && co == 7)
                        )
                    grille[li][co] = new MotDouble();
                
                else if ((li == 0 | li == DIM-1 && co == 0 | co == 7 | co == DIM-1 )
                      || (li == 7 && co == 0 | co == 7 | co == DIM-1) 
                        )
                    
                    grille[li][co] = new MotTriple();
                
                else 
                    grille[li][co] = new Simple();         
            }
        }
    }
    

    
    
    public void placerLettreGrille(char c, int li, int co) {
        
        grille[li][co].setChar(c);
        notif();
    }
  
    
    // methode qui va mettre à jour la grille après chaque coup joué
    public void updateGrille() {
        
        
        notif();
    }
    
}


