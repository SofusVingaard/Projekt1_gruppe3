import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int tast;
        String navn;
        int forkert = 1;
        int countDown = 3;
        boolean keepGoing = true;
        boolean areWeEvenAlive = true;

        while (keepGoing) {
            System.out.println("Velkommen til Harry's Salon ");
            System.out.println("Vores åbningstider er mandag-fredag kl. 10-18");
            System.out.println("Tast 1 for book tid");
            System.out.println("Tast 2 for login");
            System.out.println("tast 0 for at afslutte");
            tast = keyboard.nextInt();
            //clear vores scanner buffer
            keyboard.nextLine();

            if (tast == 0) {
                System.out.println("Tak for i dag");
                keepGoing = false;

            } else if (tast >= 5) {
                System.out.println("ugyldigt");
                return;

            }

            switch (tast) {
                case 1:
                    RetTilBooket.BookEnTid(args);
                    break;
                case 2:
                    System.out.println("Indtast Adgangskode ");
                    String adganskode = "hairyharry";
                    Scanner scanner = new Scanner(System.in);

                    String adgangskodeInput = scanner.nextLine();

                    //Hvis adgangskoden hairyharry bliver indtastet, så skal den sige godkendt, dog hvis andet end hairyharry bliver indtastet skal den sige forkert adgangskode
                    if (adgangskodeInput.equals(adganskode)) {
                        areWeEvenAlive = true;

                        while (areWeEvenAlive) {
                            {
                                System.out.println("Godkendt");

                                //Så bliver vi sendt over til en ny menu med Admin bruger funktioner
                                //ManuelBooking, SletningAfTider,Revisor
                                System.out.println("Tast 1 for Manuel Booking ");
                                System.out.println("Tast 2 for Sletning af tid ");
                                System.out.println("Tast 3 for Revisors Stikprøver ");
                                System.out.println("tast 4 for at logge ud");
                                System.out.println("Tast 0 for at afslutte");

                                //Vi skal kalde til vores ManuelBooking, SletningAfTider og Revisor klassser så alt kan køre på vores Main
                                int input = scanner.nextInt();

                                if (input == 0) {
                                    System.out.println("Tak for i dag");
                                    keepGoing = false;
                                    areWeEvenAlive = false;
                                }

                                switch (input) {
                                    case 1:
                                        RetTilBooket.BookEnTid(args);
                                        break;
                                    case 2:
                                        SletningAfBooking.sletEnTid(args);
                                        break;
                                    case 3:
                                        Revisor.revision(args);
                                        break;
                                    case 4:
                                        areWeEvenAlive = false;
                                }


                            }
                        }
                    } else if (forkert == 3) {
                        System.out.println("du har indtastet password forkert for mange gange, politiet er tilkadlt");
                        keepGoing = false;

                    } else if (adgangskodeInput != "harryhairy") {
                        forkert++;
                        countDown--;
                        System.out.println("Forkert password, du har: " + countDown + " forsøg tilbage");
                    }

            }
        }
    }
}
