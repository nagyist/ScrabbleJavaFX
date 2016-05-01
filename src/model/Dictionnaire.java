package model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author 0404ragrau
 */
public class Dictionnaire {
    
    private final Scanner scanner;
    private final File file = new File("french.dic");
    private final TreeSet<String> dictionnaire = new TreeSet<>();
    
    
    public Dictionnaire() throws IOException {
        
        scanner = new Scanner(file);
        fillDict();
        
    }
    
    private void fillDict() {
        while (scanner.hasNextLine()) {
            String mot = scanner.nextLine();
            dictionnaire.add(mot);
        }
    }
    
    public boolean contains(String str) {
        if (dictionnaire.contains(str)) {
                return true;
    }
        return false;
    }
    
    public boolean contains(Mot m) {
        return dictionnaire.contains(m.getString());
    }
    
    
    public boolean contains(List<Mot> lsMots) {    
        for (Mot m : lsMots) {
            if (!dictionnaire.contains(m))
                return false;
        }
        return true; 
    }
    
    
    public int count() {
        return dictionnaire.size();
    }

   
    
    
    
    
    public static void main(String[] args) throws IOException {
        
        Dictionnaire d = new Dictionnaire();
        System.out.println(d.count());
        
        
    }
    
}
