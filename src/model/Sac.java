package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author raphaelgrau
 */
public class Sac {
    
    private static final char[] lettres = {'*','a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                            'o','p','q','r','s','t','u','v','w','x','y','z'};
    private char lettre;
    private final int SAC_SIZE = 100;
    private List<Character> sac = new ArrayList<>();
    private static int cpt;
    
    
    public Sac() {
        
        for (int k = 0 ; k < SAC_SIZE ; k++) {
          Random rand = new Random();
          int n = rand.nextInt(lettres.length);
          lettre = lettres[n];
          sac.add(lettre);
          cpt++;
        }    
    }
    
    public char getRandomLettre() {
        Random rand = new Random();
        int n = rand.nextInt(sac.size());
        cpt--;
        return sac.get(n);
    }
}
