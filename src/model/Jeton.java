package model;

import java.util.Comparator;

/**
 *
 * @author 0404ragrau
 */
public class Jeton {

    private final char lettre;
    private int x, y;
    private int points;
    
//    private static final char[] un = {'e', 'a', 'i', 'n', 'o', 'r', 's', 't', 'u', 'l'};
//    private static final char[] deux = {'d', 'm', 'g'};
//    private static final char[] trois = {'b', 'c', 'p'};
//    private static final char[] quatre = {'f', 'h', 'v'};
//    private static final char[] huit = {'j', 'q'};
//    private static final char[] dix = {'k', 'w', 'x', 'y', 'z'};
//    
//    private static final Set<Jeton> zeroPoint = new HashSet<>();
//    private static final Set<Jeton> unPoint = new HashSet<>();
//    private static final Set<Jeton> deuxPoints = new HashSet<>();
//    private static final Set<Jeton> troisPoints = new HashSet<>();
//    private static final Set<Jeton> quatresPoints = new HashSet<>();
//    private static final Set<Jeton> huitsPoints = new HashSet<>();
//    private static final Set<Jeton> dixPoints = new HashSet<>();

    
    public Jeton(char c, int x, int y) {
        this.lettre = c;
        this.x = x;
        this.y = y;
//        initPoints();
        
    }
    
    public void affJeton() {
        System.out.println(x + "/" + y);
    }
    
    public char getChar() {
        return lettre;
    }
    
    public String getStr() {
        return ""+lettre;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    } 
    
    public int getPoints() {
        return points;
    }
    
    public String afficherPoints() {
        return ""+points;
    }
    
    public void setPoints(int pts) {
        points = pts;
    }
    
    public Jeton getJeton(char c) {
        if (lettre == c)
            return this;
        return null;
    }
    
    public void initPoints() {
        
        
//        if (points == 1)
//            unPoint.add(this);
//        else if (points == 2)
//            deuxPoints.add(this);
//        else if (points == 3)
//            troisPoints.add(this);
//        else if (points == 4)
//            quatresPoints.add(this);
        
//        
//        zeroPoint.add('*');
//        
//        for (char c : un)
//            unPoint.add(c);
//       
//        for (char c : deux)
//            deuxPoints.add(c);
//        
//        for (char c : trois)
//            troisPoints.add(c);
//        
//        for (char c : quatre)
//            quatresPoints.add(c);
//        
//        for (char c : huit)
//            huitsPoints.add(c);
//        
//        for (char c : dix)
//            dixPoints.add(c);
//        
//        if (unPoint.contains(lettre))
//           points = 1;
//        else if (deuxPoints.contains(lettre))
//            points = 2;
//        else if (troisPoints.contains(lettre))
//            points = 3;
//        else if (quatresPoints.contains(lettre))
//            points = 4;
//        else if (huitsPoints.contains(lettre))
//            points = 8;
//        else if (dixPoints.contains(lettre))
//            points = 10;
//        else
//            points = 0;
        
    }
    
    public static Comparator<Jeton> COMPARE_BY_X = (Jeton j, Jeton jj) -> {
        Integer jx = j.x;
        Integer jjx = jj.x;
        return jx.compareTo(jjx);
    };

    public static Comparator<Jeton> COMPARE_BY_Y = (Jeton j, Jeton jj) -> {
        Integer jy = j.y;
        Integer jjy = jj.y;
        return jy.compareTo(jjy);
    };
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.lettre;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jeton other = (Jeton) obj;
        return this.lettre == other.lettre;
    }


    
    
}
