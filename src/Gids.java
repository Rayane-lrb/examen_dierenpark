public class Gids extends Personeelslid {

    public Gids(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }

    @Override
    public String getFunctie() {
        return "Gids";
    }

    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }

}
