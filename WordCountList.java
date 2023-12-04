import java.util.*;

public class WordCountList {



    public static List<Map<String, Integer>> countWordsInTexts(List<String> texts) {
        List<Map<String, Integer>> wordCountList = new ArrayList<>();

        for (String text : texts) {
            Map<String, Integer> wordCountMap = map(text);

            // Ajouter la map résultante à la liste
            wordCountList.add(wordCountMap);
        }

        return wordCountList;
    }

    private static Map<String, Integer> map(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Diviser le texte en mots
        String[] words = text.split("\\s+"); // Utilisez une expression régulière pour diviser par espace

        // Parcourir chaque mot dans le texte
        for (String word : words) {
            // Ignorer la casse et la ponctuation si nécessaire

            // Mettre à jour le compteur pour ce mot
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Afficher les résultats intermédiaires (étape Map)


        return wordCountMap;
    }
}