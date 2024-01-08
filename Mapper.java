import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mapper {

    private static int hash(String word) {
        // Utiliser la fonction hashCode() de la chaîne
        int hashCode = word.hashCode();

        // Appliquer des opérations pour garantir la distribution équitable
        int modifiedHashCode = (hashCode ^ (hashCode >>> 16)) & 0x7fffffff;

        // Redimensionner pour ajuster à la plage souhaitée
        return modifiedHashCode % 128;
    }


    public Mapper(){}

    public ArrayList<String> mapping(String text) {


        // Créer une Map pour stocker les occurrences de mots
        ArrayList<String> words = new ArrayList<>();

        // Utiliser une expression régulière pour trouver tous les mots dans le texte
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        words = convertToLowerCase(words);









        return words;


    }

    private static ArrayList<String> convertToLowerCase(List<String> wordsList) {
        ArrayList<String> lowercaseList = new ArrayList<>();

        for (String word : wordsList) {
            lowercaseList.add(word.toLowerCase());
        }

        return lowercaseList;
    }
}