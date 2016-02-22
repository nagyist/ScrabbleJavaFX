package view;

import controllerGUI.ControllerGUI;
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
import model.Triple;
import viewGUI.ViewChevalet;
import viewGUI.ViewGrille;
/**
 *
 * @author 0404ragrau
 */
public class View {
    
    
    private final ControllerGUI ctrl;
    private final Scanner scanner = new Scanner(System.in);
    private final char CHAR_FIN_MOT = '/';
    public Chevalet chev;
    public Grille grille;
    public Mot mot;
    
    
    public View(ControllerGUI ctrl) {
        this.ctrl = ctrl;
        this.chev = ctrl.getChevalet();
        this.grille = ctrl.getGrille();
        this.mot = ctrl.getMot();
    }

      
    public void afficherGrille() {
//        System.out.println("  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 ");
        System.out.println("-----------------------------------------------");
        for (int li = 0; li < DIM; li++) {
            System.out.print("|");
            for (int co = 0; co < DIM; co++) {  
                Point pt = new Point(li,co);
                Case caseCourante = grille.getCase(pt);
                ViewCase viewCase;
                if (caseCourante.getChar() != ' ') {
                    viewCase = new ViewSimple(caseCourante.getChar());
                }
                else if (caseCourante instanceof Double) {
                    viewCase = new ViewDouble(caseCourante.getChar());
                }
                else if (caseCourante instanceof Triple) {
                    viewCase = new ViewTriple(caseCourante.getChar());
                }
                else if (caseCourante instanceof MotDouble) {
                    viewCase = new ViewMotDouble(caseCourante.getChar());
                } 
                else if (caseCourante instanceof MotTriple) {
                    viewCase = new ViewMotTriple(caseCourante.getChar());
                } 
                else
                    viewCase = new ViewSimple(caseCourante.getChar());
                System.out.print(viewCase);
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
    
        
//    public char choisirLettre() {
//        boolean entreeOK = false;
//        char ch = ' ';
//        do {
//            System.out.print("choisir lettre : ");
//            try {
//                ch = scanner.next().charAt(0);
//                if (ctrl.verifierLettre(ch)) 
//                    entreeOK = true;
//                else
//                    System.out.println("***vous ne possédez pas cette lettre sur votre chevalet***");
// 
//            } catch (Exception e) {
//                System.out.print("***veuillez entrer une lettre***");
//                scanner.next();    
//            }
//        } while (!entreeOK);
//        
//        return ch;
//    }
   
//    
//    public Point choisirPosition() {
//        boolean entreeOK = false;
//        Point pt = new Point();
//        do {
//            System.out.println("choisir position (co li) : ");
//            try {
//                pt.x = Integer.parseInt(scanner.next());
//                pt.y = Integer.parseInt(scanner.next());
//                entreeOK = true;
//                if (ctrl.verifierPosition(pt)) 
//                    entreeOK = true;
//                else
//                    System.out.println("vous ne possédez pas cette lettre sur votre chevalet");
// 
//            } catch (Exception e) {
//                System.out.println("***veuillez entrer des int***");
//                System.out.println("choisir position (co li) : ");
//                scanner.next();    
//            }
//        } while (!entreeOK);
//        
//        return pt;
//    }
    
//    public Point choisirPosition() {
//        
//        Point pt = new Point(); 
//        System.out.println("choisir position (li co) : ");
//        scanner.useDelimiter(" ");
//        
//        pt.x = scanner.nextInt();
//        pt.y = scanner.nextInt();
//        
//        while (!positionValide(pt)) {
//            System.out.println("mauvaise position");
//            pt.x = scanner.nextInt();
//            pt.y = scanner.nextInt();   
//        } 
//        return pt;      
//    }
 
   

//    @Override
//    public void update(Observable o, Object arg) {
//        afficherGrille();
//        afficherChevalet();
//        
//    }

    
}