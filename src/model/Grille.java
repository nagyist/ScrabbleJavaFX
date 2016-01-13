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
    private static final Set<Point> motsDoubles = new HashSet<Point>();
    private static final Set<Point> motsTriples = new HashSet<Point>();

       
    
    public Grille() {
        this.grille = new Case[DIM][DIM];
        initGrille();
    }

    public Case getCase(Point pt) {
        return this.grille[pt.x][pt.y];
    }
    
    public char getCharAt(Point pt) {
        return getCase(pt).getChar();
    }
   
    public void notif() {
        setChanged();
        notifyObservers();
    }
    
    public void initGrille() {
         
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
        
        motsDoubles.add(new Point(1, 1));
        motsDoubles.add(new Point(2, 2));
        motsDoubles.add(new Point(3, 3));
        motsDoubles.add(new Point(4, 4));
        motsDoubles.add(new Point(1, DIM-2));
        motsDoubles.add(new Point(2, DIM-3));
        motsDoubles.add(new Point(3, DIM-4));
        motsDoubles.add(new Point(4, DIM-5));
        
        motsDoubles.add(new Point(7, 7));
        
        motsDoubles.add(new Point(DIM-2, DIM-2));
        motsDoubles.add(new Point(DIM-3, DIM-3));
        motsDoubles.add(new Point(DIM-4, DIM-4));
        motsDoubles.add(new Point(DIM-5, DIM-5));
        motsDoubles.add(new Point(DIM-5, 4));
        motsDoubles.add(new Point(DIM-4, 3));
        motsDoubles.add(new Point(DIM-3, 2));
        motsDoubles.add(new Point(DIM-2, 1));

        motsTriples.add(new Point(0, 0));
        motsTriples.add(new Point(0, 7));
        motsTriples.add(new Point(0, DIM - 1));
        motsTriples.add(new Point(7, 0));
        motsTriples.add(new Point(7, DIM-1));
        motsTriples.add(new Point(DIM - 1, 0));
        motsTriples.add(new Point(DIM - 1, 7));
        motsTriples.add(new Point(DIM - 1, DIM - 1));
                
 
        for (int li = 0; li < DIM; ++li) {
            for (int co = 0; co < DIM; ++co) {
                Point pt = new Point(li, co);
                if (doubles.contains(pt))     
                    grille[li][co] = new Double();
                
                else if (triples.contains(pt)) 
                    grille[li][co] = new Triple();

                else if (motsDoubles.contains(pt))      
                    grille[li][co] = new MotDouble();

                else if (motsTriples.contains(pt))  
                    grille[li][co] = new MotTriple();
                
                else 
                    grille[li][co] = new Simple();         
            }
        }
    }
}



