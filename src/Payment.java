import java.util.Scanner; //Bruger scannner til at læse brugens input

public class Payment { // definerer en public (offentlig) klasse som kaldes Payment

    private static class PaymentTwo { // Det bedst den er privat så den ikke kan tilgås af andre, som ikke skal kunne have adgang
        // Instansvariabler (felter) til at gemme information om betalingen
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
        // den skal kunne regne ud hvis en kunden betaler med en 500 så skal det tilbagebetales
        // og hvis den betaler for lidt så skal den skrive det sig ugyldig.
        //hvis jeg kan så skal den kunne gemme at denne person skylder som en form af kredit

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
        //henter kundens id
        public String getCustomerId(){
            return customerId;
        }
        //Hente det betalte beløb
        public double getAmountPaid() {
            return amountPaid;
        }
        //Hente tilbagebetaling hvis der er
        public double getChange() {
            return change;
        }

        @Override
        public String toString() { // dette er bare en præsentation af vores objekt som er PaymentTwo. Vi kombinere instansvariablerne i en String.
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

        System.out.println("Indtast beløb: "); // det vil være i kontant
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
        payment.startService(); //starter koden op
    }
}






