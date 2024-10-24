import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SletningAfBooking {
    Scanner keyboard = new Scanner(System.in);

    void bookettid(){

    }

    public static void main(String[] args) {
        String dato;
        String tidspunkt;

        DateTimeFormatter tidspunktIndtast = DateTimeFormatter.ofPattern("HH:mm");

        DateTimeFormatter datoIndtast = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Scanner slettefunktion = new Scanner(System.in);
        System.out.println("Skriv den dato du har booket ved dd-mm-yyyy");
        dato = slettefunktion.nextLine();

        System.out.println("Skriv tidspunkt du har booket");
        tidspunkt = slettefunktion.nextLine();

    }
}



