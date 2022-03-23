package pkg.polynom;

public class PolynomPlus{
    public static void main(String[] args) {
        Polynom p1 = new Polynom(1, 2, 3, 4, 5, 6);
        Polynom p2 = new Polynom(1, 2, 3);

        int[] sum = sum(p1, p2);
    }

    public static Polynom sum(Polynom... p){
        Polynom sum = p[0];
        for (int i = 1; i < p.length; i++){
            sum = sum(sum, p[i]);
        }
        return sum;
    }


}