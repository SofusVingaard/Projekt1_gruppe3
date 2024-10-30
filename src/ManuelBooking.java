/*import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/*
//public class ManuelBooking { BLEVET SAT PÅ PAUSE INDTIL I MORGEN EFTER TEAMS MØDE
    //DatatTimerFormatter til at oprette datoerne
    private static final DateTimeFormatter Dataformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //Til at oprette en dato som objek til vores appointments
    public void manuelBooking (String datoStr) {
        try {
            // Laver en dato til et objekt som betegnes som dato
            LocalDate dato = LocalDate.parse(datoStr, Dataformatter);

            // Åbner vores bookinglist Appointments
            FileWriter fileWriter = new FileWriter("src//appointments.txt", true);

            // Skriver selve den Manuelle booking ind
            fileWriter.write("Manuel Booking dato: " + dato.format(Dataformatter) + "\n");

            //Lukker filen
            fileWriter.close();

            //Metoden til at fuldføre og godkende datatypen "dd-MM-yyy"
            System.out.println("Booking bekærftet " + dato.format(Dataformatter));
        } catch (IOException e) {
            System.out.println("Fejl under skrivning til filen " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ugyldigt datoformat. Brug venligst formatet dd-MM-yyy");
        }
    }
    // Kalder til vores Revisor/Bruger Main-Metoden
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       ManuelBooking bookingTilFil = new ManuelBooking();
        System.out.println("Indtast Booking i formatet dd-MM-yyyy ");
        String datoStr = scanner.nextLine();

        // Kalder selve metoden for at skrive Bookingen ind som en Manuel Booking
       bookingTilFil.manuelBooking(datoStr);

        //Lukker scanneren og gennemføre programmet
        scanner.close();
    }
}*/

 */

