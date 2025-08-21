/**
* @author Laroub Rayane
* @version 1.0
*/
public class Adres {
//Zorgt voor het bijhouden van een adres bij het aanmaken van een bezoeker of personeel
    private String straat;
    private int huisnummer;
    private int postcode;
    private String woonplaats;

    public Adres(String straat, int huisnummer, int postcode, String woonplaats) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    public String getStraat() {
        return straat;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
//Geeft alles weer als String ipv object
    @Override
    public String toString() {
        return straat + " " + huisnummer + ", " + postcode + " " + woonplaats;
    }

}
