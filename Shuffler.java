
import java.util.*;

public class Shuffler {


    public void trierMots(List<String> listeMots,List<String> liste_a_e,List<String> liste_f_l,List<String> liste_m_z) {
        for(String mot:listeMots){
            char premiereLettre = mot.charAt(0);
            if (premiereLettre >= 'a' && premiereLettre <= 'e') {
                liste_a_e.add(mot);}

            if (premiereLettre >= 'f' && premiereLettre <= 'l') {
                liste_f_l.add(mot);
            }
            else{
                liste_m_z.add(mot);
            }

        }




}}




    /*public ArrayList<Map<String,Integer>> shuffle (Map<String,Integer> mapping, String word){
        ArrayList<Map<String,Integer>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapping.entrySet()){
            if(word == entry.getKey()){
                result.add();
            }
        }
    }







} */

