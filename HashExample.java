import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
public class HashExample {

    public static int hashToFloat(String word) {
        // Utiliser la fonction hashCode() de la chaîne
        int hashCode = word.hashCode();

        // Appliquer des opérations pour garantir la distribution équitable
        int modifiedHashCode = (hashCode ^ (hashCode >>> 16)) & 0x7fffffff;

        // Redimensionner pour ajuster à la plage souhaitée
        return modifiedHashCode % 128;
    }
    public static void main(String[] args) {
        // Exemple d'utilisation
        ArrayList<String> words=new ArrayList<String>();
        words.add("mots1");
        words.add("mots2");
        words.add("mots3");
        words.add("mots1");

        System.out.println(hashToFloat("bonjous"));

    }
}
