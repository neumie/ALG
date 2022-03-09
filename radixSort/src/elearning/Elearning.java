package elearning;

public class Elearning {

    public static void main(String[] args) {
        int[] data = new int[]{326, 421, 643, 128, 979, 482, 274, 640, 645, 357, 231, 123, 543, 123, 123, 653, 543, 657, 345, 235, 987};
        int[] counter = new int[10];
        int[] newData = new int[data.length];
        int lastK = 1;
        int k = 10;
        
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < data.length; i++) {
                counter[(data[i] % k) / lastK]++; //inkrementace counteru
            }
            for (int i = 0; i < counter.length-1; i++) { //prefix sum
                counter[i+1] = counter[i] + counter[i+1];
            }
            for (int i = data.length-1; i >= 0; i--) {
                newData[counter[(data[i] % k) / lastK] - 1] = data[i];
                counter[(data[i] % k) / lastK]--;
            }
            System.arraycopy(newData, 0, data, 0, data.length);
            counter = new int[10];
            lastK = k;
            k *= 10;
        }       
    }
    
}