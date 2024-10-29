import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FerieRegistrering {
    private static final String filnavn = "src/appointments.txt";  // Navn på filen
    private static final String ledig = "Ledig tid";              // Tekst for ledige tider
    private static final String ferie = "Ferie";                  // Tekst for ferie

    public static void registrerFerie() {
        try {
            // Læs alle linjer fra filen
            List<String> linjer = Files.readAllLines(Paths.get(filnavn));

            // Scanner til input fra brugeren
            Scanner scanner = new Scanner(System.in);

            // Bed brugeren om at indtaste flere datoer adskilt af komma
            System.out.println("Indtast datoerne (dd-MM-yyyy) du vil markere som ferie, adskilt af komma:");
            String ønskedeDatoer = scanner.nextLine().trim();

            // Splittet datoerne på komma og fjern evt. mellemrum
            List<String> datoListe = Arrays.stream(ønskedeDatoer.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());

            // Gennemgå hver ønsket dato og marker ledige tider som ferie
            for (String ønsketDato : datoListe) {
                List<String> tiderPåDato = linjer.stream()
                        .filter(linje -> linje.startsWith(ønsketDato) && linje.contains(ledig))
                        .collect(Collectors.toList());

                // Marker hver ledig tid på den dato som ferie
                for (String ledigTid : tiderPåDato) {
                    String ferieTid = ledigTid.replace(ledig, ferie);
                    linjer.set(linjer.indexOf(ledigTid), ferieTid);
                }
            }

            // Skriv de opdaterede linjer tilbage til filen
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filnavn))) {
                for (String linje : linjer) {
                    writer.write(linje);
                    writer.newLine();
                }
            }

            System.out.println("De ønskede datoer er nu markeret som 'Ferie'.");
        } catch (IOException e) {
            System.out.println("Fejl ved læsning eller skrivning af filen: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        registrerFerie();
    }
}