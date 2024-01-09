import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2 {


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

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

        System.out.println(countWordOccurrences("fichiers/concatenateFile.txt"));

        long endTime = System.currentTimeMillis();

        long excutionTime  = endTime - startTime;

        System.out.println("Temps d'execution : " + excutionTime*0.001 + " s");
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

    public static Map<String, Integer> countWordOccurrences(String fileName) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Sépare les mots en utilisant des espaces comme délimiteurs
                for (String word : words) {
                    // Retire la ponctuation (facultatif, selon les besoins)
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Met à jour le compteur d'occurrences du mot
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + fileName);
            e.printStackTrace();
        }

        return wordCountMap;
    }
}
