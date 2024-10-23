import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Fridage {

    // DateTimeFormatter bruges til at bruge tidsformat dd-MM-yyyy
    private static final DateTimeFormatter DATOFORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Metode til at tilføje en feriedag til filen "appointments.txt"
    public void markereFerie(String datoStr) {
        try {
            // Laver den indtastede dato til et dato objekt
            LocalDate dato = LocalDate.parse(datoStr, DATOFORMATTER);

            // Åbner filen appointments
            FileWriter fileWriter = new FileWriter("src//appointments.txt", true);

            // Skriver feriedagen ind i filen
            fileWriter.write("Feriedag: " + dato.format(DATOFORMATTER) + "\n");

            // Luk filen
            fileWriter.close();

            System.out.println("Feriedag tilføjet: " + dato.format(DATOFORMATTER));
        } catch (IOException e) {
            System.out.println("Fejl under skrivning til filen: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ugyldigt datoformat. Brug venligst formatet dd-MM-yyyy.");
        }
    }

    // Main-metode til at interagere med brugeren
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fridage ferieTilFil = new Fridage();

        System.out.print("Indtast feriedag i formatet dd-MM-yyyy: ");
        String datoStr = scanner.nextLine();

        // Kald metoden for at markere datoen som en feriedag
        ferieTilFil.markereFerie(datoStr);

        scanner.close();
    }
}