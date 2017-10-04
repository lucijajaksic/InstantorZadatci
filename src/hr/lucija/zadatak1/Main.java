package hr.lucija.zadatak1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



/* Zadatak je rješen koristeći metode za računanje suma kako je to prikazano u primjeru zadatka. Takoder, zadatak se može rješiti
   i na način da se pronađe najmanji član u nizu i ispiše njegov indeks. Naime, uvijek će se sumirati svi članovi niza
   (konstantna suma) + i-ti član koji je zajednički prefiksu i sufiksu. Ako je taj član minimalan, suma će biti minimalna.
 */

public class Main {
    public static final int MAX_VRIJEDNOST_CLANA_NIZA  = 100000;
    public static final int MIN_BROJ_TESTOVA  = 1;
    public static final int MAX_BROJ_TESTOVA  = 10;
    public static final int MIN_BROJ_CIJELIH_BROJEVA_U_NIZU  = 1;

    public static void main(String[] args) {
        List<int[]> testovi = new ArrayList<>();
        int brojTestova, brojClanovaUNizu, clanNiza;
        Scanner in = new Scanner(System.in);

        try {
            brojTestova = in.nextInt();
            while (brojTestova < MIN_BROJ_TESTOVA || brojTestova > MAX_BROJ_TESTOVA) {
                System.out.println("Broj testova mora biti u rasponu od 1 do 10 (uključivo). Upiši opet.");
                brojTestova = in.nextInt();
            }


            //Array jer znamo fiksnu duljinu -> brže, ne dodajemo i ne mičemo elemente u nizu pa nema potrebe za ArrayList
            for (int i = 0; i < brojTestova; i++) {
                brojClanovaUNizu = in.nextInt();
                while (brojClanovaUNizu < MIN_BROJ_CIJELIH_BROJEVA_U_NIZU) {
                    System.out.println("Broj cijelih brojeva u nizu mora biti veći od 1. Upiši opet.");
                    brojClanovaUNizu = in.nextInt();
                }
                int[] test = new int[brojClanovaUNizu];
                for (int j = 0; j < brojClanovaUNizu; j++) {
                    clanNiza = in.nextInt();
                    while (clanNiza > MAX_VRIJEDNOST_CLANA_NIZA || clanNiza < 0) {
                        System.out.println("Član niza treba biti pozitivan cijeli broj manji od 10^5!");
                        clanNiza = in.nextInt();
                    }
                    test[j] = clanNiza;
                }

                testovi.add(test);

            }
        }catch (InputMismatchException e){
            System.err.println("Pogrešan unos.");
        } finally {
            in.close();
        }


        for(int[] test : testovi) {
            int pomocnaSuma;
            int minimalnaSuma;
            int minimalniIndeks = 1;
            minimalnaSuma = Sume.prefiksSuma(minimalniIndeks, test) + Sume.sufiksSuma(minimalniIndeks, test);

            for (int i = minimalniIndeks + 1; i <= test.length; i++) {
                pomocnaSuma = Sume.prefiksSuma(i, test) + Sume.sufiksSuma(i, test);
                if (pomocnaSuma < minimalnaSuma) {
                    minimalnaSuma = pomocnaSuma;
                    minimalniIndeks = i;
                }
            }
            System.out.println("Izlaz:");
            System.out.println(minimalniIndeks);

        }
    }




}
