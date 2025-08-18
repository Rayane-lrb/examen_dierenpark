public class Poetsploeg extends Personeelslid {

    public Poetsploeg(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }

    @Override
    public String getFunctie() {
        return "Poetsploeg";
    }

    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }
    
}
