import java.util.ArrayList;
/**
* @author Laroub Rayane
* @version 1.0
*/
public class Tours {
    private String naam;
    private Zone zone;
    private int minLeeftijd;
    private ArrayList<Leeftijdcategorieen> leeftijdsGroep = new ArrayList<>();
    private ArrayList<Activiteit> activiteitenLijst = new ArrayList<>();
    private ArrayList<Bezoeker> TourBezoekers = new ArrayList<>();
    private ArrayList<Personeelslid> Tourpersoneel = new ArrayList<>();

    public Tours(String naam, Zone zone, int minLeeftijd) {
        this.naam = naam;
        this.zone = zone;
        this.minLeeftijd = minLeeftijd;
    }

    public String getNaam() {
        return naam;
    }
    public Zone getZone() {
        return zone;
    }
    public int getMinLeefijd() {
        return minLeeftijd;
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
    public void setMinLeeftijd(int minLeeftijd) {
        this.minLeeftijd = minLeeftijd;
    }

    public void setLeeftijdsGroep(ArrayList<Leeftijdcategorieen> leeftijdsGroep) {
        this.leeftijdsGroep = leeftijdsGroep;
    }

    public void setActiviteitenLijst(ArrayList<Activiteit> activiteitenLijst) {
        this.activiteitenLijst = activiteitenLijst;
    }
//Bezoeker touvoegen aan bezoekrslijst van een tour
    public void voegBezoekerToe(Bezoeker bezoeker) {
        if (!TourBezoekers.contains(bezoeker)) {
            TourBezoekers.add(bezoeker);
        }
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
    //Voor het toevoegen van actviteiten 
    public void voegActiviteitToe(Activiteit activiteit) {
        if (!activiteitenLijst.contains(activiteit)) {
            activiteitenLijst.add(activiteit);
        }
    }
    //Geeft alles weer als String ipv object
    @Override
    public String toString() {
        return "Tours" +
                "naam: " + naam + '\'' +
                ", zone: " + zone;
    }
}