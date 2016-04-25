package model;

import java.util.ArrayList;
import java.util.List;

 /**
 *
 * @author 0404ragrau
 */
public final class WordMaker {

    private final Grille grille;
    private final List<Jeton> mot = new ArrayList<>();
    private int x, y;
    private int lastX, lastY;
    private final List<Mot> tour = new ArrayList<>();

    public WordMaker(Grille grille) {
        this.grille = grille;  
    }
    
    public void makeWord(List<Jeton> lsJetons) {
        getPosDebutMot(lsJetons);
        getPosFinMot(lsJetons);
        buildMot(lsJetons);
        System.out.print("mot : ");
        System.out.println(getMot());
    }
    
    public String getMot() {
        return afficheStr(mot);
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
    
//    public List<Mot> buildMots() {
//        
//        return tour;
//    }
    
    
    public List<Jeton> buildAutreMot(List<Jeton> lsJetons) {
        
        mot.clear();
    
        if (!motIsVertical()) {
            if (grille.watchUp(grille.getJetonAt(x, y))) {
                // y = getLastYUp();
                // x = x;
                // lastX = x;
                // lastY = getLastYDown();
                
            } else if (grille.watchDown(grille.getJetonAt(x, y))) {
                // y = getLastYDown(); 
                // x = x;
                // lastX = x;
                // lastY = getLastYUp();
            }

        } else if (motIsVertical()) {
            if (grille.watchLeft(grille.getJetonAt(x, y))) {
                // x = getLastXLeft();
                // y = y;
                // lastY = y;
                // lastX = getLastXRight();
            } else if (grille.watchRight(grille.getJetonAt(x, y))) {
                // x = getLastXRight(); 
                // y = y;
                // lastY = y;
                // lastX = getLastXLeft();
            }
  
            buildMot(lsJetons);
        } 

        return mot;
    }
    
    public List<Jeton> buildMot(List<Jeton> lsJetons) {
        
        mot.clear();
        
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
            
//            } 
        } while (jetonNext(x,y));
        
        
        
        System.out.println(x + "," + y);
                System.out.println("coucou");
        
//        Mot m = new Mot(mot);
//        tour.add(m);
//        return m;
        
        return mot;

       
    }
    
    public String afficheMot() {
        String str = "";
        for (Jeton j : mot)
            str = str+ j.getChar();
        
        return str.toUpperCase();
    }
    
    public String afficheStr(List<Jeton> mot) {
        String str = "";
        for (Jeton j : mot)
            str = str+ j.getChar();
        
        return str.toUpperCase();
    }
    
    
}
  
