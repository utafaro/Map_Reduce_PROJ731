
import java.util.*;

public class Shuffler {
    public List<String> getListe_a_e() {
        return liste_a_e;
    }

    private List<String> liste_a_e;

    public List<String> getListe_f_l() {
        return liste_f_l;
    }

    private List<String> liste_f_l;

    public List<String> getListe_m_z() {
        return liste_m_z;
    }

    private List<String> liste_m_z;



    public void trierMots(List<String> listeMots) {
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




}

}




    /*public ArrayList<Map<String,Integer>> shuffle (Map<String,Integer> mapping, String word){
        ArrayList<Map<String,Integer>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapping.entrySet()){
            if(word == entry.getKey()){
                result.add();
            }
        }
    }







} */

