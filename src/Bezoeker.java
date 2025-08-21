/**
* @author Laroub Rayane
* @version 1.0
*/
public class Bezoeker extends Persoon {
    private String leeftijdscategorie;
    private static int aantalBezoekers = 0;

    public Bezoeker(String naam, int leeftijd, Adres adres, String leeftijdscategorie) {
        super(naam, leeftijd, adres);
        setLeeftijdscategorie(leeftijdscategorie);
        aantalBezoekers++;
    }

    public String getLeeftijdscategorie() {
        return leeftijdscategorie;
    }

    public void setLeeftijdscategorie(String leeftijdscategorie) {
        this.leeftijdscategorie = leeftijdscategorie;
        
    }
//Geeft het totaal aangemaakte Bezoekers weer
    public static int getAantalBezoekers() {
        return aantalBezoekers;
    }
//Bepaalt de te betalen prijs volgens leeftijdsgroep van een bezoeker
    public double bepaalPrijs(Leeftijdcategorieen leeftijdscategorie) {
        return leeftijdscategorie.getPrijs();
    }
//Geeft alles weer als String ipv object
    @Override
    public String toString() {
        return super.toString() + ", Leeftijdscategorie: " + leeftijdscategorie + ", Prijs: "
                + bepaalPrijs(Leeftijdcategorieen.valueOf(leeftijdscategorie));
    }
}
