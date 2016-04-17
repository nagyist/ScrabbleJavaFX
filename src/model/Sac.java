package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author raphaelgrau
 */
public final class Sac {
    
    
    private List<Jeton> jetons = new ArrayList<>();

//    private static final char[] lettres = {
//        '*', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
//        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//    
//    private char lettre;
//    private final int SAC_SIZE = 100;
//    private final List<Character> sac = new ArrayList<>();
////    private static int cpt;
    
    
    private final Random rand = new Random();

    public Sac() {
//        for (int k = 0; k < SAC_SIZE; k++) {
//
//            int n = rand.nextInt(lettres.length);
//            lettre = lettres[n];
//            sac.add(lettre);
////            cpt++
//                    ;
//        }
        remplirSac();   
        afficherSac();

    }
    
    
    public void ajouterJeton(int nbJetons, char lettre, int points) {
        for (int i = 0 ; i < nbJetons ; i++) {
            Jeton j = new Jeton(lettre, 0, 0);
            j.setPoints(points);
            jetons.add(j);
        }
    }
    
    public void removeJeton(Jeton j) {
        jetons.remove(j);
    }
        
    public void remplirSac() {
        
        ajouterJeton(2,  '*', 0);
        
        ajouterJeton(15, 'e', 1);
        ajouterJeton(9,  'a', 1);
        ajouterJeton(8,  'i', 1);
        ajouterJeton(6,  'n', 1);
        ajouterJeton(6,  'o', 1);
        ajouterJeton(6,  'r', 1);
        ajouterJeton(6,  's', 1);
        ajouterJeton(6,  't', 1);
        ajouterJeton(6,  'u', 1);
        ajouterJeton(5,  'l', 1);
        
        ajouterJeton(3,  'd', 2);
        ajouterJeton(3,  'm', 2);
        ajouterJeton(2,  'g', 2);
        
        ajouterJeton(2,  'b', 3);
        ajouterJeton(2,  'c', 3);
        ajouterJeton(2,  'p', 3);
        
        ajouterJeton(2,  'f', 4);
        ajouterJeton(2,  'h', 4);
        ajouterJeton(2,  'v', 4);
        
        ajouterJeton(1,  'j', 8);
        ajouterJeton(1,  'q', 8);
        
        ajouterJeton(1,  'k', 10);
        ajouterJeton(1,  'w', 10);
        ajouterJeton(1,  'x', 10);
        ajouterJeton(1,  'y', 10);
        ajouterJeton(1,  'z', 10);       
    }

    
    public Jeton getRandomJeton() {
        int n = rand.nextInt(jetons.size());
        Jeton j = jetons.get(n);
        return j;
    }
    
    public void afficherSac() {
        
        System.out.println("taille =" + jetons.size());
//        for (Jeton j : jetons) {
//            System.out.println(j.getStr() + " / " + j.getPoints()) ;
////            System.out.print();
//        }
        
    }

    
//    public char getRandomLettre() {
//        int n = rand.nextInt(sac.size());
////        cpt--
//                ;
//        return sac.get(n);
//    }
}
