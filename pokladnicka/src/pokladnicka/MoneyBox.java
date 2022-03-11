package pokladnicka;

/**
 *
 * @author 4Jaku
 */
public class MoneyBox {
    private String name;
    private int jedna;
    private int dva;
    
    public MoneyBox(String name){
        this.name = name;
        this.jedna = 0;
        this.dva = 0;
    }
    
    public MoneyBox(String name, int jedna, int dva){
        this.name = name;
        this.jedna = jedna;
        this.dva = dva;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void empty(){
        this.jedna = 0;
        this.dva = 0;
    }
    
    public int getOnes(){
        return this.jedna;
    }
    
    public int getTwos(){
        return this.dva;
    }
    
    public int getSum(){
        return this.jedna + (this.dva*2);
    }
    
    public void addOne(){
        this.jedna++;
    }
    
    public void addOne(int number){
        this.jedna += number;
    }
    
    public void addTwo(){
        this.dva++;
    }
    
    public void addTwo(int number){
        this.dva += number;
    }
    
    public void add(int one, int two){
        this.addOne(one);
        this.addTwo(two);
    }
    
    public boolean canAfford(int price){
        return this.getSum() > price;
    }
    
    public String hasMore(MoneyBox... box){
        int max = 0;
        String jmeno = "";
        for(MoneyBox asd : box){
            if(asd.getSum() > max){
                max = asd.getSum();
                jmeno = asd.getName();
            }
        }
        return String.format("Kasička se jménem %s má nejvíc korun", jmeno);
    }
    
    public void convertAll(MoneyBox target){
        target.addOne(this.getOnes());
        target.addTwo(this.getTwos());
        this.empty();
    }
    
    @Override
    public String toString(){
        return String.format("%s má v pokladničce %dKč - %dx1Kč, %dx2Kč.", this.name, this.getSum(), this.jedna, this.dva);
    }
}
