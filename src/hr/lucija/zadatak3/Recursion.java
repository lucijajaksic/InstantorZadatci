package hr.lucija.zadatak3;

public class Recursion {
    static boolean areThereCookiesWeightedM(int set[],int n, int sum){
        if (sum==0){
            return true;
        }
        if (sum!=0 && n==0 ){
            return false;
        }
        if (set[n-1]>sum){
            return areThereCookiesWeightedM(set, (n-1), sum );
        }
        return (areThereCookiesWeightedM(set ,(n-1),sum) || areThereCookiesWeightedM(set, (n-1), sum-set[n-1]));

    }
}
