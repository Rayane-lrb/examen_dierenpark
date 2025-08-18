public class Activiteit {
    private String naam;
    private String beschrijving;
    private String categorieen[] = { "dierenveld", "eetstand", "speeltuin", "show", "anderen" };

    public Activiteit(String naam, String beschrijving) {
        setNaam(naam);
        setBeschrijving(beschrijving);
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String[] getCategorieen() {
        return categorieen;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

}
