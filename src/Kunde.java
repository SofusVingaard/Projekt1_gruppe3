import java.util.ArrayList;
import java.util.Scanner;

public class Kunde {
    static String name;
    static int id;
    int bruger;
    static int numberOfId;
    static ArrayList<Kunde> nyKunde= new ArrayList<Kunde>();
    static Scanner keyboard= new Scanner(System.in);



    Kunde (String name){
        this.name=name;
        numberOfId++;
        id=numberOfId;

    }
    static void menu(){
        boolean keepGoing=true;
        while (keepGoing){
            System.out.println();
            System.out.println("Velkommen til Harry's Salon");
            System.out.println("pres 1 for at oprette dig som kunde og book en tid");
            System.out.println("pres 2 for at se dit navn og id: ");
            System.out.println("pres 3 for at booke en tid");

            int bruger=keyboard.nextInt();
            //Booking book = new Booking();

            switch (bruger) {
                case 1: {
                    Kunde a = lavBruger();
                    if (a != null) nyKunde.add(a); break;
                }
                case 2: {
                    System.out.println("dit navn er: "+name+" "+id); break;
                }
                case 3:{
                    //book.booking();
                    break;
                }

                case 0: keepGoing=false; break;
            }



        }
    }
    static Kunde lavBruger(){
        return new Kunde(name);

    }

    public String toString(){
        return name+"du har kunde id:"+id;
    }

    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        //Kunde a1= new Kunde("Gertrud");
        //Kunde a2= new Kunde("Charlie");
        Kunde.nyKunde.add( new Kunde("charlie"));
        Kunde.nyKunde.add(new Kunde("gertrud"));
        Kunde.menu();


    }

}