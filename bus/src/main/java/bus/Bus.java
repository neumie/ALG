package bus;

public class Bus
{
    private String company;
    private final int seats;
    private int passengers;
    private int link;

    public Bus(){
        this.seats = 40;
        this.company = "";
        this.link = 0;
        this.passengers = 0;
    }

    public Bus(String company, int seats, int link){
        this.company = company;
        this.seats = seats;
        this.link = link;
        this.passengers = 0;
    }

    public String getCompany(){
        return this.company;
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

    public void setCompanyLink(int link, String company){
        this.link = link;
        this.company = company;
    }

    @Override
    public String toString(){
        return String.format("Autobus číslo %d společnosti %s s počtem sedadel %d veze %d cestujících", this.link, this.company, this.seats, this.passengers);
    }

    public void leave(int passengers){
        if (passengers > this.passengers){
            this.passengers = 0;
        } else this.passengers -= passengers;
    }

    public void enter(int passengers){
        if (passengers + this.passengers > this.seats){
            this.passengers = this.seats;
        } else this.passengers += passengers;
    }

    public void exit(){
        this.passengers = 0;
    }
}
