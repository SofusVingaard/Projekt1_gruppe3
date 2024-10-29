import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RetTilBooket {
    private static final String filnavn = "src/appointments.txt";  // Navn på filen
    private static final String Ledige = "Ledig tid";    // Tekst for ledig tid

    int klip1 = 200;
    int klip2 = 250;
    int klip3 = 400;
    int klip4 = 500;
    int klip5 = 100;

    public static void BookEnTid(String[] args) {
        try {
            // Læs alle linjer fra filen
            List<String> linjer = Files.readAllLines(Paths.get(filnavn));

            // Scanner til input fra brugeren
            Scanner scanner = new Scanner(System.in);

            // Bed brugeren om at indtaste en dato
            System.out.println("Indtast den dato (dd-mm-yyyy), du vil se ledige tider for:");
            String ønsketDato = scanner.nextLine().trim();

            // Filtrer tiderne efter den ønskede dato
            List<String> tiderPåDato = linjer.stream()
                    .filter(linje -> linje.startsWith(ønsketDato) && linje.contains(Ledige))
                    .collect(Collectors.toList());

            // Hvis der ikke er nogen ledige tider på den ønskede dato
            if (tiderPåDato.isEmpty()) {
                System.out.println("Der er ingen ledige tider på denne dato.");
                return;
            }

            // Vis de ledige tider på den ønskede dato
            System.out.println("Ledige tider på " + ønsketDato + ":");
            for (int i = 0; i < tiderPåDato.size(); i++) {
                System.out.println((i + 1) + ": " + tiderPåDato.get(i));  // Vis linje nummer og indhold
            }

            // Bed brugeren om at vælge en tid
            System.out.println("Indtast nummeret på den tid, du vil booke:");
            int valg = scanner.nextInt();
            scanner.nextLine();  // For at håndtere linjeskift efter nextInt()

            // Kontroller om valget er gyldigt
            if (valg < 1 || valg > tiderPåDato.size()) {
                System.out.println("Ugyldigt valg. Afslutter programmet.");
                return;
            }

            // Hent den valgte linje fra de ledige tider
            String valgtTid = tiderPåDato.get(valg - 1);

            // Indsaml kundedata
            System.out.println("Indtast kundens navn:");
            String navn = scanner.nextLine();

            System.out.println("Indtast kundens telefonnummer:");
            String telefon = scanner.nextLine();

            System.out.println("Indtast kundens e-mail:");
            String email = scanner.nextLine();


            System.out.println("Vælg en af de følgende");
            System.out.println("1. Herreklip (200 kr. ) ");
            System.out.println("2. Herreklip med skæg (250 kr.)");
            System.out.println("3. Dameklip (400 kr. )");
            System.out.println("4. Dameklip og hårvask (500 kr. )");
            System.out.println("5. Børneklip (100 kr. )");

            int choice = scanner.nextInt();
            double serviceCost = 0;

            switch (choice) {
                case 1:
                    serviceCost = 200;
                    break;
                case 2:
                    serviceCost = 250;
                    break;
                case 3:
                    serviceCost = 400;
                    break;
                case 4:
                    serviceCost = 500;
                    break;
                case 5:
                    serviceCost = 100;
                    break;
                default:
                    System.out.println("Ugyldigt");
                    return;
            }
            System.out.println("Tilføj produkt til kurv");
            System.out.println("1. Harriet's Shampoo (79 kr. )");
            System.out.println("2. Harriet's Conditioner (99 kr. )");
            System.out.println("3. Harry's Shampoo (49 kr. )");
            System.out.println("4. Harry's Conditioner (59 kr. )");
            System.out.println("5. Børste-Buddy (109 kr. )");
            System.out.println("6. Tast 0 for ingen");

            int addOn = scanner.nextInt();
            double productCost = 0;

            switch (addOn) {
                case 1:
                    productCost = 79;
                    break;
                case 2:
                    productCost = 99;
                    break;
                case 3:
                    productCost = 49;
                    break;
                case 4:
                    productCost = 59;
                    break;
                case 5:
                    productCost = 109;
                    break;
                case 0:
                    productCost = 0;
                    break;
                default:
                    System.out.println("Ugyldigt");
            }

            // Opret kundedata-strengen
            String kundedata = "Booket af [" + navn + ", tlf: " + telefon + ", email: " + email +" "+ (serviceCost+productCost)+" kr]";

            // Erstat "Ledig tid" med kundedata i den valgte linje
            String opdateretTid = valgtTid.replace(Ledige, kundedata);
            linjer.set(linjer.indexOf(valgtTid), opdateretTid);  // Opdater linjen i den originale liste

            // Skriv de opdaterede linjer tilbage til filen
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filnavn))) {
                for (String linje : linjer) {
                    writer.write(linje);
                    writer.newLine();
                }
            }

            System.out.println("Tiden " + valgtTid + " er nu markeret som 'Booket' med kundedata.");
        } catch (IOException e) {
            System.out.println("Fejl ved læsning eller skrivning af filen: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        RetTilBooket.BookEnTid(args);
    }

}
