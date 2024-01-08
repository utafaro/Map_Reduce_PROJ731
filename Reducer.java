import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reducer {

    public Map<String, Integer> reducing(ArrayList<String> shuffleResults){
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (String word : shuffleResults) {
            // Si le mot est déjà présent dans la map, incrémenter le compteur
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                // Sinon, ajouter le mot à la map avec un compteur initial de 1
                wordCountMap.put(word, 1);
            }
        }



        return wordCountMap;
    }


}
