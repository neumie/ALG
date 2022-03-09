package elearning;
import java.util.Scanner;

public class Elearning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int repeat = sc.nextInt();
        String input;
        sc.nextLine();
        for (int j = 0; j < repeat; j++) {
            input = "";
            while (!(input.contains("E"))) {
                input += sc.nextLine();
            }
            String horizontal = input.replaceAll("[^SJ]", "");
            String vertical = input.replaceAll("[^VZ]", "");
            int vert = 0; int hori = 0;
            int maxUp = 0; int maxDown = 0;
            int maxLeft = 0; int maxRight = 0;
            int answerHori; int answerVert;

            for (int i = 0; i < horizontal.length(); i++) {
                if (horizontal.charAt(i) == 'S') {
                    hori++;
                    if (maxUp < hori) maxUp = hori;
                    else if (maxDown > hori) maxDown = hori;
                } else if (horizontal.charAt(i) == 'J') {
                    hori--;
                    if (maxUp < hori) maxUp = hori;
                    else if (maxDown > hori) maxDown = hori;
                }
            }
            for (int i = 0; i < vertical.length(); i++) {
                if (vertical.charAt(i) == 'Z') {
                    vert++;
                    if (maxLeft < vert) maxLeft = vert;
                    else if (maxRight > vert) maxRight = vert;
                } else if (vertical.charAt(i) == 'V') {
                    vert--;
                    if (maxLeft < vert) maxLeft = vert;
                    else if (maxRight > vert) maxRight = vert;
                }
            }

            answerHori = Math.abs(maxUp) + Math.abs(maxDown) + 1;
            answerVert = Math.abs(maxLeft) + Math.abs(maxRight) + 1;
            System.out.println(answerVert + " " +answerHori);
        }
    }
    
}