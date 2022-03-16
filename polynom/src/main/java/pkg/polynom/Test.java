package pkg.polynom;

public class Test {
    public static void main(String[] args) {
        int[] coefficient = new int[]{1, 2, 3};
        Polynom jedna = Polynom.getInstanceFromReverted(coefficient);

        System.out.println(jedna.getValue(2));
        System.out.println(jedna.toString());

    }
}
