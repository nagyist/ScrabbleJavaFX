package model;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author raphaelgrau
 */
public class Scrabble extends Observable {
    
    private final Grille grille;
    private final Chevalet chev;
    private final VerifMot verif;
    private final Sac sac;
    private final WordsMaker wm;
    private final Dictionnaire dict;
    
    public Scrabble(ControllerGUI ctrl) {
        this.grille = ctrl.getGrille();
        this.chev = ctrl.getChevalet();
        this.verif = ctrl.getVerifMot();
        this.sac = ctrl.getSac();
        this.wm = ctrl.getWordMaker();
        this.dict = ctrl.getDict();
    }
    
    private void placerLettre(int x, int y, Jeton j) {
//        grille.setCase(x, y, j.getChar());
        grille.setCase(x, y, j);

    }
    
    private void placerLettres(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons) {
            placerLettre(j.getX(), j.getY(), j);
        }
    }
    
    private void removeJeton(Jeton j) {
        chev.removeJeton(j);
    }
    
    private void removeJetonSac(Jeton j) {
        sac.removeJeton(j);
    }
    
    private void removeJetonsSac(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons)
            removeJetonSac(j);
    }
    
    private void removeJetons(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons) {
            removeJeton(j);
        }
    }
    
    public void changeJetons(List<Jeton> lsJetons, Sac sac) {
        removeJetons(lsJetons);
        rechargerChevalet(lsJetons,sac);
        removeJetonsSac(lsJetons);
        notif();
    }
    
    public List<Jeton> sort(List<Jeton> lsJetons) {
        return verif.sort(lsJetons);
    }
       
    private void rechargerChevalet(List<Jeton> lsJetons, Sac sac) {
        for (Jeton j : lsJetons) {
            chev.rechargerChevalet(sac);
        }
    }
        
    public void jouerCoup(List<Jeton> lsJetons, Sac sac) {
        placerLettres(lsJetons);
        removeJetons(lsJetons);
        rechargerChevalet(lsJetons, sac);
        removeJetonsSac(lsJetons);
        notif();
    }
    
//    private WordsMaker build(List<Jeton>) {
//        return wordmaker.getWord();
//    }
    
//    private String buildMot(List<Jeton> lsJetons) {
//        wm.makeWord(lsJetons);
//        return wm.getMot();
//    }
    
    public List<Mot> buildMots(List<Jeton> lsJetons) {
//        wm.makeWords(lsJetons);
        
        return wm.prepareMots(lsJetons);
//        return wm.getMots();
    }
    
    public boolean motDico(List<Jeton> lsJetons) {
//        String str = buildMot(lsJetons);
//        wm.makeWord(lsJetons);
//        String str = wm.getMot();       
      List<Mot> lsMots = new ArrayList<>();
      lsMots = buildMots(lsJetons);
      
        System.out.println("lsMots mots :");
      for (Mot m : lsMots) {
          System.out.println(m.getMotStr());
      }
          

      return dict.contains(lsMots);
//        return dict.contains(str);
    }

    public boolean motPosition(List<Jeton> lsJetons) {
        return verif.ajouterMotVerif(lsJetons);
    }

    
    public void notif() {
        setChanged();
        notifyObservers();
    }


    
    
}
