import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Revisor {
    private static final String filnavn = "src/appointments.txt";
    private static final String booket = "Booket af";
    private static final String bogført= "Bogført";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void revision(String[] args) {
        try {
            List<String> linjer = Files.readAllLines(Paths.get(filnavn));
            Scanner scanner = new Scanner(System.in);

            System.out.println("Indtast dato (dd-mm-yyyy) for at se betjente kunder på datoen:");
            String ønsketDatoStr = scanner.nextLine().trim();

            LocalDate ønsketDato;
            try {
                ønsketDato = LocalDate.parse(ønsketDatoStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ugyldigt datoformat. Brug venligst dd-mm-yyyy.");
                return;
            }

            LocalDate today = LocalDate.now();

            // Kontroller om datoen er i dag eller i fremtiden
            if (!ønsketDato.isBefore(today)) {
                System.out.println("Datoen skal være en fortidig dato. Indtast venligst en dato før i dag.");
                return;
            }


            List<String> tiderPåDato = linjer.stream()
                    .filter(linje -> linje.startsWith(ønsketDatoStr) && linje.contains(booket) || linje.contains(bogført))
                    .collect(Collectors.toList());

            if (tiderPåDato.isEmpty()) {
                System.out.println("Der er ikke betjent nogle kunder på denne dato.");
                return;
            }

            System.out.println("Betjente kunder på " + ønsketDato + ":");
            for (int i = 0; i < tiderPåDato.size(); i++) {
                System.out.println((i + 1) + ": " + tiderPåDato.get(i));
            }

            System.out.println("Indtast nummeret på den tid, du vil bogføre:");
            int valg = scanner.nextInt();
            scanner.nextLine();  // For at håndtere linjeskift efter nextInt()

            // Kontroller om valget er gyldigt
            if (valg < 1 || valg > tiderPåDato.size()) {
                System.out.println("Ugyldigt valg. Afslutter programmet.");
                return;
            }

            String valgtTid = tiderPåDato.get(valg - 1);
            String kundedata = "Bogført";
            String opdateretTid = valgtTid.replace(booket, kundedata);
            linjer.set(linjer.indexOf(valgtTid), opdateretTid);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filnavn))) {
                for (String linje : linjer) {
                    writer.write(linje);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Revisor.revision(args);
    }
}