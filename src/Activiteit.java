import java.util.ArrayList;
import java.util.Objects;

public class Activiteit {
    private String naam;
    private String beschrijving;
    private String categorie;
    private ArrayList<Personeelslid> activiteitsPersoneelsleden = new ArrayList<>();

    public Activiteit(String categorie, String naam, String beschrijving) {
        setCategorie(categorie);
        setNaam(naam);
        setBeschrijving(beschrijving);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Activiteit that = (Activiteit) o;
        return Objects.equals(naam, that.naam) && Objects.equals(beschrijving, that.beschrijving)
                && Objects.equals(categorie, that.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, beschrijving, categorie);
    }

    public String getCategorie() {
        return categorie;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
    public void addPersoneelslid(Personeelslid personeelslid) {
        if (personeelslid != null && !activiteitsPersoneelsleden.contains(personeelslid)) {
            activiteitsPersoneelsleden.add(personeelslid);
        }
    }

    public String toString() {
        return "Activiteit: " +
                "naam:'" + naam + '\'' +
                ", beschrijving:'" + beschrijving + '\'' +
                ", categorie:'" + categorie + '\'' +
                '}';
    }

}
