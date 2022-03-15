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
            System.out.println("Zastávka " +zastavka);
            System.out.println(university.toString());
            ask(university);
            System.out.println(university.toString() +"\n");
        }
        university.exit();
        System.out.println(university.toString());

    }

    private static void ask(Bus autobus){
        System.out.println("Kolik cestujících chce vystoupit a nastoupit?");
        int vyst = sc.nextInt();
        int nast = sc.nextInt();

        leave(autobus, vyst);
        enter(autobus, nast);
    }

    private static void leave(Bus autobus, int leavingPassengers){
        if (leavingPassengers > autobus.getPassengers() && leavingPassengers != 0){
            System.out.format("Vystoupilo %d pasažerů\n", autobus.getPassengers());
            autobus.exit();
        } else {
            autobus.leave(leavingPassengers);
        }
    }

    private static void enter(Bus autobus, int enteringPassengers){
        if (enteringPassengers > autobus.getFreeSeats()){
            System.out.format("Nastoupilo %d pasažerů\n", autobus.getFreeSeats());
            autobus.enter(autobus.getFreeSeats());
        } else {
            autobus.enter(enteringPassengers);
        }
    }
}
