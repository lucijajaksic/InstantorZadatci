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
    public static final int MAX_ARRAY_VALUE = 100000;
    public static final int MIN_TESTS_COUNT = 1;
    public static final int MAX_TESTS_COUNT = 10;
    public static final int MIN_ARRAY_SIZE = 1;

    public static void main(String[] args) {
        List<int[]> tests = new ArrayList<>();
        int numOfTests, arraySize, arrayValue;
        Scanner in = new Scanner(System.in);

        try {
            numOfTests = in.nextInt();
            while (numOfTests < MIN_TESTS_COUNT || numOfTests > MAX_TESTS_COUNT) {
                System.out.println("Broj testova mora biti u rasponu od 1 do 10 (uključivo). Upiši opet.");
                numOfTests = in.nextInt();
            }


            //Array jer znamo fiksnu duljinu -> brže, ne dodajemo i ne mičemo elemente u nizu pa nema potrebe za ArrayList
            for (int i = 0; i < numOfTests; i++) {
                arraySize = in.nextInt();
                while (arraySize < MIN_ARRAY_SIZE) {
                    System.out.println("Broj cijelih brojeva u nizu mora biti veći od 1. Upiši opet.");
                    arraySize = in.nextInt();
                }
                int[] test = new int[arraySize];
                for (int j = 0; j < arraySize; j++) {
                    arrayValue = in.nextInt();
                    while (arrayValue > MAX_ARRAY_VALUE || arrayValue < 0) {
                        System.out.println("Član niza treba biti pozitivan cijeli broj manji od 10^5!");
                        arrayValue = in.nextInt();
                    }
                    test[j] = arrayValue;
                }

                tests.add(test);

            }
        }catch (InputMismatchException e){
            System.err.println("Pogrešan unos.");
        } finally {
            in.close();
        }


        for(int[] test : tests) {
            int helpSum;
            int minSum;
            int minIndex = 1;
            minSum = Sums.prefixSum(minIndex, test) + Sums.sufixSum(minIndex, test);

            for (int i = minIndex + 1; i <= test.length; i++) {
                helpSum = Sums.prefixSum(i, test) + Sums.sufixSum(i, test);
                if (helpSum < minSum) {
                    minSum = helpSum;
                    minIndex = i;
                }
            }
            System.out.println("Izlaz:");
            System.out.println(minIndex);

        }
    }




}
