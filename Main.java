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
        Mapper mapper = new Mapper();
        ArrayList<MapperThread> listMapThread = new ArrayList<MapperThread>();
        ArrayList<ReducerThread> listReduceThread = new ArrayList<ReducerThread>();
        ArrayList<Map<String, Integer>> mapResults = new ArrayList<Map<String, Integer>>();

        Reducer reducer = new Reducer();
        ArrayList<String> listTest = new ArrayList<String>();
        ArrayList<ArrayList<String>> intermediateResults = new ArrayList<ArrayList<String>>();
        int numReducer = 3;
        ArrayList<Map<String,Integer>> reducerResults = new ArrayList<Map<String, Integer>>();




        try{
            for (int i=0; i< test.size(); i++){
                MapperThread thread = new MapperThread(mapper, test.get(i));
                thread.start();
                listMapThread.add(thread);
            }
            for(MapperThread thread : listMapThread){
                thread.join();
                intermediateResults.add(thread.getMapResult());
            }
            for(int i=0; i<numReducer; i++ ){
                ReducerThread thread = new ReducerThread(reducer, intermediateResults.get(i));
                thread.start();
                listReduceThread.add(thread);

            }
            for (ReducerThread thread: listReduceThread){
                thread.join();
                reducerResults.add(thread.getReducerResults());
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Map<String, Integer> finalResult = new HashMap<String, Integer>();
        for(Map<String, Integer> map: reducerResults){
           finalResult.putAll(map);
        }

        System.out.println(finalResult);






    }
}


