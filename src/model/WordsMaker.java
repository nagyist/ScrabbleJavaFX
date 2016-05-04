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
    private final List<Jeton> lettresPourMot = new ArrayList<>();
    private final List<Mot> lsMots = new ArrayList<>();
    private Mot motPrincipal;
    private Mot autreMot;
    private Mot temp;

    public WordsMaker(ControllerGUI ctrl, Grille grille) {
        this.ctrl = ctrl;
        this.grille = ctrl.getGrille();
    }
     
    public List<Mot> getMots() {
        return lsMots;
    }
    
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
        
        if (lsMots.isEmpty()) {
          motPrincipal = new Mot();
        }
        temp = new Mot();
        
        
   
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
            motPrincipal.calcPoints(grille);
            lsMots.add(motPrincipal);
        } else {
            autreMot = temp;
            autreMot.calcPoints(grille);
            lsMots.add(autreMot);
        }
            
    
        System.out.println("mot principal : ");
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
    
    
    public boolean motDejaPlace(Jeton j) {
        
  
        for (Mot m : lsMots) {
            if (m == motPrincipal)
                System.out.println("coucou mot principal");
            else {
                if (m.getJDeb() == j)
                return true;
            else if (m.getJFin() == j)
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
            
            System.out.println("motPrincipal verti? "+ motPrincipal.isVerti());

            temp.setJDeb(lsJetons.get(0));
            
            for (Jeton j : lsJetons) {
                if (motPrincipal.isVerti()) {
                    if (grille.watchLeft(j)){// && !motDejaPlace(j)) {
                        xDeb = grille.getLastXLeft(j);
                        yDeb = j.getY();
                                                
                        setJDeb(xDeb, yDeb, lsJetons);
                        System.out.println("deb 2nd mot horiz");
                    } else if (grille.watchRight(j)){// && !motDejaPlace(j)) {
                        xDeb = j.getX();
                        yDeb = j.getY();
                        setJDeb(xDeb, yDeb, lsJetons);
                        System.out.println("deb 2nd mot horiz z z z");
                    }
                } else if (!motPrincipal.isVerti()) {
                    System.out.println("test deb");
                    System.out.println();
                    if (grille.watchUp(j)){// && !motDejaPlace(j)) {
                        xDeb = j.getX();
                        yDeb = grille.getLastYUp(j);
                        setJDeb(xDeb, yDeb, lsJetons);
                        System.out.println("deb 2nd mot vert");
                    } else if (grille.watchDown(j)){// && !motDejaPlace(j)) {
                        xDeb = j.getX();
                        yDeb = j.getY();
                        setJDeb(xDeb, yDeb, lsJetons);
                        System.out.println("deb 2nd mot vert i i");
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
            System.out.println("fin 2nd mot");
//            Jeton j = grille.getJetonAt(temp.getXDeb(), temp.getYDeb());
            
            for (Jeton j : lsJetons) {
                if (motPrincipal.isVerti()) {
                    if (grille.watchRight(j)){// && !motDejaPlace(j)) {
                        yFin = j.getY();
                        xFin = grille.getLastXRight(j);
                        setJFin(xFin, yFin, lsJetons);
                        System.out.println("fin 2nd mot horiz");
                    } else if (grille.watchLeft(j)) {
                        xFin = j.getX();
                        yFin = j.getY();
                        setJFin(xFin, yFin, lsJetons);
                        System.out.println("fin 2nd mot verti");
                    }
                } else if (!motPrincipal.isVerti()){// && !motDejaPlace(j)) {
                    if (grille.watchUp(j)) {
                        xFin = j.getX();
                        yFin = j.getY();
                        setJFin(xFin, yFin, lsJetons);
                        System.out.println("fin 2nd mot verti * * * *");
                        System.out.println(xFin + "/" + yFin);
                    }
                    else if (grille.watchDown(j)) {
                        xFin = j.getX();
                        yFin = grille.getLastYDown(j);
                        setJFin(xFin, yFin, lsJetons);
                        System.out.println("fin 2nd mot verti");
                    }
                }
            }
            
            
            
            
            
            
            
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
                    System.out.println("1er mot verti");
                    System.out.println("xDeb, yDeb : " + xDeb + ", " + i);
                }
            } else {
                for (int i = xDeb; i <= xFin; ++i) {

                    if (grille.caseJouee(i, yDeb)) {
                        lettresPourMot.add(grille.getJetonAt(i, yDeb));
                    } else {
                        lettresPourMot.add(getJetonFromList(i, yDeb, lsJetons));
                    }
                    System.out.println("1er mot horiz");
                    System.out.println("xDeb, yDeb : " + i + ", " + yDeb);

                }
            }

        }
        
        
        
        
        System.out.println("size liste :" + lettresPourMot.size());
//        for (Jeton j : lettresPourMot)
//            System.out.println(j.getChar());


        temp.fill(lettresPourMot);

        
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
  
