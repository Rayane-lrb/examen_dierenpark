import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Laroub Rayane
 * @version 2.0
 */
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
            System.out.println("5. Toewijzen personeel een activiteit.");
            System.out.println("6. Inschrijving bezoeker voor een tour.");
            System.out.println("7. Opslaan bezoekerslijst van een tour.");
            System.out.println("8. App verlaten.");
            System.out.print("Maak een keuze: ");

            int keuze = Integer.parseInt(scanner.nextLine());
            switch (keuze) {
                case 1:
                    try {
                        System.out.print("Geef de functie van het personeelslid in (Gids, Poetsploeg of Verzorger): ");
                        String functie = scanner.nextLine();
                        if (!functie.equalsIgnoreCase("Gids") && !functie.equalsIgnoreCase("Poetsploeg")
                                && !functie.equalsIgnoreCase("Verzorger")) {
                            System.out.println("Ongeldige functie, probeer het opnieuw.");
                            break;
                        }

                        System.out.print("Voer de naam van het personeelslid in: ");
                        String personeelNaam = scanner.nextLine();

                        System.out.print("Voer de leeftijd van het personeelslid in: ");
                        int personeelLeeftijd = Integer.parseInt(scanner.nextLine());

                        System.out.print("Geef de straatnaam van het adres in: ");
                        String personeelStraatnaam = scanner.nextLine();

                        System.out.print("Geef het huisnummer van het adres in: ");
                        int personeelHuisnummer = Integer.parseInt(scanner.nextLine());

                        System.out.print("Geef de postcode van het adres in: ");
                        int personeelPostcode = Integer.parseInt(scanner.nextLine());

                        System.out.print("Geef de woonplaats van het adres in: ");
                        String personeelWoonplaats = scanner.nextLine();

                        Adres personeelAdres = new Adres(personeelStraatnaam, personeelHuisnummer, personeelPostcode,
                                personeelWoonplaats);
                        if (functie.equalsIgnoreCase("Gids")) {
                            Gids gids = new Gids(personeelNaam, personeelLeeftijd, personeelAdres);
                            personeelsleden.add(gids);
                        } else if (functie.equalsIgnoreCase("Poetsploeg")) {
                            Poetsploeg poetsploeg = new Poetsploeg(personeelNaam, personeelLeeftijd, personeelAdres);
                            personeelsleden.add(poetsploeg);
                        } else if (functie.equalsIgnoreCase("Verzorger")) {
                            Verzorger verzorger = new Verzorger(personeelNaam, personeelLeeftijd, personeelAdres);
                            personeelsleden.add(verzorger);
                        }
                        System.out.println("Personeelslid aangemaakt: " + personeelNaam + ", Functie: " + functie);
                        break;
                    } catch (Exception e) {
                        System.out.println("Ongeldige invoer, probeer het opnieuw.");
                        break;
                    }

                case 2:
                    try {
                        System.out.println("Aanmaken activiteiten.");
                        System.out.print(
                                "Voer de categorie van de activiteit in (dierenveld, eetstand, speeltuin, show, anderen): ");
                        String categorie = scanner.nextLine();
                        System.out.print("Voer de naam van de activiteit in: ");
                        String naam = scanner.nextLine();
                        System.out.print("Voer de beschrijving van de activiteit in: ");
                        String beschrijving = scanner.nextLine();
                        Activiteit activiteit = new Activiteit(categorie, naam, beschrijving);
                        System.out.println("Activiteit aangemaakt: " + activiteit.toString());
                        activiteiten.add(activiteit);
                        break;
                    } catch (Exception e) {
                        System.out.println("Ongeldige invoer, probeer het opnieuw.");
                        break;
                    }
                case 3:
                    try {
                        System.out.println("Aanmaken tours.");
                        System.out.print("Voer de naam van de tour in: ");
                        String tourNaam = scanner.nextLine();
                        System.out.print("Geef de maximum capaciteit van de zone in: ");
                        int maximumCapaciteit = Integer.parseInt(scanner.nextLine());
                        System.out.println("Voeg activiteiten toe aan de tour (voer 'klaar' in om te stoppen):");
                        if (activiteiten.isEmpty()) {
                            System.out.println("Er zijn geen activiteiten beschikbaar. Maak eerst activiteiten aan.");
                            break;
                        }
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
                        System.out.print("Geef het minimum leeftijd voor dit tour: ");
                        int minLeeftijd = Integer.parseInt(scanner.nextLine());
                        Tours tour = new Tours(tourNaam, zone, minLeeftijd);
                        toursLijst.add(tour);
                        System.out.println(
                                "Tour aangemaakt: " + tour.getNaam() + " met zone: " + tour.getZone().toString() + "minimum leeftijd: " + tour.getMinLeefijd());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ongeldige invoer, probeer het opnieuw.");
                        break;
                    }
                case 4:
                    try {
                        System.out.println("Registreren van een bezoeker.");
                        System.out.print("Voer de naam van de bezoeker in: ");
                        String bezoekerNaam = scanner.nextLine();
                        System.out.print("Voer de leeftijd van de bezoeker in: ");
                        int bezoekerLeeftijd = Integer.parseInt(scanner.nextLine());
                        String leeftijdscategorie = Leeftijdscategorie(bezoekerLeeftijd);
                        System.out.print("Geef de straatnaam van het adres in: ");
                        String straatnaam = scanner.nextLine();
                        System.out.print("Geef het huisnummer van het adres in: ");
                        int huisnummer = Integer.parseInt(scanner.nextLine());
                        System.out.print("Geef de postcode van het adres in: ");
                        int postcode = Integer.parseInt(scanner.nextLine());
                        System.out.print("Geef de woonplaats van het adres in: ");
                        String woonplaats = scanner.nextLine();
                        Adres adres = new Adres(straatnaam, huisnummer, postcode, woonplaats);
                        Bezoeker bezoeker = new Bezoeker(bezoekerNaam, bezoekerLeeftijd, adres, leeftijdscategorie);
                        bezoekersLijst.add(bezoeker);
                        System.out.println("Bezoeker geregistreerd: " + bezoeker);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ongeldige invoer, probeer het opnieuw.");
                        break;
                    }
                case 5:
                    System.out.println("Toewijzen personeel aan een activiteit.");
                    if (activiteiten.isEmpty()) {
                        System.out.println("Er zijn geen activiteiten beschikbaar. Maak eerst activiteiten aan.");
                        break;
                    }
                    for (int i = 0; i < activiteiten.size(); i++) {
                        System.out.println(i + 1 + ". " + activiteiten.get(i));
                    }
                    System.out.print("Kies een activiteit (nummer): ");
                    int activiteitIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (activiteitIndex < 0 || activiteitIndex >= activiteiten.size()) {
                        System.out.println("Ongeldige activiteit, probeer het opnieuw.");
                        break;
                    }
                    if (personeelsleden.isEmpty()) {
                        System.out.println("Er zijn geen personeelsleden beschikbaar. Maak eerst personeelsleden aan.");
                        break;
                    }
                    Activiteit gekozenActiviteit = activiteiten.get(activiteitIndex);
                    for (int i = 0; i < personeelsleden.size(); i++) {
                        System.out.println(i + 1 + ". " + personeelsleden.get(i));
                    }
                    System.out.print("Kies een personeelslid om toe te wijzen aan de activiteit:");
                    int personeelIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (personeelIndex < 0 || personeelIndex >= personeelsleden.size()) {
                        System.out.println("Ongeldig personeelslid, probeer het opnieuw.");
                        break;
                    }
                    Personeelslid gekozenPersoneelslid = personeelsleden.get(personeelIndex);
                    gekozenActiviteit.addPersoneelslid(gekozenPersoneelslid);
                    System.out.println(
                            "Personeelslid " + gekozenPersoneelslid.getNaam() + " is toegevoegd aan de activiteit: "
                                    + gekozenActiviteit.getNaam());
                    break;
                case 6:
                    System.out.println("Beschikbare tours:");
                    if (toursLijst.isEmpty()) {
                        System.out.println("Er zijn geen tours beschikbaar. Maak eerst tours aan.");
                        break;
                    }
                    for (int i = 0; i < toursLijst.size(); i++) {
                        System.out.println(i + 1 + ". " + toursLijst.get(i));
                    }
                    System.out.print("Kies een tour (nummer): ");
                    int tourIndex = Integer.parseInt(scanner.nextLine()) - 1;
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
                    if (bezoekersLijst.isEmpty()) {
                        System.out.println("Er zijn geen bezoekers beschikbaar. Registreer eerst bezoekers.");
                        break;
                    }
                    int bezoekerIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (bezoekerIndex < 0 || bezoekerIndex >= bezoekersLijst.size()) {
                        System.out.println("Ongeldige bezoeker, probeer het opnieuw.");
                        break;
                    }
                    Bezoeker gekozenBezoeker = bezoekersLijst.get(bezoekerIndex);
                    if (gekozenBezoeker.getLeeftijd() < gekozenTour.getMinLeefijd()) {
                        System.out.println("Bezoeker is te jong voor dit tour.");
                        break;
                    }
                    gekozenTour.voegBezoekerToe(gekozenBezoeker);
                    System.out.println("Bezoeker " + gekozenBezoeker.getNaam() + " is ingeschreven voor de tour: "
                            + gekozenTour.getNaam());
                    break;
                case 7:
                    System.out.println("Opslaan bezoekerslijst van een tour.");
                    System.out.println("Beschikbare tours:");
                    if (toursLijst.isEmpty()) {
                        System.out.println("Er zijn geen tours beschikbaar. Maak eerst tours aan.");
                        break;
                    }
                    for (int i = 0; i < toursLijst.size(); i++) {
                        System.out.println(i + 1 + ". " + toursLijst.get(i));
                    }
                    System.out.print("Kies een tour om de bezoekerslijst op te slaan (nummer): ");
                    int tourOpslaanIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (tourOpslaanIndex < 0 || tourOpslaanIndex >= toursLijst.size()) {
                        System.out.println("Ongeldige tour, probeer het opnieuw.");
                        break;
                    }
                    Tours tourOpslaan = toursLijst.get(tourOpslaanIndex);
                    String sanitizedTitle = tourOpslaan.getNaam().replaceAll("[^a-zA-Z0-9]", "_");
                    try {
                        PrintWriter writer = new PrintWriter("Bezoekerslijst_" + sanitizedTitle + ".txt");
                        writer.println("Aantal bezoekers voor deze tour: " + Bezoeker.getAantalBezoekers());
                        for (Bezoeker bezoekerInTour : tourOpslaan.getBezoekersLijst()) {
                            writer.println("- " + bezoekerInTour);
                        }
                        writer.close();
                    } catch (java.io.IOException e) {
                        System.out.println("Fout bij het opslaan van de bezoekerslijst: " + e.getMessage());
                    }
                    System.out.println("Succesvol opgeslagen bezoekerslijst voor tour: " + tourOpslaan.getNaam());

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
}