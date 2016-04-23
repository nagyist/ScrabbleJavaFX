package model;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.List;

 /**
 *
 * @author 0404ragrau
 */
public class WordMaker {

    private final Grille grille;
    private ControllerGUI ctrl;
    private final List<Jeton> mot = new ArrayList<>();
    private int x, y;
    private int lastX, lastY;
    private boolean wordIsVertical;

    public WordMaker(List<Jeton> lsJetons, Grille grille) {
        this.grille = grille;
        getPosDebutMot(lsJetons);
        getPosFinMot(lsJetons);
        buildMot(lsJetons);
    }

    public void getPosDebutMot(List<Jeton> lsJetons) {
        Jeton j = lsJetons.get(0);
        
//        for (Jeton j : lsJetons) {
            if (grille.watchUp(j)) {
                x = j.getX();
                y = grille.getLastYUp(j);
            } else if (grille.watchLeft(j)) {
                x = grille.getLastXLeft(j);
                y = j.getY();
             } else {
                x = j.getX();
                y = j.getY();
            }
            System.out.println("pos debut :");
            System.out.println(x + "/"+ y);
//        }
    }
    
    public void getPosFinMot(List<Jeton> lsJetons) {
        Jeton j = lsJetons.get(0);
        Jeton lastJeton = lsJetons.get(lsJetons.size()-1);
        
//        for (Jeton j : lsJetons) {
            if (grille.watchRight(lastJeton) || grille.watchDown(lastJeton)) {
//                Jeton lastJeton = lsJetons.get(lsJetons.size());
                lastX = grille.getLastXRight(lastJeton);
                lastY = grille.getLastYDown(lastJeton);  
                System.out.println("right or down");
            } else {
                lastX = lastJeton.getX();
                lastY = lastJeton.getY();
            }
//       }
    }
    
    
    private Jeton getJetonFromList(int x, int y, List<Jeton> lsJetons) {
        Jeton jj = null;
        for (Jeton j : lsJetons) {
            if (j.getX() == x && j.getY() == y) {
                jj = j;
            }              
        }
        return jj;
    }
    
    private boolean jetonNext(int x, int y) {
        return (x <= lastX && y <= lastY);
    }
    
    private boolean motIsVertical() {
        return x == lastX;
    }
    
    private void goNext() {
        
        if (motIsVertical()) {
            x = x;
            y = y+1;
        }
        else {
            x=x+1;
            y=y;
        }
    }
    
    
    public List<Jeton> buildMot(List<Jeton> lsJetons) {
        
        do  {
            if (grille.caseJouee(x, y)) {
                mot.add(grille.getJetonAt(x, y));
                System.out.println("test1");
                
            } else {
                mot.add(getJetonFromList(x, y,lsJetons));
                System.out.println("test");
            }
            System.out.println("hihi");
            goNext();
            
        } while (jetonNext(x,y));
        System.out.println(x + "," + y);
                System.out.println("coucou");

        return mot;
       
    }
    
    public void afficheMot() {
        System.out.println("Mot a tester :");
        for (Jeton j : mot)
            System.out.println(j.getChar());
    }
    
    public String afficheStr() {
        String str = "";
        for (Jeton j : mot)
            str = str+ " " + j.getChar();
        
        return str.toUpperCase();
    }
                
                
            //j1 -> if touchLeftGrille or touchUpGrille
            // get jeton + aller en gauche/aller en haut sur la grille
            
            //j1 -> if touchDownGrille or touchRightGrille
            // get jeton + aller en droite/aller en haut sur la grille
            
            //j1 -> touchGrille && touchNextlisteJetons
            // 
            
            //j1 -> if touchNextlisteJetons
            // get jeton + avancer dans la liste
                    
            
            
//            if (j.toucheNextJeton())
                
                
//            grille.watchAround(j);
            // jeton 1 : regarder autour (il touche d'office soit la grille soit la lsJetons)
            // si jeton 2 est a coté : touche un de la liste -> add + avance
            // sinon -> grille.watchAround(j) : oui -> add + avance
            //                                  non -> stop
             
               
        }

//    }
    
//    public boolean watchAround(Jeton j) {
////            return watch(j);
//        }
    
//    
//    
//}
