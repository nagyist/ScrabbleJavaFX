package view;

import controller.ControllerImpl;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import model.Chevalet;
import model.Grille;
import static model.Grille.DIM;

/**
 *
 * @author 0404ragrau
 */
public class View implements Observer {
    
    
    private final ControllerImpl ctrl;
    private final Scanner scanner = new Scanner(System.in);
    public Chevalet chev;
    public Grille grille;
    private char c;

    
    
    public View(ControllerImpl ctrl) {
        this.ctrl = ctrl;
        this.chev = ctrl.getChevalet();
        this.grille = ctrl.getGrille();
    }

    
    public void affMsg(String msg) {
        System.out.println(msg);
    }

   
    public void afficherGrille() {
        
        System.out.println("-----------------------------------------------");
        for (int li = 0; li < DIM; li++) {
            System.out.print("|");
            for (int co = 0; co < DIM; co++) {  
                System.out.print(grille.getCase(li,co));  
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
    
        
    public char choisirLettre() {
        
        System.out.println("choisir lettre : ");
        c = scanner.next().charAt(0);
        
        ctrl.verifierLettre(c);
        return c;

    }

    public void choisirPosition() {
         
        System.out.println("choisir position (li, co) : ");
        
        int li = scanner.nextInt();
        int co = scanner.nextInt();
        
        while (li < 0 || li > 14 || co < 0 || co > 14) {
            System.out.println("mauvaise position");
            li = scanner.nextInt();
            co = scanner.nextInt();   
        }
        
        ctrl.positionnerLettre(li, co, c);
      
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
        
        choisirLettre();
        choisirPosition();          

    }

    
}