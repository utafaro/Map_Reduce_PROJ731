import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static int hash(String word) {
        // Utiliser la fonction hashCode() de la chaîne
        int hashCode = word.hashCode();

        // Appliquer des opérations pour garantir la distribution équitable
        int modifiedHashCode = (hashCode ^ (hashCode >>> 16)) & 0x7fffffff;

        // Redimensionner pour ajuster à la plage souhaitée
        return modifiedHashCode % 128;
    }



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

        ArrayList<String>listReducer1=new ArrayList<String>();
        ArrayList<String>listReducer2=new ArrayList<String>();
        ArrayList<String>listReducer3=new ArrayList<String>();

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
                ArrayList<String> words= thread.getMapResult();
                for(String word:words){

                    int hw=hash(word);
                    if (0 <= hw && hw < 43){
                        listReducer1.add(word);

                    } else if (43 <= hw && hw < 86) {
                        listReducer2.add(word);

                    }
                    else {
                        listReducer3.add(word);
                    }
                }

                thread.join();

            }

            intermediateResults.add(listReducer1);
            intermediateResults.add(listReducer2);
            intermediateResults.add(listReducer3);
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


