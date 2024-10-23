import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Booking {

    //dd-mm-yyyy
    FileWriter writer;
    Scanner keyboard = new Scanner(System.in);
    static final String DatePattern = "^\\d{2}-\\d{2}-\\d{4}$";

    void booking() {

        Pattern pattern = Pattern.compile(DatePattern);

        while (true) {

            System.out.println("indtast dato (dd-mm-yyyy):");
            String enter = keyboard.nextLine();
            Matcher matcher = pattern.matcher(enter);

            if (matcher.matches()) {
                try {
                    writer = new FileWriter("src//appointments.txt");
                    writer.write("Booking dato: "+ enter +" ");
                    writer.close();
                    System.out.println("du har bestilt tid til: " + enter);
                    break;

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("venlist indtast dato således (dd-mm-yyyy)");
            }
        }
    }

}


