package dp;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {

        int W = 7; // total weight of sack
        int N = 4; // no. of items
        int[] val = {1, 4, 5, 7}; // items value
        int[] wt = {1, 3, 4, 5}; // items weight


        int [][] mat = new int[N+1][W+1];

        // Populate base cases
        for(int i =0; i< mat.length; i++){
            mat[i][0] = 0; // first column set to 0
        }

        // Populate base cases
        for(int i =0; i< mat[0].length; i++){
            mat[0][i] = 0; // first row set to 0
        }


        // i represent the given item wt (5, 4, 6, 3)
        // j represent the knapsack capacity from 0 to W.

        // this is bottom up approach of DP
        for(int i =1; i<= N; i++){
            for(int j =1; j<= W; j++){
                int maxValueWithoutCurItem = mat[i-1][j]; // This is guaranteed to exist

                int maxValWithCurrItem = 0; // We initialize this value to 0

                int weightOfCurrItem = wt[i - 1]; // We use i -1 to account for the extra row at the top

                if(j >= weightOfCurrItem) { // if the sack capacity is greater the current item wt, then with and
                    // without

                    int valueOfCurrentItem = val[i - 1]; // include the item and its value;

                    int remainingCapacityOfSack = j - weightOfCurrItem; // remaining sack capacity after including current ite,

                    maxValWithCurrItem = valueOfCurrentItem + mat[i-1][remainingCapacityOfSack]; // // Add the maximum value obtainable with the remaining capacity

                }

                mat[i][j] = Math.max(maxValWithCurrItem, maxValueWithoutCurItem); // Pick the larger of the two

            }
        }

        System.out.println(mat[N][W]); // Final answer
        System.out.println(Arrays.deepToString(mat)); // Visualization of the table
    }
}
