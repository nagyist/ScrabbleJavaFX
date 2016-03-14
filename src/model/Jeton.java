package model;

import controllerGUI.ControllerGUI;

/**
 *
 * @author 0404ragrau
 */
public class Jeton {
    
//    private final Sac sac;
    
//    private static final char[] lettres = {'*','a','b','c','d','e','f','g','h','i','j','k','l','m','n',
//                                'o','p','q','r','s','t','u','v','w','x','y','z'};
    private final char lettre;


   
    public Jeton(char c) {
//        this.sac = ctrl.getSac();
        this.lettre = c;
        
//        Random rand = new Random();
//        int n = rand.nextInt(lettres.length);
//        this.lettre = lettres[n];

    }
    
    public char getChar() {
        return lettre;
    }
    
    public String getStr() {
        return ""+lettre;
    }

//    public static void affJetons() {
//        for(char c : lettres)
//            System.out.print(c + "  ");
//    }

}
