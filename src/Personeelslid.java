/**
* @author Laroub Rayane
* @version 1.0
*/
public abstract class Personeelslid extends Persoon {

    public Personeelslid(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }

    public abstract String getFunctie();
//Geeft alles weer als String ipv object
    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }

}