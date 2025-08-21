import java.util.Set;

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

    public void voegActiviteitToe(Activiteit activiteit) {
        activiteiten.add(activiteit);
    }

    public void verwijderActiviteit(Activiteit activiteit) {
        if (!activiteiten.contains(activiteit)) {
            throw new IllegalArgumentException("Activiteit bestaat niet in deze zone.");
        }
        activiteiten.remove(activiteit);
    }

    @Override
    public String toString() {
        return "Zone: " +
                "maximumCapaciteit: " + maximumCapaciteit;
    }
}
