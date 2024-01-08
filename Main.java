import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {



    public static void main (String[] args){





        String cheminFichier = "fichiers/shakespears.txt";
        Texte texte = new Texte(cheminFichier);

        List<String> test = new ArrayList<>();
        test.add("Bonjour je suis ugo");
        test.add("La savoie c'est cool");
        test.add("je ne suis pas pd");
        // Diviser le texte en 3 parties
        List<String> parties = texte.diviserEnParties(3);
        Mapper map = new Mapper();

        for (int i=0; i< test.size(); i++){
            Thread thread = new Thread(new MonThread(map, test.get(i)));
            thread.start();
        }





    }
}


