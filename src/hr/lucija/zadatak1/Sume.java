package hr.lucija.zadatak1;

public class Sume {

    public static int prefiksSuma(int i, int[] niz){
        int suma=0;
        for (int j=0; j<i; j++){
            suma+=niz[j];
        }
        return suma;
    }
    public static int sufiksSuma(int i, int[] niz){
        int suma=0;
        for (int j=i-1; j<niz.length; j++){
            suma+=niz[j];
        }
        return suma;
    }
}
