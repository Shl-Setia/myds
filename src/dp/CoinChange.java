package dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

        int T = 5;

        int[] coins = {1,2,3};

        int N = 3;

        int [][] mat = new int[N+1][T+1];

        // Populate base cases
        for(int i =0; i< mat.length; i++){
            mat[i][0] = 1; // first column set to 1
            // this represent no. of ways you can get total with given coin denomination
            // have 1 way to change 0 amount
        }

        // Populate base cases
        /*for(int i =0; i< mat[0].length; i++){
            mat[0][i] = 0; // first row set to 0
        }*/
        // ny default it is zero is no need to change

        for(int i =1; i<= coins.length; i++){
            for(int j=1; j<= T; j++){ // j represent the target value 1 to T.

               int noOfWaysToChangeTargetWithoutCurrentCoin = mat[i-1][j];

               int currentCoinValue = coins[i-1];

               if(j >= currentCoinValue ){

                   int noOfWaysToChangeTargetWithCurrentCoin = mat[i][j-currentCoinValue];
                   mat[i][j] = noOfWaysToChangeTargetWithCurrentCoin + noOfWaysToChangeTargetWithoutCurrentCoin;

               }else {
                   mat[i][j] = noOfWaysToChangeTargetWithoutCurrentCoin;
               }

            }
        }

        System.out.println(mat[N][T]); // Final answer
        System.out.println(Arrays.deepToString(mat)); // Visualization of the table




    }
}
