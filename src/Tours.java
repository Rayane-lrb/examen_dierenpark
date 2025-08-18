import java.util.ArrayList;

public class Tours {
    private String naam;
    private Zone zone;
    private ArrayList<Leeftijdcategorieen> leeftijdsGroep = new ArrayList<>();
    private ArrayList<Activiteit> activiteitenLijst = new ArrayList<>();
    private ArrayList<Personeelslid> personeelsledenLijst = new ArrayList<>();
    private ArrayList<Bezoeker> bezoekersLijst = new ArrayList<>();

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
        return personeelsledenLijst;
    }

    public ArrayList<Bezoeker> getBezoekersLijst() {
        return bezoekersLijst;
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

    public void setPersoneelsledenLijst(ArrayList<Personeelslid> personeelsledenLijst) {
        this.personeelsledenLijst = personeelsledenLijst;
    }

    public void setBezoekersLijst(ArrayList<Bezoeker> bezoekersLijst) {
        this.bezoekersLijst = bezoekersLijst;
    }

    public void voegBezoekerToe(Bezoeker bezoeker) {
        if (!bezoekersLijst.contains(bezoeker)) {
            bezoekersLijst.add(bezoeker);
        }
    }

    public void verwijderBezoeker(Bezoeker bezoeker) {
        if (!bezoekersLijst.contains(bezoeker)) {
            throw new IllegalArgumentException("Bezoeker bestaat niet in deze tour.");
        }
        bezoekersLijst.remove(bezoeker);
    }

    public void voegPersoneelslidToe(Personeelslid personeelslid) {
        if (!personeelsledenLijst.contains(personeelslid)) {
            personeelsledenLijst.add(personeelslid);
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
        return "Tours{" +
                "naam='" + naam + '\'' +
                ", zone=" + zone +
                ", leeftijdsGroep=" + leeftijdsGroep +
                ", activiteiten=" + activiteitenLijst +
                ", personeelsleden=" + personeelsledenLijst +
                ", bezoekers=" + bezoekersLijst + '}';
    }
}