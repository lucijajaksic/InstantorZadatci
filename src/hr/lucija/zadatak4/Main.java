package hr.lucija.zadatak4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Test> tests = new ArrayList<>();

        int numberOfTests = in.nextInt();
        for (int i = 0; i < numberOfTests; i++){
            int numberOfCats = in.nextInt();
            int numberOfRequests = in.nextInt();

            ArrayList<Integer> lengthsOfCats = new ArrayList<>();
            for (int j = 0; j < numberOfCats; j++){
                lengthsOfCats.add(in.nextInt());
            }

            ArrayList<Integer> listOfRequests = new ArrayList<>();
            for (int j = 0; j < numberOfRequests; j++){
                listOfRequests.add(in.nextInt());
            }

            Test test = new Test(numberOfCats, numberOfRequests, lengthsOfCats, listOfRequests);
            tests.add(test);
        }

        for (Test test : tests){
            Collections.sort(test.getLengthsOfCats());
            for (int request : test.getListOfRequests()){
                int result = Methods.isItPossible(test.getLengthsOfCats(), test.getNumberOfCats(), request);
                System.out.println(result);
            }
        }



    }


}

