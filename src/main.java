import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;
        ArrayList<Personeelslid> personeelsleden = new ArrayList<>();
        ArrayList<Activiteit> activiteiten = new ArrayList<>();
        ArrayList<Bezoeker> bezoekersLijst = new ArrayList<>();
        ArrayList<Tours> toursLijst = new ArrayList<>();


        while (running) {
            Heading.header();
            System.out.println("Welkom in het dierenparkapp! \n");
            System.out.println("Kies een optie (Geef het getal in): ");
            System.out.println("1. Aanmaken nieuwe personeelsleden.");
            System.out.println("2. Aanmaken activiteiten");
            System.out.println("3. Aanmaken tours.");
            System.out.println("4. Registreren van een bezoeker");
            System.out.println("5. Toewijzen personeel, dit voegt personeel toe aan een activiteit.");
            System.out.println("6. TInschrijving bezoeker voor een tour.");
            System.out.println("7. Opslaan bezoekerslijst van een tour.");
            System.out.println("8. App verlaten.");
            System.out.print("Maak een keuze: ");

            int keuze = scanner.nextInt();
            switch (keuze) {
                case 1:
                    System.out.println("Geef de functie van het personeelslid in (Gids, Poetsploe of Verzorger): ");
                    String functie = scanner.nextLine();
                    System.out.println("Aanmaken nieuwe personeelsleden.");
                    System.out.print("Voer de naam van het personeelslid in: ");
                    String personeelNaam = scanner.next();
                    System.out.print("Voer de leeftijd van het personeelslid in: ");
                    int personeelLeeftijd = scanner.nextInt();
                    System.out.println("Geef de straatnaam van het adres in: ");
                    String personeelStraatnaam = scanner.next();
                    System.out.print("Geef het huisnummer van het adres in: ");
                    int personeelHuisnummer = scanner.nextInt();
                    System.out.print("Geef de postcode van het adres in: ");
                    int personeelPostcode = scanner.nextInt();
                    System.out.print("Geef de woonplaats van het adres in: ");
                    String personeelWoonplaats = scanner.next();
                    Adres personeelAdres = new Adres(personeelStraatnaam, personeelHuisnummer, personeelPostcode,
                            personeelWoonplaats);
                    System.out.print("Voer de functie van het personeelslid in: ");
                    if (functie == "Gids") {
                        Gids gids = new Gids(personeelNaam, personeelLeeftijd, personeelAdres);
                        personeelsleden.add(gids);
                    } else if (functie == "Poetsploeg") {
                        Poetsploeg poetsploeg = new Poetsploeg(personeelNaam, personeelLeeftijd, personeelAdres);
                        personeelsleden.add(poetsploeg);
                    } else if (functie == "Verzorger") {
                        Verzorger verzorger = new Verzorger(personeelNaam, personeelLeeftijd, personeelAdres);
                        personeelsleden.add(verzorger);
                    } else {
                        System.out.println("Ongeldige functie, probeer het opnieuw.");
                    }
                    System.out.println("Personeelslid aangemaakt: " + personeelNaam + ", Functie: " + functie);
                    break;
                case 2:
                    System.out.println("Aanmaken activiteiten.");
                    System.out.print(
                            "Voer de categorie van de activiteit in (dierenveld, eetstand, speeltuin, show, anderen): ");
                    String categorie = scanner.nextLine();
                    System.out.print("Voer de naam van de activiteit in: ");
                    String naam = scanner.nextLine();
                    System.out.print("Voer de beschrijving van de activiteit in: ");
                    String beschrijving = scanner.nextLine();
                    Activiteit activiteit = new Activiteit(categorie, naam, beschrijving);
                    System.out.println("Activiteit aangemaakt: " + activiteit);
                    activiteiten.add(activiteit);
                    break;
                case 3:
                    System.out.println("Aanmaken tours.");
                    System.out.print("Voer de naam van de tour in: ");
                    String tourNaam = scanner.nextLine();
                    System.out.println("Geef de maximum capaciteit van de zone in: ");
                    int maximumCapaciteit = scanner.nextInt();
                    System.out.println("Voeg activiteiten toe aan de tour (voer 'klaar' in om te stoppen):");
                    boolean activiteitenToevoegen = true;
                    HashSet<Activiteit> activiteitenSet = new HashSet<>(activiteiten);
                    for (Activiteit act : activiteitenSet) {
                        System.out.println(act);
                    }
                    while (activiteitenToevoegen) {
                        System.out.print("Voer de naam van de activiteit in (of 'klaar' om te stoppen): ");
                        String activiteitNaam = scanner.nextLine();
                        if (activiteitNaam.equalsIgnoreCase("klaar")) {
                            activiteitenToevoegen = false;
                        } else {
                            Activiteit gevondenActiviteit = null;
                            for (Activiteit act : activiteiten) {
                                if (act.getNaam().equalsIgnoreCase(activiteitNaam)) {
                                    gevondenActiviteit = act;
                                    break;
                                }
                            }
                            if (gevondenActiviteit != null) {
                                activiteitenSet.add(gevondenActiviteit);
                                System.out.println("Activiteit toegevoegd: " + gevondenActiviteit);
                            } else {
                                System.out.println("Activiteit niet gevonden.");
                            }
                        }
                    }
                    Zone zone = new Zone(maximumCapaciteit, activiteitenSet);
                    Tours tour = new Tours(tourNaam, zone);
                    System.out.println("Tour aangemaakt: " + tour.getNaam() + " met zone: " + tour.getZone());
                    break;
                case 4:
                    System.out.println("Registreren van een bezoeker.");
                    System.out.print("Voer de naam van de bezoeker in: ");
                    String bezoekerNaam = scanner.nextLine();
                    System.out.print("Voer de leeftijd van de bezoeker in: ");
                    int bezoekerLeeftijd = scanner.nextInt();
                    String leeftijdscategorie = Leeftijdscategorie(bezoekerLeeftijd);
                    System.out.print("Geef de straatnaam van het adres in: ");
                    String straatnaam = scanner.nextLine();
                    System.out.print("Geef het huisnummer van het adres in: ");
                    int huisnummer = scanner.nextInt();
                    System.out.print("Geef de postcode van het adres in: ");
                    int postcode = scanner.nextInt();
                    System.out.print("Geef de woonplaats van het adres in: ");
                    String woonplaats = scanner.nextLine();
                    Adres adres = new Adres(straatnaam, huisnummer, postcode, woonplaats);
                    Bezoeker bezoeker = new Bezoeker(bezoekerNaam, bezoekerLeeftijd, adres, leeftijdscategorie);
                    bezoekersLijst.add(bezoeker);
                    System.out.println("Bezoeker geregistreerd: " + bezoeker);
                    break;
                case 5:
                    System.out.println("Toewijzen personeel aan een activiteit.");
                    for (int i = 0; i < activiteiten.size(); i++) {
                        System.out.println(i+1 + ". " + activiteiten.get(i));
                    }
                    System.out.print("Kies een activiteit (nummer): ");
                    int activiteitIndex = scanner.nextInt() - 1;
                    if (activiteitIndex < 0 || activiteitIndex >= activiteiten.size()) {
                        System.out.println("Ongeldige activiteit, probeer het opnieuw.");
                        break;
                    }
                    Activiteit gekozenActiviteit = activiteiten.get(activiteitIndex);
                    for (int i = 0; i < personeelsleden.size(); i++) {
                        System.out.println(i+1 + ". " + personeelsleden.get(i));
                    }
                    System.out.println("Kies een personeelslid om toe te wijzen aan de activiteit:");
                    int personeelIndex = scanner.nextInt() - 1;
                    if (personeelIndex < 0 || personeelIndex >= personeelsleden.size())
                    {
                        System.out.println("Ongeldig personeelslid, probeer het opnieuw.");
                        break;
                    }
                    Personeelslid gekozenPersoneelslid = personeelsleden.get(personeelIndex);
                    gekozenActiviteit.addPersoneelslid(gekozenPersoneelslid);
                    System.out.println("Personeelslid " + gekozenPersoneelslid.getNaam() + " is toegevoegd aan de activiteit: "
                            + gekozenActiviteit.getNaam());
                    break;
                case 6:
                    System.out.println("Inschrijving bezoeker voor een tour.");
                    System.out.println("Beschikbare tours:");
                    for (int i = 0; i < toursLijst.size(); i++) {
                        System.out.println(i + 1 + ". " + toursLijst.get(i));
                    }
                    System.out.print("Kies een tour (nummer): ");
                    int tourIndex = scanner.nextInt() - 1;
                    if (tourIndex < 0 || tourIndex >= toursLijst.size()) {
                        System.out.println("Ongeldige tour, probeer het opnieuw.");
                        break;
                    }
                    Tours gekozenTour = toursLijst.get(tourIndex);
                    System.out.println("Beschikbare bezoekers:");
                    for (int i = 0; i < bezoekersLijst.size(); i++) {
                        System.out.println(i + 1 + ". " + bezoekersLijst.get(i));
                    }
                    System.out.print("Kies een bezoeker om in te schrijven (nummer): ");
                    int bezoekerIndex = scanner.nextInt() - 1;
                    if (bezoekerIndex < 0 || bezoekerIndex >= bezoekersLijst.size
()) {
                        System.out.println("Ongeldige bezoeker, probeer het opnieuw.");
                        break;
                    }
                    Bezoeker gekozenBezoeker = bezoekersLijst.get(bezoekerIndex);
                    gekozenTour.voegBezoekerToe(gekozenBezoeker);
                    System.out.println("Bezoeker " + gekozenBezoeker.getNaam() + " is ingeschreven voor de tour: "
                            + gekozenTour.getNaam());
                    break;
                case 7:
                    System.out.println("Opslaan bezoekerslijst van een tour.");
                    System.out.println("Beschikbare tours:");
                    for (int i = 0; i < toursLijst.size(); i++) {
                        System.out.println(i + 1 + ". " + toursLijst.get(i));
                    }
                    System.out.print("Kies een tour om de bezoekerslijst op te slaan (nummer): ");
                    int tourOpslaanIndex = scanner.nextInt() - 1;
                    if (tourOpslaanIndex < 0 || tourOpslaanIndex >= toursLijst.size()) {
                        System.out.println("Ongeldige tour, probeer het opnieuw.");
                        break;
                    }
                    Tours tourOpslaan = toursLijst.get(tourOpslaanIndex);
                    String sanitizedTitle = tourOpslaan.getNaam().replaceAll("[^a-zA-Z0-9]", "_");
                    try {PrintWriter writer = new PrintWriter("Bezoekerslijst_" + sanitizedTitle + ".txt");
                        for (Bezoeker bezoekerInTour : tourOpslaan.getTourBezoekers()) {
                            writer.println(bezoekerInTour);
                        }

                    } catch (java.io.IOException e) {
                        System.out.println("Fout bij het opslaan van de bezoekerslijst: " + e.getMessage());
                    }
                    finally {
                        writer.close();
                    }

                    break;
                case 8:
                    System.out.println("App wordt afgesloten, tot ziens.");
                    running = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer het opnieuw.");
            }
        }
        scanner.close();
        System.out.println("Bedankt voor het gebruiken van de dierenparkapp!");
    }

    public static String Leeftijdscategorie(int bezoekerLeeftijd) {
        if (bezoekerLeeftijd > 12) {
            return Leeftijdcategorieen.MIN_TWAALF.name();
        } else if (bezoekerLeeftijd >= 12 && bezoekerLeeftijd < 18) {
            return Leeftijdcategorieen.KINDEREN.name();
        } else if (bezoekerLeeftijd >= 18 && bezoekerLeeftijd < 65) {
            return Leeftijdcategorieen.VOLWASSENEN.name();
        } else {
            return Leeftijdcategorieen.VIJFENZESTIG_PLUS.name();
        }
    }
    public static void getBezoekers(Tours tour) {
        for (Bezoeker bezoeker : tour.getBezoekersLijst()) {
            System.out.println(bezoeker);
        }
    }
}