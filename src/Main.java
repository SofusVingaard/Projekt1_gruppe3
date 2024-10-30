import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int tast;
        String navn;
        int forkert=0;
        boolean keepGoing=true;

        while (keepGoing) {
            System.out.println("Velkommen til Harry's Salon ");
            System.out.println("Vores åbningstider er mandag-fredag kl. 10-18");
            System.out.println("Tast 1 for book tid");
            System.out.println("Tast 2 for slet tid");
            System.out.println("Tast 3 for opretning af kunde");
            System.out.println("Tast 4 for login");
            System.out.println("tast 0 for at afslutte");
            tast = keyboard.nextInt();


            if (tast == 0) {
                System.out.println("Tak for i dag");
                keepGoing=false;
                
            } else if (tast>=5) {
                System.out.println("ugyldigt");
                return;
                
            }

            switch (tast){
                case 1:
                    RetTilBooket.BookEnTid(args);
                    break;
                    
                case 2:
                    SletningAfBooking.sletEnTid(args);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Indtast Adgangskode ");
                    String adganskode = "hairyharry";
                    Scanner scanner = new Scanner(System.in);

                    String adgangskodeInput = scanner.nextLine();

                    //Hvis adgangskoden hairyharry bliver indtastet, så skal den sige godkendt, dog hvis andet end hairyharry bliver indtastet skal den sige forkert adgangskode
                    if (adgangskodeInput.equals(adganskode)) {

                        while (keepGoing) {
                            {
                                System.out.println("Godkendt");

                                //Så bliver vi sendt over til en ny menu med Admin bruger funktioner
                                //ManuelBooking, SletningAfTider,Revisor
                                System.out.println("Tast 1 for Manuel Booking ");
                                System.out.println("Tast 2 for Sletning af tid ");
                                System.out.println("Tast 3 for Revisors Stikprøver ");
                                System.out.println("Tast 0 for at afslutte");

                                //Vi skal kalde til vores ManuelBooking, SletningAfTider og Revisor klassser så alt kan køre på vores Main
                                int input = scanner.nextInt();

                                if (input == 0) {
                                    System.out.println("Tak for i dag");
                                    keepGoing=false;
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
                                }


                            }
                        }
                    } else if (forkert==3) {
                        System.out.println("du har indtastet password forkert for mange gange, politiet er tilkadlt");
                        keepGoing=false;

                    } else if (adgangskodeInput !="harryhairy") {
                            forkert++;
                        System.out.println("ugyldig");
                    }
            
            /*else if (tast == 1) {
                RetTilBooket.BookEnTid(args);

            } else if (tast == 2) {
                SletningAfBooking.sletEnTid(args);

            } else if (tast == 3) {
                //Opretkunde Klasse


            } else if (tast == 4) {
                //Så skal den fremvise vores Admin bruger funktioner

                //Efter man har tastet 9, skal der bedes om kodeordet "hairyarry" som sender os videre vores Admin bruger

                System.out.println("Indtast Adgangskode ");
                String adganskode = "hairyharry";
                Scanner scanner = new Scanner(System.in);

                String adgangskodeInput = scanner.nextLine();

                //Hvis adgangskoden hairyharry bliver indtastet, så skal den sige godkendt, dog hvis andet end hairyharry bliver indtastet skal den sige forkert adgangskode
                if (adgangskodeInput.equals(adganskode)) {
                    System.out.println("Godkendt");

                    //Så bliver vi sendt over til en ny menu med Admin bruger funktioner
                    //ManuelBooking, SletningAfTider,Revisor
                    System.out.println("Tast 1 for Manuel Booking ");
                    System.out.println("Tast 2 for Sletning af tid ");
                    System.out.println("Tast 3 for Revisors Stikprøver ");
                    System.out.println("Tast 0 fir at afslutte");

                    //Vi skal kalde til vores ManuelBooking, SletningAfTider og Revisor klassser så alt kan køre på vores Main
                    int input = scanner.nextInt();

                    if (input==0){
                        System.out.println("Tak for i dag");
                        break;
                    }

                switch (input){
                    case 1:
                        RetTilBooket.BookEnTid(args);
                        break;
                    case 2:
                        SletningAfBooking.sletEnTid(args);
                        break;
                    case 3:
                        Revisor.revision(args);
                        break;

                        }*/
                 /*else if (input==1) {
                        RetTilBooket.BookEnTid(args);
                        break;

                    } else if (input==2) {
                        SletningAfBooking.sletEnTid(args);
                        break;

                    } else if (input==3) {
                        Revisor.revision(args);
                        break;
                    }*/
                }
            }



                //Derefter hvis der bliver tastet andre ting, skal vi sørger for at der ikke kan tastes andet end 1-3.


             /*else {
                System.out.println("Ugyldig valgmulighed, prøv igen");
                System.out.println();
            }*/
        }
    }