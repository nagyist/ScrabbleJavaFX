package view;

import controller.ControllerImpl;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import model.Chevalet;
import model.Grille;
import static model.Grille.DIM;
import model.Mot;

/**
 *
 * @author 0404ragrau
 */
public class View implements Observer {
    
    
    private final ControllerImpl ctrl;
    private final Scanner scanner = new Scanner(System.in);
    private char CHAR_FIN_MOT = '/';
    public Chevalet chev;
    public Grille grille;
    public Mot mot;
    
    
    public View(ControllerImpl ctrl) {
        this.ctrl = ctrl;
        this.chev = ctrl.getChevalet();
        this.grille = ctrl.getGrille();
        this.mot = ctrl.getMot();
    }

      
    public void afficherGrille() {
        
        System.out.println("-----------------------------------------------");
        for (int li = 0; li < DIM; li++) {
            System.out.print("|");
            for (int co = 0; co < DIM; co++) {  
                Point pt = new Point(li,co);
                System.out.print(grille.getCase(pt));  
            }
            System.out.print("|\n");
        } 
        System.out.println("-----------------------------------------------");
    }

    
    public void afficherChevalet() {
        
        chev.getJetons();
        System.out.print("\n"); 
        System.out.println("-----------------------------------------------");
    }
    
    public void afficherMot(Mot mot) {
        System.out.print("Mot placé : ");
        mot.afficherMot();
        System.out.print("\n"); 
    }
    
        
    public char choisirLettre() {
        
        System.out.println("choisir lettre : ");
        return ctrl.getCh();

    }

    
    private boolean positionValide(Point pt) {
        return pt.x >= 0 && pt.x < DIM && 
                pt.y >= 0 && pt.y < DIM &&
                grille.getCharAt(pt) == ' ';
    }
    
    public Point choisirPosition() {
   
        Point pt = new Point(); 
        System.out.println("choisir position (li, co) : ");
        
        pt.x = scanner.nextInt();
        pt.y = scanner.nextInt();
        
        while (!positionValide(pt)) {
            System.out.println("mauvaise position");
            pt.x = scanner.nextInt();
            pt.y = scanner.nextInt();   
        } 
        return pt;      
    }
 
   

    @Override
    public void update(Observable o, Object arg) {
//        if (o instanceof Chevalet)
//            afficherChevalet();
//        else if (o instanceof Grille) {
//            afficherGrille();
//        }
        
        afficherGrille();
        afficherChevalet();
        
        char ch = choisirLettre();
        if (ch == CHAR_FIN_MOT)
            afficherMot(mot);
        else {
            Point pt = choisirPosition();
            ctrl.positionnerLettre(pt, ch);
        }


    }

    
}