/**
* @author Laroub Rayane
* @version 1.0
*/
public enum Leeftijdcategorieen {
    //Bepaalt de groepscategorieen en hun tarieven
    MIN_TWAALF(9.00),
    KINDEREN(12.00),
    VOLWASSENEN(15.00),
    VIJFENZESTIG_PLUS(6.50);

    private double prijs;

    private Leeftijdcategorieen(double prijs) {
        this.prijs = prijs;
    }

    public double getPrijs() {
        return prijs;
    }
}
