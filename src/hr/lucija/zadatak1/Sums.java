package hr.lucija.zadatak1;

public class Sums {

    public static int prefixSum(int i, int[] array){
        int sum=0;
        for (int j=0; j<i; j++){
            sum+=array[j];
        }
        return sum;
    }
    public static int sufixSum(int i, int[] array){
        int sun=0;
        for (int j=i-1; j<array.length; j++){
            sun+=array[j];
        }
        return sun;
    }
}
