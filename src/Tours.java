import java.util.ArrayList;

public class Tours {
    private String naam;
    private Zone zone;
    private ArrayList<Leeftijdcategorieen> leeftijdsGroep = new ArrayList<>();
    private ArrayList<Activiteit> activiteitenLijst = new ArrayList<>();
    private ArrayList<Bezoeker> TourBezoekers = new ArrayList<>();
    private ArrayList<Personeelslid> Tourpersoneel = new ArrayList<>();

    public Tours(String naam, Zone zone) {
        this.naam = naam;
        this.zone = zone;
    }

    public String getNaam() {
        return naam;
    }
    public Zone getZone() {
        return zone;
    }

    public ArrayList<Leeftijdcategorieen> getLeeftijdsGroep() {
        return leeftijdsGroep;
    }

    public ArrayList<Activiteit> getActiviteitenLijst() {
        return activiteitenLijst;
    }

    public ArrayList<Personeelslid> getPersoneelsledenLijst() {
        return Tourpersoneel;
    }

    public ArrayList<Bezoeker> getBezoekersLijst() {
        return TourBezoekers;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void setLeeftijdsGroep(ArrayList<Leeftijdcategorieen> leeftijdsGroep) {
        this.leeftijdsGroep = leeftijdsGroep;
    }

    public void setActiviteitenLijst(ArrayList<Activiteit> activiteitenLijst) {
        this.activiteitenLijst = activiteitenLijst;
    }

    public void voegBezoekerToe(Bezoeker bezoeker) {
        if (!TourBezoekers.contains(bezoeker)) {
            TourBezoekers.add(bezoeker);
        }
    }

    public void verwijderBezoeker(Bezoeker bezoeker) {
        if (!TourBezoekers.contains(bezoeker)) {
            throw new IllegalArgumentException("Bezoeker bestaat niet in deze tour.");
        }
        TourBezoekers.remove(bezoeker);
    }

    public void voegPersoneelslidToe(Personeelslid personeelslid) {
        if (!Tourpersoneel.contains(personeelslid)) {
            Tourpersoneel.add(personeelslid);
        }
    }

    public void voegLeeftijdsGroepToe(Leeftijdcategorieen leeftijdsCategorie) {
        if (!leeftijdsGroep.contains(leeftijdsCategorie)) {
            leeftijdsGroep.add(leeftijdsCategorie);
        }
    }

    public void voegActiviteitToe(Activiteit activiteit) {
        if (!activiteitenLijst.contains(activiteit)) {
            activiteitenLijst.add(activiteit);
        }
    }

    public void verwijderActiviteit(Activiteit activiteit) {
        if (!activiteitenLijst.contains(activiteit)) {
            throw new IllegalArgumentException("Activiteit bestaat niet in deze tour.");
        }
        activiteitenLijst.remove(activiteit);
    }

    @Override
    public String toString() {
        return "Tours" +
                "naam: " + naam + '\'' +
                ", zone: " + zone;
    }
}