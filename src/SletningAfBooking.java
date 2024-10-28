import java.awt.print.Book;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SletningAfBooking {
    private static final String filnavn = "src/appointments.txt";  // Navn på filen
    private static final String booket = "Booket";

    public static void sletEnTid( String[] args){
        try {
            List<String> linjer = Files.readAllLines(Paths.get(filnavn));
            Scanner scanner = new Scanner(System.in);

            System.out.println("indtast dato (dd-mm-yyyy) for at se bookede tider på datoen");
            String ønsketDato = scanner.nextLine().trim();

            List<String> tiderPåDato = linjer.stream()
                    .filter(linje -> linje.startsWith(ønsketDato) && linje.contains(booket))
                    .collect(Collectors.toList());

            if (tiderPåDato.isEmpty()) {
                System.out.println("Der er ingen ledige tider på denne dato.");
                return;
            }

            System.out.println("Booket tider på " + ønsketDato + ":");
            for (int i = 0; i < tiderPåDato.size(); i++) {
                System.out.println((i + 1) + ": " + tiderPåDato.get(i));
            }

            System.out.println("Indtast nummeret på den tid, du vil booke:");
            int valg = scanner.nextInt();
            scanner.nextLine();


            if (valg < 1 || valg > tiderPåDato.size()) {
                System.out.println("Ugyldigt valg. Afslutter programmet.");

                return;

            }

            String valgtTid = tiderPåDato.get(valg - 1);
            String navn="";
            String telefon="";
            String email="";

            String kundedata = "Ledig tid" +navn+telefon+email;
            String opdateretTid = valgtTid.replaceAll("Booket af.*", "Ledig tid");
            linjer.set(linjer.indexOf(valgtTid), opdateretTid);

            System.out.println("Tiden er nu slettet");


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
        TestingAfMain.sletEnTid(args);
    }
}
