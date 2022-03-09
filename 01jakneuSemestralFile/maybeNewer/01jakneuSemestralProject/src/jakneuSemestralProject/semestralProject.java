package jakneuSemestralProject;

/**
 * 1. Program searches for the longest subSequence in a given sequence.
 * @author jakneu
 * @version 1 13/12/21
 */
public class semestralProject {
    
    /**
     * Semestrální projekt
     */
    static void semestralProject(){
        boolean end = false;
        do {
            System.out.print("Zadejte délku posloupnosti: ");
            int[] posloupnost = new int[Main.sc.nextInt()]; //Načtení délky posloupnosti
            if (posloupnost.length < 1) end = true; //nahradil bych breakem, ale nemáme ho používat.
            Main.sc.nextLine();
            System.out.print("Zadejte hodnoty posloupnosti: ");
            for (int i = 0; i <= posloupnost.length-1; i++) posloupnost[i] = Main.sc.nextInt(); //Načtení hodnot do pole

            int[] biggest = findSubSequence(posloupnost); //vyhledání nejdelší subPosloupnosti

            if (biggest[0] == -1) { //Kontrola jestli byla nalezena alespoň jedna subPosloupnost
                System.out.println("Posloupnost nemá žádnou uspořádanou část.");
            } else {
                System.out.format("Začátek %d. prvek\n", biggest[0]+1);
                System.out.format("Nejdelší setříděná část délky %d\n", biggest[1]);
            }
        } while (!end);
    }
    
    /**
     * Find the biggest subSequence in input sequence and returns its starting index and number of values
     * @param posloupnost sequence that you want to process
     * @return returns biggest subSequence of input sequence (index of the beginning of subSequence and number of values in subSequence 
     */
    static int[] findSubSequence(int[] posloupnost){
        int index = -1; //index -1 znamená hledání nové subPosloupnosti
        int pocetPrvku = 0;
        int[] biggest = new int[]{0, 0}; //první hodnota = index, druhá hodnota = počet prvků
        
        for (int i = 0; i < posloupnost.length-1; i++) {
            if (posloupnost[i] < posloupnost[i+1] && index == -1) { //začátek nové subPosloupnosti
                index = i;
                pocetPrvku = 2;
            } else if (posloupnost[i] < posloupnost[i+1]) {
                pocetPrvku++;
            } else { //konec subPosloupnosti
                if(biggest[1] < pocetPrvku){ //Kontrola jestli byla subPosloupnost největší ze všech
                    biggest[0] = index;
                    biggest[1] = pocetPrvku;
                }
                index = -1; //hledá se nová subPosloupnost
            }
        }
        if (biggest[1] < pocetPrvku){ //Kontrola jestli nebyla poslední subPosloupnost největší ze všech
            biggest[0] = index;
            biggest[1] = pocetPrvku;
        }
        return biggest;
    }
    
}
