/**
* @author Laroub Rayane
* @version 1.0
*/
public class Verzorger extends Personeelslid {
//Dient las hoofdklasse voor specifieke functes zoals Gids ,Poetsploeg, ...
    public Verzorger(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }
//Geeft de functie van een personeelslid weer
    @Override
    public String getFunctie() {
        return "Verzorger";
    }
//Geeft alles weer als een String ipv object
    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }

}