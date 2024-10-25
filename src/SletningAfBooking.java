import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SletningAfBooking {
public static void main(String[] args) {
    Scanner lineremover = new Scanner(System.in);
    String filnavn = "src/appointments.txt";
    String linjefjerner = lineremover.nextLine();
    Fjernspecifiklinje(filnavn, linjefjerner);

}



    public static void Fjernspecifiklinje(String filnavn, String linjefjerner) {
        File linjefjerner2 = new File(filnavn);
        List<String> linjer = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("src/appointments.txt"))) {
            String currentLine;
            while ((currentLine = bf.readLine()) != null) ;
            {

                if (currentLine != null && !currentLine.contains((CharSequence) linjefjerner)) {
                    linjer.add(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/appointments.txt"))) {
            for (String l2 : linjer) {
                bw.write(l2);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







