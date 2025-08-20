public class Bezoeker extends Persoon {
    private String leeftijdscategorie;
    private int aantalBezoekers = 0;

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

    public int getAantalBezoekers() {
        return aantalBezoekers;
    }

    public double bepaalPrijs(Leeftijdcategorieen leeftijdscategorie) {
        return leeftijdscategorie.getPrijs();
    }

    @Override
    public String toString() {
        return super.toString() + ", Leeftijdscategorie: " + leeftijdscategorie + ", Prijs: "
                + bepaalPrijs(Leeftijdcategorieen.valueOf(leeftijdscategorie));
    }
}
