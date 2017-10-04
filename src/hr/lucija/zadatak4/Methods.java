package hr.lucija.zadatak4;

import java.util.ArrayList;

public class Methods {
    public static int isItPossible (ArrayList<Integer> lengthsOfCats, int numberOfCats, int longAtLeast){
        int i=numberOfCats-1;
        int difference;
        int catsCount=0;
        int indexOfUsedCat=0;

        while(i>=indexOfUsedCat){
            if (lengthsOfCats.get(i)>=longAtLeast){
                i--;
                catsCount++;
            }
            else if (lengthsOfCats.get(i)<longAtLeast){
                difference=longAtLeast-lengthsOfCats.get(i);
                if (difference<=(i-indexOfUsedCat)){
                    indexOfUsedCat+=difference;
                    catsCount++;
                    i--;
                }
                else {
                    break;
                }

            }

        }
        return catsCount;
    }
}
