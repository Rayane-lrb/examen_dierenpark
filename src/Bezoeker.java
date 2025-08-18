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

    private void setLeeftijdscategorie(String leeftijdscategorie2) {
        if (leeftijd > 12) {
            this.leeftijdscategorie = Leeftijdcategorieen.MIN_TWAALF.name();
        } else if (leeftijd >= 12 && leeftijd < 18) {
            this.leeftijdscategorie = Leeftijdcategorieen.KINDEREN.name();
        } else if (leeftijd >= 18 && leeftijd < 65) {
            this.leeftijdscategorie = Leeftijdcategorieen.VOLWASSENEN.name();
        } else {
            this.leeftijdscategorie = Leeftijdcategorieen.VIJFENZESTIG_PLUS.name();
        }
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
