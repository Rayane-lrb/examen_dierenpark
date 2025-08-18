public abstract class Personeelslid extends Persoon {

    public Personeelslid(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }

    public abstract String getFunctie();

    @Override
    public String toString() {
        return super.toString() + ", Functie: " + getFunctie();
    }

}