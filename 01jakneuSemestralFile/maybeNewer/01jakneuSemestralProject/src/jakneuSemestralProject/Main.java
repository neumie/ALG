package jakneuSemestralProject;

import java.util.Scanner;

public class Main {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean end = false;
        
        do {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice){
                case 1: semestralProject.semestralProject(); break;
                case 2: vanocniUloha.vanocniUloha(); break;
                case 0: end = true; break;
                default: System.out.println("Neplatná volba");
            }
        } while (!end);
    }
    
    /**
     * Displays menu
     */
    private static void displayMenu(){
        System.out.println("\nZvolte program který chcete spustit");
        System.out.println("(1) Semestrální Projekt\n"
                          +"(2) Vánoční úloha\n"
                          +"(0) Konec");
    }
}
