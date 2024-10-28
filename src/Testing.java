import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Testing {

    // Datoformat og tidsformat
    private static final DateTimeFormatter datoFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter tidsFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private static final String filnavn = "src/appointments.txt";  // Navn på filen

    public static void main(String[] args) {
        Set<String> eksisterendeDatoer = new HashSet<>();

        // Læs eksisterende datoer fra filen
        try (BufferedReader reader = new BufferedReader(new FileReader(filnavn))) {
            String linje;
            while ((linje = reader.readLine()) != null) {
                eksisterendeDatoer.add(linje.split(" - ")[0]);  // Gem kun dato og tid
            }
        } catch (IOException e) {
            System.out.println("Fejl under læsning af filen: " + e.getMessage());
        }

        try (FileWriter fileWriter = new FileWriter(filnavn, true)) {  // Åben filen i append-mode
            LocalDate dagsDato = LocalDate.now();  // Hent dags dato
            LocalTime startTid = LocalTime.of(10, 0);  // Starttidspunkt (10:00)
            LocalTime slutTid = LocalTime.of(17, 0);   // Sluttidspunkt (18:00)

            // Loop gennem de næste 14 dage
            for (int dag = 0; dag < 14; dag++) {
                LocalDate dato = dagsDato.plusDays(dag);  // Beregn hver ny dato

                // Loop gennem tidsintervaller mellem 10:00 og 18:00
                for (LocalTime tid = startTid; tid.isBefore(slutTid.plusHours(1)); tid = tid.plusHours(1)) {
                    String datoTid = dato.format(datoFormatter) + " " + tid.format(tidsFormatter);
                    String besked;

                    // Tjek om datoTid allerede findes
                    if (eksisterendeDatoer.contains(datoTid)) {
                        continue; // Hvis datoen allerede findes, spring over den
                    }

                    // Tjek om det er weekend
                    if (dato.getDayOfWeek().getValue() == 6 || dato.getDayOfWeek().getValue() == 7) {
                        besked = "Weekend"; // Kun weekend
                    } else {
                        besked = "Ledig tid"; // Kun ledig tid
                    }

                    fileWriter.write(datoTid + " - " + besked + "\n");  // Skriv dato, tid og tekst til fil
                }
            }

            System.out.println("Nye datoer og 1-times intervaller er blevet tilføjet til filen: " + filnavn);
        } catch (IOException e) {
            System.out.println("Fejl under skrivning til filen: " + e.getMessage());
        }
    }
}