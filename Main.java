import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {



    public static void main (String[] args){





        String cheminFichier = "fichiers/shakespears.txt";
        Texte texte = new Texte(cheminFichier);

        List<String> test = new ArrayList<>();
        test.add("Bonjour je suis ugo je je");
        test.add("La savoie c'est cool");
        test.add("je ne suis pas pd");
        // Diviser le texte en 3 parties
        List<String> parties = texte.diviserEnParties(3);
        Mapper map = new Mapper();
        ArrayList<MonThread> listThread = new ArrayList<MonThread>();
        ArrayList<Map<String, Integer>> mapResults = new ArrayList<Map<String, Integer>>();

        Reducer reducer = new Reducer();
        ArrayList<String> listTest = new ArrayList<String>();





        try{
            for (int i=0; i< test.size(); i++){
                MonThread thread = new MonThread(map, test.get(i));
                thread.start();
                listThread.add(thread);
            }
            for(MonThread thread : listThread){
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Reducer : " + reducer.reducing(listTest) );






    }
}


