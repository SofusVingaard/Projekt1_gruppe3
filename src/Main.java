import java.awt.print.Book;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int tast;
        String navn;

        while (true) {
            System.out.println("Velkommen til Harry's Salon ");
            System.out.println("Vores åbningstider er mandag-fredag kl. 10-18");
            System.out.println("Tast 1 for book tid");
            System.out.println("Tast 2 for slet tid");
            System.out.println("Tast 3 for opretning af kunde");
            System.out.println("tast 0 for at afslutte");

            tast = keyboard.nextInt();

            if (tast == 0) {
                System.out.println("Tak for i dag");
                break;
            } else if (tast>=4) {
                System.out.println("Ugyldig valgmulighed, prøv igen");
                System.out.println();
            }
            switch (tast){
                case 1:
                    Booking a1=new Booking(); break;

                case 2:
                    Fridage ferieTilFil = new Fridage();

                    System.out.print("Indtast feriedag i formatet dd-MM-yyyy: ");
                    String datoStr = keyboard.nextLine();

                    // Kald metoden for at markere datoen som en feriedag
                    ferieTilFil.markereFerie(datoStr);

                    keyboard.close();


            }
        }
    }
}