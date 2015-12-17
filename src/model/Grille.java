
package model;

import java.util.Observable;

/**
 *
 * @author 0404ragrau
 */
public class Grille extends Observable {
    
    // la grille est un tableau 2D de Cases
    private Case[][] grille;

    
    public Grille() {
        this.grille = new Case[15][15];   
    }
 

    public void notif() {
        setChanged();
        notifyObservers(grille);
    }
    
    // méthode qui va démarrer l'application
    public void initGrille() {
        
        notif();
    }
  
    
    // methode qui va mettre à jour la grille après chaque coup joué
    public void updateGrille() {
        
    // une fois qu'on met à jour la grille, on va notifier 
    // les observeurs (ici en l'occurence, la view)
        notif();
    }
    
    
    
    
    
    /*
     *  on va dessiner la grille
     *  on peut se base sur le fait que la grille est en fait 4 quadrants les mêmes 
     *  --> row et col plus petits que 8
     */
    
    
    
//    public void initGrille() {
//        for ( int row = 0; row < 8; row++ ) {
//            for ( int col = 0; col < 8; col++ ) {
//                
//                
//            }
//    }
    
   
    
//    public static void initGrid() {
//    
//   
//    for(int i = 0; i < 15; i++){
//        for(int j = 0; j < 15; j++){
//            System.out.printf("[o]", grid[i][j]);
//        }
//        System.out.println("");
//    }
}
    
 
    
//    public static void main(String[] args) {
//        
////        initGrille();
//        
//        
//    }
   

