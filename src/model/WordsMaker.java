package model;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.List;

 /**
 *
 * @author 0404ragrau
 */
public class WordsMaker {

    private final Grille grille;
    private final ControllerGUI ctrl;
//    private final List<Jeton> lettresPourMot = new ArrayList<>();
    private final List<Mot> lsMots = new ArrayList<>();
//    private Mot motPrincipal;
//    private Mot autreMot;
//    private Mot temp;

    

    public WordsMaker(ControllerGUI ctrl, Grille grille) {
        this.ctrl = ctrl;
        this.grille = ctrl.getGrille();
    }
    
    
    public List<Mot> prepareMots(List<Jeton> lsJetons) {
        lsMots.clear();
        isVerti(lsJetons);
        int d = getDeb(lsJetons);
        int f = getFin(lsJetons);
        int fixedPos = getFixedPos(lsJetons);
        construct(d, f, fixedPos, lsJetons);
        checkAutresMots(lsJetons);
//        System.out.println("nbMots : " + lsMots.size());
//        for (Mot m : lsMots) {
//            System.out.println("size : " + m.si());
//            System.out.println(m.getMotStr());
//        }
        return lsMots;
    }
    
    public List<Mot> getMots() {
        return lsMots;
    }
    
    public boolean isVerti(List<Jeton> lsJetons) {
        Jeton j = lsJetons.get(0);
        if (lsJetons.size() > 1)
            return !(lsJetons.get(0).getY() == lsJetons.get(lsJetons.size()-1).getY());
        else
            return grille.watchDown(j) || grille.watchUp(j);     
    }
    
    public int getDeb(List<Jeton> lsJetons) {
        System.out.println("----");
        Jeton j = lsJetons.get(0);
        int deb;
        if (isVerti(lsJetons)) { // x ne varie pas
            if (grille.watchUp(j))
                deb = grille.getLastYUp(j);
            else
                deb = j.getY();
            
        } else { // y ne varie pas
            if (grille.watchLeft(j))
                deb = grille.getLastXLeft(j);
            else
                deb = j.getX();
        }    
        System.out.println("deb : " + deb);
        return deb;        
    }
    
    public int getFin(List<Jeton> lsJetons) {
        Jeton j = lsJetons.get(lsJetons.size()-1);
        System.out.println(j.getStr());
        System.out.println(isVerti(lsJetons));
        int fin;
        if (isVerti(lsJetons)) { // x ne varie pas
            if (grille.watchDown(j))
                fin = grille.getLastYDown(j);
            else
                fin = j.getY();
        } else { // y ne varie pas
            if (grille.watchRight(j)) {
                fin = grille.getLastXRight(j);
                System.out.println("test");
            }
                
            else
                fin = j.getX();
        }
        System.out.println("fin : " + fin);
        return fin;
    }
    
    public int getFixedPos(List<Jeton> lsJetons) {
        Jeton j = lsJetons.get(0);
        if (isVerti(lsJetons))
            return j.getX();
        else 
            return j.getY();

    }
    
    public void construct(int deb, int fin, int fixedPos, List<Jeton> lsJetons) {
        Jeton jDeb;
        Jeton jFin;
        Mot m = new Mot();
        
        System.out.println(deb + " " + fixedPos + " " + fin);
        
        if (isVerti(lsJetons)) {
            if (grille.caseJouee(fixedPos, deb))
                jDeb = grille.getJetonAt(fixedPos, deb);
            else
                jDeb = getJetonFromList(fixedPos, deb, lsJetons);
            
            if (grille.caseJouee(fixedPos, fin))
                jFin = grille.getJetonAt(fixedPos, fin);
            else
                jFin = getJetonFromList(fixedPos, fin, lsJetons);
            
        } else {
            if (grille.caseJouee(deb, fixedPos))
                jDeb = grille.getJetonAt(deb, fixedPos);
            else
                jDeb = getJetonFromList(deb, fixedPos, lsJetons);
            
            if (grille.caseJouee(fin, fixedPos))
                jFin = grille.getJetonAt(fin, fixedPos);
            else
                jFin = getJetonFromList(fin, fixedPos, lsJetons);
        }

        
        for (int i = deb; i <= fin ; ++i) {
            
            if (lsMots.isEmpty()) {
               if (isVerti(lsJetons)) {
                    if (grille.caseJouee(fixedPos, i))
                        m.add(grille.getJetonAt(fixedPos, i));
                    else
                        m.add(getJetonFromList(fixedPos, i, lsJetons));
                } else {
                    if (grille.caseJouee(i, fixedPos))
                        m.add(grille.getJetonAt(i, fixedPos));
                    else
                        m.add(getJetonFromList(i, fixedPos, lsJetons));
                    } 
            } else {
                if (isVerti(lsJetons)) {
                    if (grille.caseJouee(i, fixedPos))
                        m.add(grille.getJetonAt(i, fixedPos));
                    else
                        m.add(getJetonFromList(i, fixedPos, lsJetons));
                } else {
                    if (grille.caseJouee(fixedPos, i))
                        m.add(grille.getJetonAt(fixedPos, i));
                    else
                        m.add(getJetonFromList(fixedPos, i, lsJetons));
                }
            }
            
        }
        m.calcPoints(grille);
        lsMots.add(m);

        
    }
    
    
    private void checkAutresMots(List<Jeton> lsJetons) {
        
        int deb = -1;
        int fin = -1;
        int fixedPos = -1;
        
        
        if (isVerti(lsJetons)) { // regarder à gauche et à droite // x ne varie pas
            System.out.println("2e mot horiz");
               for (Jeton j : lsJetons) {
                    if (grille.watchLeft(j)) {
                        deb = grille.getLastXLeft(j);
                        fixedPos = j.getY();
                        if (grille.watchRight(j)) {
                            fin = grille.getLastXRight(j);
                        } else {
                            fin = j.getX();
                        }
                        construct(deb, fin, fixedPos, lsJetons);
                    }   
                } 
            } else { // regarder en haut et en bas
            System.out.println("2e mot verti");
                for (Jeton j : lsJetons) {
                    if (grille.watchUp(j)) {
                        deb = grille.getLastYUp(j);
                        fixedPos = j.getX();
                        if (grille.watchDown(j)) {
                            fin = grille.getLastYDown(j);
                        } else {
                            fin = j.getY();
                        }
                        construct(deb, fin, fixedPos, lsJetons);
                    }   
                }
            }
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
    
//    public void getMots(List<Jeton> lsJetons) {
//        lsMots.clear();
//        construireMots(lsJetons);
//    }
//    
//    
//    public void construireMots(List<Jeton> lsJetons) {
//
//        int xDeb = -1;
//        int yDeb = -1;
//        int xFin = -1;
//        int yFin = -1;
//
//        if (lsMots.isEmpty()) {
//
//            temp = new Mot();
//            temp.setJDeb(lsJetons.get(0));
//            temp.setJFin(lsJetons.get(lsJetons.size()-1));
//            setAlign(lsJetons);
//
//            for (Jeton j : lsJetons) {
//
//                if (temp.isVerti()) {
//                    if (grille.watchUp(j)) {
//                        yDeb = grille.getLastYUp(j);
//                        xDeb = j.getX();
//                        yFin = grille.getLastYDown(j);
//                        xFin = j.getX();
//                    } else
//                        xDeb = j.getX();
//                        yDeb = j.getY();
//                    
//                    
//                } else {
//                    
//                    xDeb = grille.getLastXLeft(j);
//                    yDeb = j.getY();
//                    xFin = grille.getLastXRight(j);
//                    yFin = j.getY();
//                }
//            }
//
//        } else {
//
//            temp = new Mot();
//
//            for (Jeton j : lsJetons) {
//
//                if (lsMots.get(0).isVerti()) {
//                    //regarder à gauche et à droite // watchHoriz
//
//                    if (grille.watchLeft(j)) {
//                        xDeb = grille.getLastXLeft(j);
//                        yDeb = j.getY();
//
//                        xFin = j.getX();
//                        yFin = j.getY();
//
//                    } else if (grille.watchRight(j)) {
//                        xDeb = j.getX();
//                        yDeb = j.getY();
//
//                        yFin = j.getY();
//                        xFin = grille.getLastXRight(j);
//
//                        //xDeb = getXLeft
//                        //yDeb = j.getY()
//                        //xFin =
//                        //yFin =
////                        setJDeb(xDeb, yDeb, lsJetons);
////                        setJFin(xFin, yFin, lsJetons);
////                        construct(lsJetons, temp.getJDeb(), temp.getJFin());
////                        lsMots.add(temp);
//                    } else {
//                        //regarder en haut et en bas // watchVerti
//
//                        if (grille.watchUp(j)) {
//                            xDeb = j.getX();
//                            yDeb = grille.getLastYUp(j);
//
//                            xFin = j.getX();
//                            yFin = j.getY();
//
//                        } else if (grille.watchDown(j)) {
//                            xDeb = j.getX();
//                            yDeb = j.getY();
//
//                            xFin = j.getX();
//                            yFin = grille.getLastYDown(j);
//
//                            //xDeb = 
//                            //yDeb = 
//                            //xFin =
//                            //yFin =
////                            setJDeb(xDeb, yDeb, lsJetons);
////                            setJFin(xFin, yFin, lsJetons);
////                            construct(lsJetons, temp.getJDeb(), temp.getJFin());
////                            lsMots.add(temp);
//                        }
//                    }
//                }
//            }
//
//        }
//
//        setJDeb(xDeb, yDeb, lsJetons);
//        setJFin(xFin, yFin, lsJetons);
//        System.out.println("jDeb : " + temp.getXDeb() + "/" + temp.getYDeb());
//        System.out.println("jFin : " + temp.getXFin() + "/" + temp.getYFin());
//        construct(lsJetons, temp.getJDeb(), temp.getJFin());
//        lsMots.add(temp);
//
//    }
//    
//    public void construct(List<Jeton> lsJetons, Jeton jDeb, Jeton jFin) {
//
//        int xDeb = jDeb.getX();
//        int yDeb = jDeb.getY();
//        int xFin = jFin.getX();
//        int yFin = jFin.getY();
//        Jeton j = null;
//
//        do {
//            j = grille.getJetonAt(xDeb, yDeb);
//            temp.add(j);
//            
//            if (lsMots.isEmpty()) {
//                if (temp.isVerti()) {
//                   yDeb = goNext(lsJetons, xDeb, yDeb, jFin); 
//                } else {
//                    xDeb = goNext(lsJetons, xDeb, yDeb, jFin);
//                }
//            } else {
//                if (lsMots.get(0).isVerti()) {
//                xDeb = goNext(lsJetons, xDeb, yDeb, jFin);
//                } else {
//                    yDeb = goNext(lsJetons, xDeb, yDeb, jFin);
//                    }
//                }   
//            } while (j != jFin);
//            j = grille.getJetonAt(xDeb, yDeb);
//            temp.add(j);
//
//    }
//
//    
//    public int goNext(List<Jeton> lsJetons, int xDeb, int yDeb, Jeton jFin) {
//
//        if (lsMots.isEmpty()) {
//            if (temp.isVerti()) {
//                yDeb += 1;
//                return yDeb;
//            } else {
//                xDeb += 1;
//                return xDeb;
//            }
//        } else {
//            if (lsMots.get(0).isVerti()) {
//                xDeb += 1;
//                return xDeb;
//            } else {
//                yDeb += 1;
//                return yDeb;
//            }
//        }
//
//    }
//
//
//    
//
//    
//    public void setAlign(List<Jeton> lsJetons) {
//        temp.setAlign();
//    }
//    
//    public void setJFin(int x, int y, List<Jeton> lsJetons) {
//        if (grille.caseJouee(x, y))
//            temp.setJFin(grille.getJetonAt(x, y));
//        else
//            temp.setJFin(getJetonFromList(x,y,lsJetons));
//    }
//    
//    public void setJDeb(int x, int y, List<Jeton> lsJetons) {
//        if (grille.caseJouee(x, y))
//            temp.setJDeb(grille.getJetonAt(x, y));
//        else
//            temp.setJDeb(getJetonFromList(x,y,lsJetons));
//    }
//    
//    public Mot gMot(Mot mot) {
//        return mot;
//    }
//    
//    public void affMot(Mot mot) {
//        System.out.println(mot.getString());
//    }
//    
//     
//    
    public String getTotalPoints() {
        int tot = 0;
        for (Mot m : lsMots)
            tot += m.getPointsMot();
        return ""+tot;
    }

    public String affListMots() {

        StringBuilder sb = new StringBuilder();

        for (Mot m : lsMots) {
            sb.append(m.getString().toUpperCase());
        }
        
        sb.append("\n");
        sb.append("TOTAL : ");
        sb.append(getTotalPoints());
        sb.append(" points.");

        return sb.toString();
    }
//
//    
//        
//    public String afficheMots() {
//        StringBuilder sb = new StringBuilder();
//        
//        for (Mot m : lsMots) {
//            sb.append(m.getString());
//        }
//
//        return sb.toString().toUpperCase();
//    }
//    
//    public void affMotStr(Mot mot) {
//        System.out.println("Mot : " + mot.getString().toUpperCase());
//
//    }
//   
//    
}
  
