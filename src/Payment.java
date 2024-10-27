import java.util.Scanner;

public class Payment {

    private static class PaymentTwo {
        private String customerId; //Så kan man holde styr mellem flere kunder
        private double amountPaid; //Hvor meget kunden betaler
        private double change; //tilbagebetalingen

        //Nu har jeg en payment klasse så det tid til en constructor

        public PaymentTwo(String customerId, double amountPaid) {
            this.customerId = customerId;
            this.amountPaid = amountPaid;
            this.change = 0.0; //0kr. er bare en default værdi

        }

        //jeg vil nu lave change med en if og else statement

        public void calculateChange(double serviceCost) {
            if (amountPaid >= serviceCost) { //hvis det kunden betaler er større eller lige med servicen
                //så skal change være amountPaid - serviceCost
                change = amountPaid - serviceCost;
            }
            else {
                change = 0.0; //Eller hvis det betalte ikke er nok skal den ikke beregne noget
                //så bliver harry bare sur.
            }
        }

        //getters skal kunne hente værdi
        public String getCustomerId(){
            return customerId;
        }

        public double getAmountPaid() {
            return amountPaid;
        }

        public double getChange() {
            return change;
        }

        @Override
        public String toString() {
            return "Customer ID: " + customerId + ", Amount Paid: " + amountPaid + ", Change: " + change;

        }
    }
    //Her vil man kunne vælge hvilke slags klip i forhold til m/u skæg, eller om det er dameklip m.m.
    public void startService() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommen til Harry's salon");
        System.out.println("Vælg en af de følgende");
        System.out.println("1. Herreklip (200 kr. ) ");
        System.out.println("2. Herreklip med skæg (250 kr.)");
        System.out.println("3. Dameklip (400 kr. )");
        System.out.println("4. Dameklip og hårvask (500 kr. )");
        System.out.println("5. Børneklip (100 kr. )");

        int choice = scanner.nextInt();
        double serviceCost = 0;


        switch (choice) {
            case 1:
                serviceCost = 200;
                break;
            case 2:
                serviceCost = 250;
                break;
            case 3:
                serviceCost = 400;
                break;
            case 4:
                serviceCost = 500;
                break;
            case 5:
                serviceCost = 100;
                break;
            default:
                System.out.println("Ugyldigt");
                return;
        }

        System.out.println("Indtast Navn: "); //Da det skal være bruge venligt vil deres id være navn
        // vi kan senere hen gøre det til en mail, tele, eller login process, men for nu er det navn
        String customerId = scanner.next();

        System.out.println("Indtast beløb betalt: "); // det vil være i kontant
        double amountPaid = scanner.nextDouble();

        //tid til et payment objekt
        PaymentTwo payment = new PaymentTwo(customerId, amountPaid);

        //beregn tilbage betalingen
        payment.calculateChange(serviceCost);

        System.out.println("Betaling gennemført: ");
        System.out.println(payment);

        if (payment.getChange() > 0) {
            System.out.println("Tak for betalingen! Tilbagebetaling: " + payment.getChange() + " kr.");
        }
        else {
            System.out.println("Beløbet er ikke tilstrækkeligt.");
        }

    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.startService(); //starter det koden op
    }
}






