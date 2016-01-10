
package model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 *
 * @author 0404ragrau
 */
public class Grille extends Observable {
    

    public Case[][] grille;
    public static final int DIM = 15;
    

    private static final Set<Point> simples = new HashSet<Point>();
    private static final Set<Point> doubles = new HashSet<Point>();
    private static final Set<Point> triples = new HashSet<Point>();
    private static final Set<Point> motdoubles = new HashSet<Point>();
    private static final Set<Point> mottriples = new HashSet<Point>();

       
    
    public Grille() {
        this.grille = new Case[DIM][DIM];   
    }

    
    public Case getCase(int li, int co) {
        return this.grille[li][co];
    }
    
    public void notif() {
        setChanged();
        notifyObservers();
    }
    
    public void initGrille() {
        
        /*
        doubles.add(new Point(0, 3));
        doubles.add(new Point(0, DIM-4));
        doubles.add(new Point(2, 6));
        doubles.add(new Point(2, DIM-7));
        
        doubles.add(new Point(3, 0));
        doubles.add(new Point(3, 7));
        doubles.add(new Point(3, DIM-1));
        
        doubles.add(new Point(6, 2));
        doubles.add(new Point(6, 6));
        doubles.add(new Point(6, DIM-7));
        doubles.add(new Point(6, DIM-3));
        
        doubles.add(new Point(7, 3));
        doubles.add(new Point(7, DIM-4));
        
        doubles.add(new Point(DIM-7, 2));
        doubles.add(new Point(DIM-7, 6));
        doubles.add(new Point(DIM-7, DIM-7));
        doubles.add(new Point(DIM-7, DIM-3));
        
        doubles.add(new Point(DIM-4, 0));
        doubles.add(new Point(DIM-4, 7));
        doubles.add(new Point(DIM-4, DIM-1));
        
        doubles.add(new Point(DIM-3, 6));
        doubles.add(new Point(DIM-3, DIM-7));
        doubles.add(new Point(DIM-1, 3));
        doubles.add(new Point(DIM-1, DIM-4));
        
        triples.add(new Point(1,5));
        triples.add(new Point(1, DIM-6));
        triples.add(new Point(5,1));
        triples.add(new Point(5,5));
        triples.add(new Point(5, DIM-6));
        triples.add(new Point(5,DIM-2));
        
        triples.add(new Point(DIM-6, 1));
        triples.add(new Point(DIM-6, 5));
        triples.add(new Point(DIM-6, DIM-6));
        triples.add(new Point(DIM-6,DIM-2));
        triples.add(new Point(DIM-2, 5));
        triples.add(new Point(DIM-2, DIM-6));        
        
        motdoubles.add(new Point(1, 1));
        motdoubles.add(new Point(DIM-2, DIM-2));
        motdoubles.add(new Point(2, 2));
        motdoubles.add(new Point(DIM-3, DIM-3));
        motdoubles.add(new Point(3, 3));
        motdoubles.add(new Point(DIM-4, DIM-4));
        motdoubles.add(new Point(4, 4));
        motdoubles.add(new Point(DIM-5, DIM-5));
        
        motdoubles.add(new Point(7, 7));

        motdoubles.add(new Point(DIM-5, 4));
        motdoubles.add(new Point(DIM-5, DIM-5));
        motdoubles.add(new Point(DIM-4, 3));
        motdoubles.add(new Point(DIM-4, DIM-4));
        motdoubles.add(new Point(DIM-3, 2));
        motdoubles.add(new Point(DIM-3, DIM-3));
        motdoubles.add(new Point(DIM-2, 1));
        motdoubles.add(new Point(DIM-2, DIM-2));

        mottriples.add(new Point(0, 0));
        mottriples.add(new Point(0, 7));
        mottriples.add(new Point(0, DIM - 1));
        mottriples.add(new Point(7, 0));
        mottriples.add(new Point(7, DIM-1));
        mottriples.add(new Point(DIM - 1, 0));
        mottriples.add(new Point(DIM - 1, 7));
        mottriples.add(new Point(DIM - 1, DIM - 1));
                
        */
        
        
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
  
    
    
    public void updateGrille() {
  
        notif();
    }
    

}



