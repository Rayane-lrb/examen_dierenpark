import java.util.Set;

/**
* @author Laroub Rayane
* @version 1.0
*/

//Deze klasse bepaalt welke actviteiten er in een zone aanwezig zijn en de maximum capaciteit van deze zone, die nadien zal gebruikt worden door Tour
public class Zone {
    private int maximumCapaciteit;
    private Set<Activiteit> activiteiten;

    public Zone(int maximumCapaciteit, Set<Activiteit> activiteiten) {
        setMaximumCapaciteit(maximumCapaciteit);
        setActiviteiten(activiteiten);
    }

    public int getMaximumCapaciteit() {
        return maximumCapaciteit;
    }

    public Set<Activiteit> getActiviteiten() {
        return activiteiten;
    }

    public void setMaximumCapaciteit(int maximumCapaciteit) {
        this.maximumCapaciteit = maximumCapaciteit;
    }

    public void setActiviteiten(Set<Activiteit> activiteiten) {
        this.activiteiten = activiteiten;
    }
    //Voegt actviteiten toe aan een zone
    public void voegActiviteitToe(Activiteit activiteit) {
        activiteiten.add(activiteit);
    }
    //Geeft weer als String ipv object
    @Override
    public String toString() {
        return "maximumCapaciteit: " + maximumCapaciteit;
    }
}
