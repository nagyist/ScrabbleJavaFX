package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 0404ragrau
 */
public class Mot {

    List<Jeton> mot = new ArrayList<>();

    public void ajouterJetonMot(Jeton j) {
        mot.add(j);
    }

    public List<Jeton> getMot() {
        return mot;
    }

    public void afficherMot() {
        for (Jeton j : mot) {
            System.out.print(j.getChar());
        }
    }
}
