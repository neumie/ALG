package pkg.polynom;

public class Polynom 
{
    private int[] coefficient;

    public Polynom(int coefficient){
        this.coefficient = new int[1];
        this.coefficient[0] = coefficient;
    }

    public Polynom(int coefficientOne, int coefficientTwo){
        this.coefficient = new int[2];
        this.coefficient[0] = coefficientOne;
        this.coefficient[1] = coefficientTwo;
    }

    //Správně otočený array z pole
    public Polynom(int[] coefficient){
        this.coefficient = new int[coefficient.length];
        System.arraycopy(coefficient, 0, this.coefficient, 0, coefficient.length);
    }

    //Správně otočený array z více intů
    public static Polynom getInstanceFrom(int... a){
        return new Polynom(a);
    }

    //Špatně otočený array z pole
    public static Polynom getInstanceFromRevertedArray(int[] a){
        return getInstanceFromReverted(a);
    }

    //Špatně otočený array z více intů
    public static Polynom getInstanceFromReverted(int... a){
        int[] reversed = new int[a.length];
        for(int i = a.length-1; i >= 0; i--){
            reversed[i] = a[a.length-1-i];
        }
        return new Polynom(reversed);
    }

    public int getExponent(){
        return this.coefficient.length;
    }

    public int getCoefficient(int Exponent){
        return this.coefficient[Exponent];
    }

    public int getValue(int x){
        int value = 0;
        for(int i = 0; i < this.coefficient.length; i++){
            value += this.coefficient[i] * Math.pow(x, i);
        }
        return value;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(int i = this.coefficient.length-1; i >= 0; i--){
            if(this.coefficient[i] != 0){
                sb.append(Integer.toString(this.coefficient[i])).append("x^").append(i).append(" + ");
            }
        }
        return sb.deleteCharAt(sb.length()-2).toString();
    }
}