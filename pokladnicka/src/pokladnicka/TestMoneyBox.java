package pokladnicka;

/**
 *
 * @author 4Jaku
 */
public class TestMoneyBox {
        
    public static void main(String[] args) {
        
        MoneyBox first = new MoneyBox("Alice", 5, 6);
        MoneyBox second = new MoneyBox("Bob");
        
        second.addOne(2);
        second.addTwo(3);
        second.add(5, 10);
        System.out.println(first.getSum() +" " +second.getSum());
        System.out.println(first.toString() +"\n" +second.toString());
        System.out.println(first.getName() +" " +first.canAfford(39));
        System.out.println(second.getName() +" " +second.canAfford(39));
        System.out.println(first.hasMore(first, second));
        second.convertAll(first);
        System.out.println(first.toString() +"\n" +second.toString());
    }
}
