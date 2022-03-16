package pkg.polynom;

public class PolynomPlus{
    public static void main(String[] args) {
        int[] p1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] p2 = new int[]{1, 2, 3};

        int[] sum = sum(p1, p2);
    }

    public static Polynom sum(Polynom p1pol, Polynom p2pol){
        int[] p1 = p1pol.getPolynom();
        int[] p2 = p2pol.getPolynom();
        int[] sum = new int[Math.max(p1.length, p2.length)];
        for(int i = 0; i < p1.length; i++){
            if (p1.length > i && p2.length > i){
                sum[i] = p1[i] + p2[i];
            } else if (p1.length >= i){
                sum[i] = p1[i];
            } else if (p2.length >= i){
                sum[i] = p2[i];
            } else sum[i] = 0;
        }
        return ;
    }


}