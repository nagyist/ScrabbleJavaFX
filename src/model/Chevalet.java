
package model;

/**
 *
 * @author 0404ragrau
 */
public class Chevalet {
    
    // le chevalet est un tableau de jetons
    public Jeton[] chev;
    public int nbJetons;
    
    

    // par défaut, le chevalet est vide
    public Chevalet(int nbJetons, Jeton[] chev) {
        this.nbJetons = 0;
        this.chev = new Jeton[7];
    
}
    
    // methode random qui place 7 jetons au hasard sur le chevalet
    public DistribJetons() {
        
        
    }
    
    
    // le joueur choisi la lettre qu'il veut placer ainsi que les coordonnées de 
    // la case où il veut la placer
    public placerMot() {
        
    }
    
}
