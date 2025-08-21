/**
* @author Laroub Rayane
* @version 1.0
*/
public class Poetsploeg extends Personeelslid {

    public Poetsploeg(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }
//Geeft de functie weer
    @Override
    public String getFunctie() {
        return "Poetsploeg";
    }

    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }
    
}
