package hr.lucija.zadatak4;

import java.util.ArrayList;

public class Test {
    private int numberOfCats;
    private int numberOfRequests;
    ArrayList<Integer> lengthsOfCats = new ArrayList<>();
    ArrayList<Integer> listOfRequests = new ArrayList<>();

    public Test(int numberOfCats, int numberOfRequests, ArrayList<Integer> lengthsOfCats, ArrayList<Integer> listOfRequets) {
        this.numberOfCats = numberOfCats;
        this.numberOfRequests = numberOfRequests;
        this.lengthsOfCats = lengthsOfCats;
        this.listOfRequests = listOfRequets;
    }

    public int getNumberOfCats() {
        return numberOfCats;
    }

    public void setNumberOfCats(int numberOfCats) {
        this.numberOfCats = numberOfCats;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setNumberOfRequests(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public ArrayList<Integer> getLengthsOfCats() {
        return lengthsOfCats;
    }

    public void setLengthsOfCats(ArrayList<Integer> lengthsOfCats) {
        this.lengthsOfCats = lengthsOfCats;
    }

    public ArrayList<Integer> getListOfRequests() {
        return listOfRequests;
    }

    public void setListOfRequests(ArrayList<Integer> listOfRequests) {
        this.listOfRequests = listOfRequests;
    }
}
