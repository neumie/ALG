
package pkg011.fraction;

/**
 *
 * @author Jakub Neumann
 */
public class TestFraction {
    
    public static void main(String[] args) {
        Fraction first = new Fraction(32, 4);
        Fraction second = new Fraction("10 8");
        
        System.out.println(first.getCitatel() +"/" + first.getJmenovatel());
        System.out.println(second.getCitatel() +"/" + second.getJmenovatel());
        System.out.println(first.toDouble());
        System.out.println(first.toString());
        System.out.println(second.toString());
    }
    
}