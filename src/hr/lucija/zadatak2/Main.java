package hr.lucija.zadatak2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int testCasesNum = 0;
        ArrayList<String> listOfWords = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            testCasesNum = in.nextInt();
        }
        //jer inače čita liniju pored integera
        in.nextLine();

        for (int i = 0; i < testCasesNum; i++) {
            if (in.hasNextLine())
                listOfWords.add(in.nextLine().trim());
        }
        System.out.println("Izlaz: ");
        for (String word: listOfWords) {
            if (Sequences.isThereSequence(word)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }


}
