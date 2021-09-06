package arrays.twoDimensional;


//https://leetcode.com/problems/unique-paths/discuss/681019/Java-solution-with-comments

public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(uniquePath(7,3));
    }


    private static int uniquePath(int m, int n){
        if(m == 0 && n == 0){
            return 0;
        }

        if(m == 1 && n == 1){
            return 0;
        }

        int [][] dp = new int[m][n];


        //There is only one way to reach all elements of first row
        for(int i =1; i< n; i++){
            dp[0][i] = 1;
        }

        //There is only one way to reach all elements of first column
        for(int i =1; i< m; i++){
            dp[i][0] = 1;
        }

        //the different ways to reach a cell is the sum of ways to reach the cell the row above and the cell in the previous column ( As you can only move down or right)

        for(int i=1; i< m ; i++){
            for(int j=1; j< n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }


        return dp[m-1][n-1];
    }
}
