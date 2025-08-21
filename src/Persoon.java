/**
* @author Laroub Rayane
* @version 1.0
*/
public abstract class Persoon {
    /**
 * Dit is een hoofdklasse die alleen maar dient om gebruikt te worden door subklassen
 */
    private String naam;
    protected int leeftijd;
    private Adres adres;

    public Persoon(String naam, int leeftijd, Adres adres) {
        setNaam(naam);
        setLeeftijd(leeftijd);
        setAdres(adres);
    }

    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setLeeftijd(int leeftijd) {
        if (leeftijd < 0) {
            throw new IllegalArgumentException("Leeftijd kan niet negatief zijn.");
        }
        this.leeftijd = leeftijd;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    //Zorgt ervoor dat het niet als een object wordt afgeprint maar als String
    @Override
    public String toString() {
        return "Naam: " + naam + ", Leeftijd: " + leeftijd + ", Adres: " + adres;
    }
}
