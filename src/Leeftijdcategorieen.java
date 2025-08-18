public enum Leeftijdcategorieen {
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
