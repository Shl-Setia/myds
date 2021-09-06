package dp;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        String w1 = "abcdef";
        String w2 = "azced";

        int mat[][] = new int[w2.length()+1][w1.length()+1];

        // base cases
        // w1 = "abcdef" and  w2 = empty
        // mat value represent no. of operations required to convert w1[i] to w2[1]
        for(int i=0; i<=w1.length(); i++){
            mat[0][i] = i;
        }

        // w1 = empty, w2 = "azced"
        // mat value represent no. of operations required to convert w1[1] to w2[i]
        for(int i=0; i<=w2.length(); i++){
            mat[i][0] = i;
        }

        System.out.println(Arrays.deepToString(mat));


        // i rows, j columns
        for(int i=1; i<=w2.length(); i++){ // represent w2
            for(int j=1; j<=w1.length(); j++){// represent w1

                int noOfOpsRequiredWithoutCurrent = mat[i-1][j-1]; // this must exist,

                if(w2.charAt(i-1) == w1.charAt(j-1)){
                    // if words are same, we dont need to change anything.
                    // so the no. of operation will be same without including current chars i.e. i-1 and j-1
                    mat[i][j] = noOfOpsRequiredWithoutCurrent;
                }else{
                    int minNoOfOpsRequiredWithCurrent = Math.min(mat[i-1][j], mat[i][j-1]);
                    mat[i][j] = Math.min(minNoOfOpsRequiredWithCurrent ,noOfOpsRequiredWithoutCurrent) + 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(mat));
    }
}
