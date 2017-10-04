package hr.lucija.zadatak2;

public class Sequences {

    /*
    Zadatak je inicijalno riješen tražeći najdulju sekvencu te provjeravanjem da li je ta sekvenca veća od nule.
    No, budući da je i jedno slovo sekvenca riječi, jednostavnije rješenje jest pronalaženje slova koje se pojavljuje
    dva puta te predstavlja najkraću sekvencu.
     */

   public static boolean isThereLongestSequence(String str){
        int n = str.length();
        char[] tmp = str.toCharArray();
        int[][] table = new int[n][n];

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++){
                table[i][j]=0;
            }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if (tmp[i] == tmp[j] && i != j) {
                    if (i==0 || j==0) {
                        table[i][j]=1;
                    }
                    else {
                        table[i][j] = 1 + table[i - 1][j - 1];
                    }
                } else {
                    if (i == 0 || j == 0) {
                        continue;
                    }
                    if (table[i][j - 1] > table[i - 1][j]) {
                        table[i][j] = table[i][j - 1];
                    }
                    else {
                        table[i][j] = table[i - 1][j];
                    }
                }
            }
        }

        if (table[n-1][n-1]>0)
            return true;
        return false;

    }

    public static boolean isThereSequence(String str){

        char[] charArray = str.toCharArray();
        boolean hasSequence = false;

        for (int i = 0; i < charArray.length; i++){
            char letter = charArray[i];
            hasSequence = str.indexOf(letter, i + 1) > -1 ;
            if (hasSequence){
                break;
            }
        }

        return hasSequence;
    }

}
