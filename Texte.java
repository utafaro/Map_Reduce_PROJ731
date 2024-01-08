
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Texte {

    private String texte;

    public Texte(String cheminFichier) {
        // Lecture du fichier et stockage du contenu dans la variable 'texte'
        this.texte = lireFichier(cheminFichier);
    }

    private String lireFichier(String cheminFichier) {
        StringBuilder contenu = new StringBuilder();
        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                contenu.append(ligne).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenu.toString();
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getTexte() {
        return texte;
    }

    public List<String> diviserEnParties(int nombreDeParties) {
        List<String> parties = new ArrayList<>();
        if (texte == null || texte.isEmpty() || nombreDeParties <= 0) {
            // Gérer le cas où le texte est vide ou le nombre de parties est invalide
            return parties;
        }

        int longueurDuTexte = texte.length();
        int tailleDeLaPartie = longueurDuTexte / nombreDeParties;

        int indexDebut = 0;
        int indexFin;

        for (int i = 0; i < nombreDeParties - 1; i++) {
            indexFin = trouverIndexFin(texte, indexDebut + tailleDeLaPartie);
            parties.add(texte.substring(indexDebut, indexFin));
            indexDebut = indexFin + 1;  // +1 pour sauter l'espace
        }

        // La dernière partie peut être un peu plus longue pour gérer la division non exacte
        parties.add(texte.substring(indexDebut));

        return parties;
    }

    private int trouverIndexFin(String texte, int indexDebut) {
        // Trouve l'index de l'espace le plus proche après l'index de début
        int indexEspace = texte.indexOf(' ', indexDebut);
        return (indexEspace != -1) ? indexEspace : texte.length();
    }


}