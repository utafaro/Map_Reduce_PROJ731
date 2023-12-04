import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static Map<Character, Integer> map(String inputText) {
        Map<Character, Integer> characterCountMap = new HashMap<>();

        // Parcourir chaque caractère dans le texte
        for (char c : inputText.toCharArray()) {
            if (Character.isLetter(c)) {
                // Mettre à jour le compteur pour cette lettre
                char lowercaseChar = Character.toLowerCase(c);
                characterCountMap.put(lowercaseChar, characterCountMap.getOrDefault(lowercaseChar, 0) + 1);
            }
        }

        return characterCountMap;
    }

    public static void main(String[] args) {
        // Exemple Mapping
        List<String> texts = Arrays.asList(
                "Premier texte. Premier texte avec des mots.",
                "Deuxième texte avec d'autres mots.",
                "Troisième texte avec des mots similaires au premier."
        );

        WordCountList obj = new WordCountList();
        List<Map<String, Integer>> wordCountList = obj.countWordsInTexts(texts);

        // Afficher les résultats
        for (int i = 0; i < texts.size(); i++) {
            System.out.println("Occurrences des mots dans le texte " + (i + 1) + " : " + wordCountList.get(i));
        }
    }
}
