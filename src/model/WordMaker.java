package model;

import controllerGUI.ControllerGUI;
import java.util.List;

 /**
 *
 * @author 0404ragrau
 */
public class WordMaker {

    private final Grille grille;
    private ControllerGUI ctrl;
    //    private List<Jeton> mot = new ArrayList<>();
    private int x, y;
    private int lastX, lastY;

    public WordMaker(List<Jeton> lsJetons, ControllerGUI ctrl) {

        this.grille = ctrl.getGrille();
        getPosDebutMot(lsJetons);
        getPosFinMot(lsJetons);
        buildMot(x,y,lastX,lastY,lsJetons);
        
        

    }

    public void getPosDebutMot(List<Jeton> lsJetons) {

        for (Jeton j : lsJetons) {
            if (grille.watchUp(j)) {
                x = j.getX();
                y = grille.getLastYUp(j);

            } else if (grille.watchRight(j)) {
                x = grille.getLastXLeft(j);
                y = j.getY();
                
            } else {
                x = j.getX();
                y = j.getY();
            }
        }
    }
    
    public void getPosFinMot(List<Jeton> lsJetons) {

        for (Jeton j : lsJetons) {
            if (grille.watchUp(j) || grille.watchDown(j)) {
                Jeton lastJeton = lsJetons.get(lsJetons.size());
                lastX = lastJeton.getX();
                lastY = lastJeton.getY();
            } else {
                lastX = grille.getLastXRight(j);
                lastY = grille.getLastYDown(j);
            }
       }
    }
    
    
    public void buildMot(int x, int y, int lastX, int lastY, List<Jeton> lsJetons) {
        
        
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
