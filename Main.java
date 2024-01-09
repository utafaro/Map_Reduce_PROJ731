import java.io.*;
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

    public static void concatenateFiles(ArrayList<String> fileNames, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String fileName : fileNames) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.err.println("Erreur de lecture du fichier : " + fileName);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur d'écriture dans le fichier de sortie : " + outputFileName);
            e.printStackTrace();
        }
}

    public static void main (String[] args){




        ArrayList<String> filesName = new ArrayList<String>();

        String fichier1 = "fichiers/shakespears.txt";
        String fichier2 = "fichiers/shakespears.txt";
        String fichier3 = "fichiers/shakespears.txt";
        String fichier4 = "fichiers/shakespears.txt";
        String fichier5 = "fichiers/shakespears.txt";
        String fichier6 = "fichiers/bible.txt";
        String fichier7 = "fichiers/bible.txt";
        String fichier8 = "fichiers/bible.txt";
        String fichier9 = "fichiers/bible.txt";
        String fichier10 = "fichiers/bible.txt";
        String fichier11= "fichiers/bible.txt";


        filesName.add(fichier1);
        filesName.add(fichier2);
        filesName.add(fichier3);
        filesName.add(fichier4);
        filesName.add(fichier5);
        filesName.add(fichier6);
        filesName.add(fichier7);
        filesName.add(fichier8);
        filesName.add(fichier9);
        filesName.add(fichier10);
        filesName.add(fichier11);

        concatenateFiles(filesName, "fichiers/concatenateFile.txt");

        String file_path = "fichiers/concatenateFile.txt";
        Texte texte = new Texte(file_path);


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
            for (int i=0; i< parties.size(); i++){
                MapperThread thread = new MapperThread(mapper, parties.get(i));
                thread.start();
                listMapThread.add(thread);
            }
            for(MapperThread thread : listMapThread){

                thread.join();
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


