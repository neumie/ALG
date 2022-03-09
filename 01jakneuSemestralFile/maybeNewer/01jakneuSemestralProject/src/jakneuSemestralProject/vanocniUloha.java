package jakneuSemestralProject;

import static jakneuSemestralProject.Main.sc;
import java.util.Random;
/**
 *
 * @author Jakub
 */
public class vanocniUloha {
    static void vanocniUloha(){
        String greenBold = "\033[32;1m";
        String brown = "\033[0;33m";
        System.out.println("Vyberte šířku: ");
        int width = sc.nextInt(); //20
        System.out.println("Vyberte výšku: ");
        int height = sc.nextInt(); //35
        boolean[][] tempSnowflake = new boolean[height][width];
        boolean[][] snowflake = generateSnowflake(height, width);
        while(true){
            for(int i = 0; i < snowflake.length; i++){ //copy snowflake to temp snowflake
                System.arraycopy(snowflake[i], 0, tempSnowflake[i], 0, snowflake[i].length);
            }
            for(int i = 0; i < snowflake.length; i++){ //Posun o 1 dolu
                if (i == 0) {
                    for (int a = 0; a < snowflake[0].length; a++) {
                        snowflake[i][a] = tempSnowflake[snowflake.length-1][a];
                    }
                }
                else {
                    for (int a = 0; a < snowflake[0].length; a++) {
                        snowflake[i][a] = tempSnowflake[i-1][a];
                    }
                }
            }
            //boolean[][] snowflake = generateSnowflake(height, width);
            int test = 0;
            for (int i = 1; i < height; i++) {
                if (i%(height/4) == 0) test += height/8;
                if (i > height / 1.1) { //kmen
                    for (int j = 0; j < width; j++) {
                        if (j > width / 1.2){
                            System.out.print(brown);
                            System.out.print("|");
                            System.out.print("|");
                        } else if ((snowflake[i][j])) {
                            System.out.print("\033[0m");
                            System.out.print("X");
                        } else System.out.print(" ");
                    }
                    for (int j = 0; j < width; j++) {
                        if (snowflake[i][j]){
                            System.out.print("\033[0m");
                            System.out.print("X");
                        } else System.out.print(" ");
                    }
                } else {
                    for (int j = 0; j < width; j++) { //jehličí
                        if (j > width-i+test) {
                            for (int k = 0; k < 2; k++) {
                                if (randomNumber(1, 10) > 8) {
                                    System.out.print(randomColor());
                                    System.out.print("O");
                                } else {
                                    System.out.print(greenBold);
                                    System.out.print("*");
                                }
                            }
                        } else if (snowflake[i][j]) {
                            System.out.print("\033[0m");
                            System.out.print("X");
                        } else System.out.print(" ");
                    }
                    for (int j = 0; j < width/2; j++) {
                        if (snowflake[i][j]) {
                            System.out.print("\033[0m");
                            System.out.print("X");
                        } else System.out.print(" ");
                    }
                }
                System.out.println("");
            }
            sleep(300);
            clearScreen();
            //end++;
            }
            }

    public static void main(String[] args) {
        vanocniUloha();
    }
    
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen(){
        for(int i = 0; i < 10; i++) System.out.print("\n");
    }
            
    public static int randomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }   

    public static String randomColor(){
        switch(randomNumber(1, 6)){
            case 1:
                return "\033[32;1m"; //green
            case 2:
                return "\u001B[34m"; //blue
            case 3:
                return "\u001B[31m"; //red
            case 4:
                return "\u001B[33m"; //yellow
            case 5:
                return "\u001B[35m"; //purle
            case 6:
                return "\u001B[36m"; //cyan
            default:
                return "\033[0m"; //reset
        }
    }
    
    public static boolean[][] generateSnowflake(int height, int width){
        Random random = new Random(); // vyska X sirka
        boolean[][] snowflake = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (randomNumber(1, 10) > 8) {
                snowflake[i][j] = true;
                } else snowflake[i][j] = false;
            }
        }
        return snowflake;
    }
    
}
