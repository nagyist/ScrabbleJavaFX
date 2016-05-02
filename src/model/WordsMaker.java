package model;

import java.util.ArrayList;
import java.util.List;

 /**
 *
 * @author 0404ragrau
 */
public class WordsMaker {

    private final Grille grille;
    private final List<Jeton> lettresPourMot = new ArrayList<>();
    private final List<Mot> lsMots = new ArrayList<>();
//    private int x, y;
//    private int otherX = -1;
//    private int otherY = -1;
//    private int lastOtherX, lastOtherY;
//    private int lastX, lastY;
//    private int xtemp = x;
//    private int ytemp = y;
    private Mot motPrincipal;
    private Mot autreMot;
    private Mot temp;
//    int xDeb, yDeb;

    public WordsMaker(Grille grille) {
        
//        motPrincipal = new Mot();
//        autreMot = new Mot();
//        temp = new Mot();
//        x = -1;
//        y = -1;
//        lastOtherX = -1;
//        lastOtherY = -1;
//        lastX = -1;
//        lastY = -1;
        this.grille = grille; 
    }
    
    public void makeFirstWord(List<Jeton> lsJetons) {
//        lsMots.clear();
        
        
//        System.out.println("first word");
//        getPosDebutMot(lsJetons);
//        getPosFinMot(lsJetons);
//        buildMot(lsJetons);
//        System.out.print("mot : ");
//        System.out.println(getMot());
    }
    
//    public void makeOtherWord(List<Jeton> lsJetons) {
//        System.out.println("another word");
//        getPosDebutMot(lsJetons);
//        getPosFinMot(lsJetons);
//        buildMot(lsJetons);
//    }
//    
//
//    public boolean othersWords(List<Jeton> lsJetons) {
//
//        motPrincipal = lsMots.get(0);
//        
//        System.out.println("mot verti? " + motIsVertical());
//
//        for (Jeton j : lsJetons) {
//            if (motIsVertical()) {
//                if (grille.watchLeft(j) || grille.watchRight(j)) {
//
//                    return true;
//                }
//            } else {
//                if (grille.watchDown(j) || grille.watchUp(j)) {
//
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    
//    public void makeWords(List<Jeton> lsJetons) {  
//        makeFirstWord(lsJetons);
//        System.out.println("others words? "+othersWords(lsJetons));
//        if (othersWords(lsJetons))
//            makeOtherWord(lsJetons);
//    }
    
    
//    public String getMot(Mot m) {
//        return afficheStr(m);
//    }
    
    public List<Mot> getMots() {
        return lsMots;
    }
    
    public String affListMots() {
        String str = "";
        for (Mot m : lsMots) {
//            System.out.println(m.size() + "lettre(s)");
            str += m.getString();
        }
        return str.toUpperCase();
    }
   
    
    public void makeWords(List<Jeton> lsJetons) {
        lsMots.clear();
        makeAWord(lsJetons);
        System.out.println("others words? " + othersWords(lsJetons) );
        
        if (othersWords(lsJetons))
            makeAWord(lsJetons);
        System.out.println("nb mots --->" + lsMots.size());
    }
    
    public void makeAWord(List<Jeton> lsJetons) {
        
        lettresPourMot.clear();
        temp = new Mot();
        motPrincipal = new Mot();
        autreMot = new Mot();
        
              
        
        System.out.println("-");
        temp.setJDeb(getJDebut(lsJetons));
        temp.setJFin(getJFin(lsJetons));
        setAlign(lsJetons);
        constructWord(lsJetons);    
        System.out.println("--");
        
//        System.out.println("deb : " + deb.getChar());
//        System.out.println("fin : " + fin.getChar());
        
        
        if (lsMots.isEmpty()) {
            motPrincipal = temp;
            lsMots.add(motPrincipal);
        } else {
            autreMot = temp;
            lsMots.add(autreMot);
        }
            
        
        
        motPrincipal.affAlign();
//        affMotStr(motPrincipal);
        
    }
    
    public boolean othersWords(List<Jeton> lsJetons) {
        
        for (Jeton j : lsJetons) {
            if (motPrincipal.isVerti()) {
                if (grille.watchLeft(j) || grille.watchRight(j))
                   return true;
            } else {
                if (grille.watchDown(j) || grille.watchUp(j))
                   return true;
            }       
        }
        return false;
    }
    
    
    public Jeton getJDebut(List<Jeton> lsJetons) {
        int xDeb;
        int yDeb;
        Jeton jDeb = null;

        // another word
        //...
        // first word
        // if mot verti : watch up(Y) else watch left(X) --> get last
        // else temp
        if (!lsMots.isEmpty()) {

            temp.setJDeb(lsJetons.get(0));
            
            for (Jeton j : lsJetons) {
                if (motPrincipal.isVerti()) {
                    if (grille.watchLeft(j)) {
                        xDeb = grille.getLastXLeft(j);
                        yDeb = j.getY();
                        setJDeb(xDeb, yDeb, lsJetons);
                        System.out.println("deb 2nd mot horiz");
                    } else if (grille.watchRight(j)) {
                        xDeb = j.getX();
                        yDeb = j.getY();
                        setJDeb(xDeb, yDeb, lsJetons);
                    }
                } else {
                    if (grille.watchUp(j)) {
                        xDeb = j.getX();
                        yDeb = grille.getLastYUp(j);
                        setJDeb(xDeb, yDeb, lsJetons);
                        System.out.println("deb 2nd mot vert");
                    } else if (grille.watchDown(j)) {
                        xDeb = j.getX();
                        yDeb = j.getY();
                        setJDeb(xDeb, yDeb, lsJetons);
                    }
                        
                            
                }
                    
            }
            
            
            
            
        } else {

            temp.setJDeb(lsJetons.get(0));
            jDeb = temp.getJDeb();
            System.out.println("jdeb: " + jDeb.getX() + "/" + jDeb.getY());

            if (grille.watchUp(jDeb)) {
                xDeb = jDeb.getX();
                yDeb = grille.getLastYUp(jDeb);
                System.out.println("ii");
                setJDeb(xDeb, yDeb, lsJetons);
            } else if (grille.watchLeft(jDeb)) {
                xDeb = grille.getLastXLeft(jDeb);
                yDeb = jDeb.getY();
                setJDeb(xDeb, yDeb, lsJetons);
            } else {
                xDeb = jDeb.getX();
                yDeb = jDeb.getY();
            }

            System.out.println("xdeb/ydeb: " + xDeb + "/" + yDeb);
            System.out.println("---> " + temp.getXDeb() + "/" + temp.getYDeb());
            System.out.println(temp.getXDeb());
            System.out.println(temp.getYDeb());
        }
        System.out.println("** : " + temp.getJDeb().getChar());
        return temp.getJDeb();
    }
    
    public Jeton getJFin(List<Jeton> lsJetons) {
        int xFin = -1;
        int yFin = -1;
        Jeton jFin;
        // another word
        //...

        // if mot verti watch down(Y) else watch right(X) --> get last
        // else last from temp
        if (!lsMots.isEmpty()) {
            
//            Jeton j = grille.getJetonAt(temp.getXDeb(), temp.getYDeb());
            
            for (Jeton j : lsJetons) {
                if (motPrincipal.isVerti()) {
                    if (grille.watchRight(j)) {
                        yFin = j.getY();
                        xFin = grille.getLastXRight(j);
                        System.out.println("fin 2nd mot horiz");
                    } else if (grille.watchLeft(j)) {
                        xFin = j.getX();
                        yFin = j.getY();
                        System.out.println("fin 2nd mot verti");
                    }
                } else {
                    if (grille.watchUp(j)) {
                        xFin = j.getX();
                        yFin = j.getY();
                        System.out.println("fin 2nd mot verti * * * *");
                        System.out.println(xFin + "/" + yFin);
                    }
                    else if (grille.watchDown(j)) {
                        xFin = j.getX();
                        yFin = grille.getLastYDown(j);
                        System.out.println("fin 2nd mot verti");
                    }
                }
            }
            setJFin(xFin, yFin, lsJetons);
            
            
            
            
            
            
        } else {

            temp.setJFin(lsJetons.get(lsJetons.size() - 1));
            jFin = temp.getJFin();
            System.out.println("jFin : " + jFin.getX() + "/" + jFin.getY());
            System.out.println("char fin : " + jFin.getChar());

            System.out.println("");

            if (grille.watchRight(jFin)) {
                xFin = grille.getLastXRight(jFin);
                yFin = jFin.getY();
                setJFin(xFin, yFin, lsJetons);
                System.out.println("t");
            } else if (grille.watchDown(jFin)) {
                xFin = jFin.getX();
                yFin = grille.getLastYDown(jFin);
                setJFin(xFin, yFin, lsJetons);
                System.out.println("te");
            }
//        else {
//            xFin = jFin.getX();
//            yFin = jFin.getY();
//        }
//        System.out.println("xfin/yfin: " + xFin +"/"+ yFin);
        }
        
        System.out.println("jFin : ");
        System.out.println(temp.getXFin());
        System.out.println(temp.getYFin());
        return temp.getJFin();
    }
    
    public void setAlign(List<Jeton> lsJetons) {
        temp.setAlign();
    }
    
    public void setJFin(int x, int y, List<Jeton> lsJetons) {
        if (grille.caseJouee(x, y))
            temp.setJFin(grille.getJetonAt(x, y));
        else
            temp.setJFin(getJetonFromList(x,y,lsJetons));
    }
    
    public void setJDeb(int x, int y, List<Jeton> lsJetons) {
        if (grille.caseJouee(x, y))
            temp.setJDeb(grille.getJetonAt(x, y));
        else
            temp.setJDeb(getJetonFromList(x,y,lsJetons));
    }
    
    public Mot gMot(Mot mot) {
        return mot;
    }
    
    public void affMot(Mot mot) {
        System.out.println(mot.getString());
    }
    
    public void constructWord(List<Jeton> lsJetons) {

//        motPrincipal.affAlign();
        System.out.println("is verti : "+ temp.isVerti());
        System.out.println("size : "+ temp.size());

        int xDeb = temp.getXDeb();
        int yDeb = temp.getYDeb();
        int xFin = temp.getXFin();
        int yFin = temp.getYFin();
        
        
        System.out.println(xDeb + "-" + yDeb);
        System.out.println(xFin + "-" + yFin);

        if (!lsMots.isEmpty()) {
            
            System.out.println("construct 2e mot");

            if (motPrincipal.isVerti()) {
                for (int i = xDeb; i <= xFin; ++i) {

                    if (grille.caseJouee(i, yDeb)) {
                        lettresPourMot.add(grille.getJetonAt(i, yDeb));
                    } else {
                        lettresPourMot.add(getJetonFromList(i, yDeb,lsJetons));
                    }

                }
            } else {

                for (int i = yDeb; i <= yFin; ++i) {

                    if (grille.caseJouee(xDeb, i)) {
                        lettresPourMot.add(grille.getJetonAt(xDeb, i));
                    } else {
                        lettresPourMot.add(getJetonFromList(xDeb, i, lsJetons));
                    }
                }
            }
            
            System.out.println("2e mot : ");
            for (Jeton j : lettresPourMot)
                System.out.println(j);



            
        } else {

            if (temp.isVerti()) {
                for (int i = yDeb; i <= yFin; ++i) {

                    if (grille.caseJouee(xDeb, i)) {
                        lettresPourMot.add(grille.getJetonAt(xDeb, i));
                    } else {
                        lettresPourMot.add(getJetonFromList(xDeb, i, lsJetons));
                    }
                    System.out.println("mot verti");
                    System.out.println("xDeb, yDeb : " + xDeb + ", " + i);
                }
            } else {
                for (int i = xDeb; i <= xFin; ++i) {

                    if (grille.caseJouee(i, yDeb)) {
                        lettresPourMot.add(grille.getJetonAt(i, yDeb));
                    } else {
                        lettresPourMot.add(getJetonFromList(i, yDeb, lsJetons));
                    }
                    System.out.println("mot horiz");
                    System.out.println("xDeb, yDeb : " + i + ", " + yDeb);

                }
            }

        }
        
        
        
        
        System.out.println("size liste :" + lettresPourMot.size());
//        for (Jeton j : lettresPourMot)
//            System.out.println(j.getChar());


        temp.fill(lettresPourMot);

        
    }
    
//    private void next(Mot mot) {
//        if (mot.isVerti())
//            xDeb = xDeb+1;
//        else
//            yDeb = yDeb+1;                   
//    }
//    
//    private boolean hasNext(int xFin, int yFin) {
//        return xDeb <= xFin && yDeb <= yFin;
//    }
    

//    public void getPosDebutMot(List<Jeton> lsJetons) {
//        
//        System.out.println("debut mot ");
//        if (!lsMots.isEmpty()) {
////            Jeton j = lsJetons.get(0);
//            
//            for (Jeton j : lsJetons) {
//                if (motIsVertical()) {
//                    if (grille.watchLeft(j)) {
//                        otherX = grille.getLastXLeft(j);
//                        otherY = j.getY();
//                        System.out.println("deb 2nd mot horiz");
//                        System.out.println(otherX + ".." + otherY);
//                    }       
//                } else {
//                    if (grille.watchUp(j)) {
//                        otherX = j.getX();
//                        otherY = grille.getLastYUp(j);
//                        System.out.println("deb 2nd mot vert");
//                        System.out.println(otherX + ".." + otherY);
//
//                    }
//                }  
//            }
//            
//            
//        } else {
//        
//        
//            Jeton j = lsJetons.get(0);
////        for (Jeton j : lsJetons) {
//            if (grille.watchUp(j)) {
//                
//                
//                x = j.getX();
//                y = grille.getLastYUp(j);
//            } else if (grille.watchLeft(j)) {
//                x = grille.getLastXLeft(j);
//                y = j.getY();
//             } else {
//                x = j.getX();
//                y = j.getY();
//            }
//            System.out.println("pos debut :");
//            System.out.println(x + "/"+ y);
////        }
//        }
//    }
//    
//    
//    
//    
//    public void getPosFinMot(List<Jeton> lsJetons) {
//        
//        Jeton lastJeton = lsJetons.get(lsJetons.size()-1);
//        
//        
//        System.out.println("otherz XY");
//        System.out.println(otherX + " ! "+ otherY);
//        
//        if (!lsMots.isEmpty()) {
//            Jeton j = grille.getJetonAt(otherX, otherY);
//            
//            
//            
//            
//            
//            // 
//            
//                if (motIsVertical()) {
//                    if (grille.watchRight(j)) {
//                        
//                        lastOtherY = j.getY();
//                        
//                        for (Jeton jj : lsJetons) {
//                            if (jj.getY() == lastOtherY)
//                                lastOtherX = jj.getX();
//                        
//                        }
//                        
//                        
//                        
//                        System.out.println("fin 2nd mot horiz");
//                        System.out.println(lastOtherX + ".." + lastOtherY);
//                        
//                    }       
//                } else {
//                    if (grille.watchDown(j)) {
//                        lastOtherX = j.getX();
//                        lastOtherY = grille.getLastYDown(j);
//                        System.out.println("fin 2nd mot verti");
//                        System.out.println(lastOtherX + ".." + lastOtherY);
//
//                    }
//                }  
//            
//
//        } else {
//
//            Jeton j = lsJetons.get(0);
////        for (Jeton j : lsJetons) {
//            if (grille.watchRight(lastJeton) || grille.watchDown(lastJeton)) {
////                Jeton lastJeton = lsJetons.get(lsJetons.size());
//                lastX = grille.getLastXRight(lastJeton);
//                lastY = grille.getLastYDown(lastJeton);
//                System.out.println("right or down");
//            } else {
//                lastX = lastJeton.getX();
//                lastY = lastJeton.getY();
//            }
//            
//            System.out.println("pos fin :");
//            System.out.println(lastX + "/"+ lastY);
//            
////       }
//        }
//        
//    }
    
    
    private Jeton getJetonFromList(int x, int y, List<Jeton> lsJetons) {
        Jeton jj = null;
        for (Jeton j : lsJetons) {
            if (j.getX() == x && j.getY() == y) {
                jj = j;
            }              
        }
        return jj;
    }
    
//    private boolean jetonNext(int x, int y) {
//        if (!lsMots.isEmpty())
//            return x <= lastOtherX && y <= lastOtherY;
//        else     
//            return x <= lastX && y <= lastY;
//    }
//    
//    private boolean motIsVertical() {
//        return x == lastX;
//    }
//    
//    private boolean newMotIsVertical() {
//        System.out.println("otherZ");
//        System.out.println(otherX +"'''"+lastOtherX);
//        return otherX == lastOtherX;
//    }
//    
//    private void goNext() {
//        
//        System.out.println("new mot vert?" + newMotIsVertical());
//        if (!lsMots.isEmpty()) {
//            if (newMotIsVertical()) {
//                otherX = otherX;
//                otherY = otherY + 1;
//            } else {
//                otherX = otherX + 1;
//                otherY = otherY;
//            }
//
//        } else {
//            if (motIsVertical()) {
//                x = x;
//                y = y + 1;
//            } else {
//                x = x + 1;
//                y = y;
//            }
//        }
//
//    }
//
//       
//    public Mot buildMot(List<Jeton> lsJetons) {
//        
//        mot.clear();
//        
//        System.out.println("otherz XY :");
//        
//        if (!lsMots.isEmpty()) {
//            do {
//                if (grille.caseJouee(otherX, otherY)) {
//                    mot.add(grille.getJetonAt(otherX, otherY));
//                    System.out.println("test autre mot");
//
//                } else {
//                    mot.add(getJetonFromList(otherX, otherY, lsJetons));
//                    System.out.println("testuuu autre mot");
//                }
//                System.out.println("hihi autre mot");
//                goNext();
//            } while (jetonNext(otherX, otherY));
//            
//            
//            
//
//        } else 
//        
//            
//        do  { 
//            
//                    
//            if (grille.caseJouee(x, y)) {
//                mot.add(grille.getJetonAt(x, y));
//                System.out.println("test1");
//                
//            } else {
//                mot.add(getJetonFromList(x, y,lsJetons));
//                System.out.println("test");
//            }
//            System.out.println("hihi");
//            goNext();
//            
//        } while (jetonNext(x,y));
//        
//              
//        getPosDebutMot(lsJetons);
//        getPosFinMot(lsJetons);
//        
//        
//        System.out.println(x + "," + y);
//        System.out.println("coucou");
//        
//        Mot m = new Mot(mot);
//        lsMots.add(m);
//        System.out.println("lsMots size : " + lsMots.size());
////        return m;
//        
//        return m;
//
//       
//    }
    
//    public String afficheMot() {
//        String str = "";
//        for (Jeton j : mot)
//            str = str+ j.getChar();
//        
//        return str.toUpperCase();
//    }
    
    public String afficheMots() {
        StringBuilder sb = new StringBuilder();
        
        for (Mot m : lsMots) {
            sb.append(m.getString());
        }

        return sb.toString().toUpperCase();
    }
    
    public void affMotStr(Mot mot) {
        System.out.println("Mot : " + mot.getString().toUpperCase());

    }
   
    
}
  
