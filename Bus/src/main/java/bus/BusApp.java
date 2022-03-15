package bus;

import java.util.Scanner;

public class BusApp

{
    public static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {

        Bus university = new Bus("DPMLJ", 41, 15);
        int pocet_zastavek = 5;

        for (int zastavka = 1; zastavka <= pocet_zastavek; zastavka++){
            sendInfo(university);
            ask(university);
        }
        university.exit();

    }

    private static void sendInfo(Bus autobus){
        System.out.println("Zastávka " +autobus.getStop());
        System.out.println(autobus.toString());
    }

    private static void ask(Bus autobus){
        System.out.println("Kolik cestujících chce vystoupit a nastoupit?");
        int vyst = sc.nextInt();
        int nast = sc.nextInt();

        if (vyst > autobus.getPassengers() && vyst != 0){
            System.out.format("Vystoupilo %d pasažerů\n", autobus.getPassengers());
            autobus.exit();
        } else {
            autobus.leave(vyst);
        }

        if (nast > autobus.getFreeSeats()){
            System.out.format("Nastoupilo %d pasažerů\n", autobus.getFreeSeats());
            autobus.enter(autobus.getFreeSeats());
        } else {
            autobus.enter(nast);
        }
    }
}
