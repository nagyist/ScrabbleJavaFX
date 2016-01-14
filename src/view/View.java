package view;

import controller.Controller;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import static model.Grille.DIM;
import model.Case;
import model.Chevalet;
import model.Double;
import model.Grille;
import model.Jeton;
import model.Mot;
import model.MotDouble;
import model.MotTriple;
import model.Simple;
import model.Triple;
/**
 *
 * @author 0404ragrau
 */
public class View implements Observer {
    
    
    private final Controller ctrl;
    private final Scanner scanner = new Scanner(System.in);
    private char CHAR_FIN_MOT = '/';
    public Chevalet chev;
    public Grille grille;
    public Mot mot;
    
    
    public View(Controller ctrl) {
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
                Case caseCourante = grille.getCase(pt);
                if (caseCourante instanceof Simple) {
                    ViewCase vSimple = new ViewSimple(caseCourante.getChar());
                    System.out.print(vSimple);
                }
                else if (caseCourante instanceof Double) {
                    ViewCase vDouble = new ViewDouble(caseCourante.getChar());
                    System.out.print(vDouble);
                }
                else if (caseCourante instanceof Triple) {
                    ViewCase vTriple = new ViewTriple(caseCourante.getChar());
                    System.out.print(vTriple);
                }
                else if (caseCourante instanceof MotDouble) {
                    ViewCase vMotDouble = new ViewMotDouble(caseCourante.getChar());
                    System.out.print(vMotDouble);
                } 
                else if (caseCourante instanceof MotTriple) {
                    ViewCase vMotTriple = new ViewMotTriple(caseCourante.getChar());
                    System.out.print(vMotTriple);
                } 
            }
            System.out.print("|\n");
        } 
        System.out.println("-----------------------------------------------");
    }

    
    public void afficherChevalet() {
        
        for (Jeton j : chev.getChev())
            System.out.print(j.getChar() + "  ");
        
        System.out.print("\n"); 
        System.out.println("-----------------------------------------------");
    }
    
    public void afficherMot(Mot m) {
        
        System.out.print("Mot placé : ");
        ViewMot mot = new ViewMot(m);        
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