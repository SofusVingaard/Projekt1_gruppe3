import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OpretDatoer {

    // Datoformat og tidsformat
    private static final DateTimeFormatter datoFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter tidsFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private static final String filnavn = "src/appointments.txt";  // Navn på filen

    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter(filnavn, true)) {  // Åben filen i append-mode
            LocalDate dagsDato = LocalDate.now();  // Hent dags dato
            LocalTime startTid = LocalTime.of(10, 0);  // Starttidspunkt (10:00)
            LocalTime slutTid = LocalTime.of(18, 0);   // Sluttidspunkt (18:00)

            // Loop gennem de næste 14 dage
            for (int dag = 0; dag < 14; dag++) {
                LocalDate dato = dagsDato.plusDays(dag);  // Beregn hver ny dato

                // Loop gennem tidsintervaller mellem 10:00 og 18:00
                for (LocalTime tid = startTid; tid.isBefore(slutTid.plusHours(1)); tid = tid.plusHours(1)) {
                    String datoTid = dato.format(datoFormatter) + " " + tid.format(tidsFormatter);
                    fileWriter.write(datoTid + "\n");  // Skriv dato og tid til fil
                }
            }

            System.out.println("Datoer og 1-times intervaller er blevet tilføjet til filen: " + filnavn);
        } catch (IOException e) {
            System.out.println("Fejl under skrivning til filen: " + e.getMessage());
        }
    }
}