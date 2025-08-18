public class Verzorger extends Personeelslid {

    public Verzorger(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }

    @Override
    public String getFunctie() {
        return "Verzorger";
    }

    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }

}