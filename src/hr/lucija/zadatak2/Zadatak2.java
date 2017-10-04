package hr.lucija.zadatak2;

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak2 {

    public static void main(String[] args) {
        int brojTestnihSlucajeva = 0;
        ArrayList<String> listaRijeci = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            brojTestnihSlucajeva = in.nextInt();
        }
        //jer inače čita liniju pored integera
        in.nextLine();

        for (int i = 0; i < brojTestnihSlucajeva; i++) {
            if (in.hasNextLine())
                listaRijeci.add(in.nextLine().trim());
        }
        for (String rijec: listaRijeci) {
            System.out.println("Rijec: " + rijec);
            if (postojiLiSekvenca(rijec)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

    static boolean postojiLiSekvenca(String str){
        int n=str.length();
        char[] pom=str.toCharArray();
        int[][] tablica = new int[n][n];

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++){
                tablica[i][j]=0;
            }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if (pom[i] == pom[j] && i != j) {
                    if (i==0 || j==0) {
                        tablica[i][j]=1;
                    }
                    else {
                        tablica[i][j] = 1 + tablica[i - 1][j - 1];
                    }
                } else {
                    if (i == 0 || j == 0) {
                        continue;
                    }
                    if (tablica[i][j - 1] > tablica[i - 1][j]) {
                        tablica[i][j] = tablica[i][j - 1];
                    }
                    else {
                        tablica[i][j] = tablica[i - 1][j];
                    }
                }
            }
        }

        if (tablica[n-1][n-1]>0)
            return true;
        return false;

    }
}
