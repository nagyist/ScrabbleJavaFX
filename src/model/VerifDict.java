package model;

import controllerGUI.ControllerGUI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author raphaelgrau
 */
public class VerifDict {
    
    
    private final Scanner dict; 
    List<String> dictList = new ArrayList<>();
    
    public VerifDict(ControllerGUI ctrl) throws IOException {
        
        dict = new Scanner(new File("french.dic"));
    }

    public boolean ajouterMotDict(String str) {
        
        for (int i = 0; dict.hasNextLine() != false; ++i) {

            dictList.add(dict.nextLine());
            if (dictList.get(i).equals(str)) {
                return true;
            }
        }
        return false;

    }
}
