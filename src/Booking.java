import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Booking {

    //dd-mm-yyyy
    Scanner keyboard = new Scanner(System.in);


    public void booking(String bookingStr) {


        DateTimeFormatter datoIndtast = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //DateTimeFormatter omformulere localDate til at kunne skrives in som en string
        //fx i det her format dd-MM-yyyy MM er med stort fordi mm er minutter sp MM er months
        while (true) {

            System.out.println("Indtast dato (dd-MM-yyyy):");
            String enter = keyboard.nextLine();


            if (gyldigDato(enter, datoIndtast)) {

                if (alleredeBooket(enter)) {
                    System.out.println("Denne dato er allerede booket.");
                } else {

                    try (FileWriter writer = new FileWriter("src//appointments.txt", true)) {
                        writer.write("Booking dato: " + enter + "\n");
                        System.out.println("Du har bestilt tid til: " + enter);
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                System.out.println("Venligst indtast dato således (dd-mm-yyyy).");
            }
        }
    }

    boolean alleredeBooket(String dato) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src//appointments.txt"))) {
            String linje;
            while ((linje = reader.readLine()) != null) {
                if (linje.contains("Booking dato: " + dato)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    boolean gyldigDato(String dato, DateTimeFormatter f) {
        try {
            LocalDate.parse(dato, f); //.parse gør at dato stringen bliver konverteret til LocalDate
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        Booking nyBook = new Booking();

        System.out.println("Indtast en booking dag i formatet dd-MM-yyyy");
        String bookingStr = keyboard.nextLine();

        nyBook.booking(bookingStr);

        keyboard.close();

    }

}