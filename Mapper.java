import java.util.*;

public class Mapper {



    public ArrayList<Map<String, Integer>> mapping(String text) {
        ArrayList<Map<String, Integer>> result = new ArrayList<>();


        // Diviser le texte en mots
        String[] words = text.split("\\s+"); // Utilisez une expression régulière pour diviser par espace

        // Parcourir chaque mot dans le texte
        for (String word : words) {

            // Mettre à jour le compteur pour ce mot
            Map<String, Integer> wordCountMap = new HashMap<>();
            wordCountMap.put(word, 1);
            result.add(wordCountMap);

        }

        // Afficher les résultats intermédiaires (étape Map)
        System.out.println(result);
        return result;
    }
}