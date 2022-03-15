package bus;

public class Bus
{
    private String name;
    private int seats;
    private int passengers;
    private int link;

    public Bus(){
        this.seats = 40;
    }

    public Bus(String name, int seats, int link){
        this.name = name;
        this.seats = seats;
        this.link = link;
    }

    public String GetName(){
        return this.name;
    }

    public int getSeats(){
        return this.seats;
    }

    public int getLink(){
        return this.link;
    }

    public int getPassengers(){
        return this.passengers;
    }

    public int getFreeSeats(){
        return this.seats - this.passengers;
    }

    public void change(int link, String name){
        this.link = link;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Autobus číslo %d společnosti %s s počtem sedadel %d veze %d cestujících", this.link, this.name, this.seats, this.passengers);
    }

    public void leave(int passengers){
        this.passengers -= passengers;
    }

    public void enter(int passengers){
        this.passengers += passengers;
    }

    public void exit(){
        this.passengers = 0;
    }
}
