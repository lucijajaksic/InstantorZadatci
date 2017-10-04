package hr.lucija.zadatak3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final int MIN_TESTS_COUNT = 1;
    public static final int MAX_TESTS_COUNT = 100;
    public static final int MIN_NUM_OF_COOKIES = 1;
    public static final int MAX_NUM_OF_COOKIES = 20;
    public static final int MIN_WEIGHT = 1;
    public static final int MAX_WEIGHT = 1000;



    public static void main(String[] args) {
        int testCasesNum = 0;
        int numberOfCookies=0, requestedWeight=0;
        int cookieSet[];

        List<int[]> tests = new ArrayList<>();


        Scanner in = new Scanner(System.in);

        if (in.hasNext()) {
            testCasesNum = in.nextInt();
        }
        while (testCasesNum < MIN_TESTS_COUNT || testCasesNum > MAX_TESTS_COUNT) {
            System.out.println("Broj testova mora biti u rasponu od 1 do 100 (uključivo). Upiši opet.");
            testCasesNum = in.nextInt();
        }
        int[] cookiesInTest = new int[testCasesNum];
        int[] weightOfTest = new int[testCasesNum];

        for (int j=0; j<testCasesNum; j++) {
            if (in.hasNext()) {
                numberOfCookies = in.nextInt();
            }
            while (numberOfCookies < MIN_NUM_OF_COOKIES || numberOfCookies > MAX_NUM_OF_COOKIES) {
                System.out.println("Broj keksa mora biti u rasponu od 1 do 20 (uključivo). Upiši opet.");
                numberOfCookies = in.nextInt();
            }
            cookiesInTest[j]=numberOfCookies;

            if (in.hasNext()) {
                requestedWeight = in.nextInt();
            }
            while (requestedWeight < MIN_WEIGHT || requestedWeight > MAX_WEIGHT) {
                System.out.println("Težina keksa mora biti u rasponu od 1 do 1000 (uključivo). Upiši opet.");
                requestedWeight = in.nextInt();
            }
            weightOfTest[j]=requestedWeight;

            cookieSet = new int[numberOfCookies];
            for (int i = 0; i < numberOfCookies; i++) {
                cookieSet[i] = in.nextInt();
            }
            tests.add(cookieSet);
        }


        for (int j=0; j<testCasesNum; j++) {
            numberOfCookies=cookiesInTest[j];
            requestedWeight=weightOfTest[j];
            cookieSet=tests.get(j);
            if (Recursion.areThereCookiesWeightedM(cookieSet, numberOfCookies, requestedWeight)){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }





        }
}


}
