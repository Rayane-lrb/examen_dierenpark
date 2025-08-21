/**
* @author Laroub Rayane
* @version 1.0
*/
public class Gids extends Personeelslid {

    public Gids(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }
//Geeft de functie weer
    @Override
    public String getFunctie() {
        return "Gids";
    }
//Geeft alles weer als String ipv object
    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }

}
