package stringManipulation;

import java.util.Arrays;


//https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
public class KMPPatternSearching {
    public static void main(String[] args) {

        //String pat = "abadabad";
        //String pat = "aabaabaaa";
        String pat = "abcdabcdabcd";
        Integer [] lps = new Integer[pat.length()];
        computeLPS(pat, pat.length(), lps);
        System.out.println(Arrays.deepToString(lps));
    }

    // Compute temporary array to maintain size of suffix which is same as prefix
    public static void computeLPS(String pat, int m, Integer [] lps){

        lps[0] = 0; // lps[0] is always 0

        int i = 1;
        int j = 0;

        while(i < m){
            if(pat.charAt(i) == pat.charAt(j)){
                lps[i] = j + 1;
                j++;
                i++;
            }else { // no match

                if (j != 0) {
                    j = lps[j - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }

    }
}
