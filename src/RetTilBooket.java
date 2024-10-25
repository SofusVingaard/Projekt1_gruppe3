import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RetTilBooket {
    private static final String filnavn = "src/appointments.txt";  // Navn på filen
    private static final String Ledige = "Ledig tid";    // Tekst for ledig tid

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

            // Opret kundedata-strengen
            String kundedata = "Booket af [" + navn + ", tlf: " + telefon + ", email: " + email + "]";

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
