import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mapper {



    public ArrayList<String> mapping(String text) {


        // Créer une Map pour stocker les occurrences de mots
        ArrayList<String> words = new ArrayList<>();

        // Utiliser une expression régulière pour trouver tous les mots dans le texte
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        System.out.println(words);
        return words;

    }
}