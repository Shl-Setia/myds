package stringManipulation.palindrome;

import java.util.HashMap;

//https://leetcode.com/problems/longest-palindromic-substring/solution/

// Expand around the center. There are 2n - 1 center for string to be palindrome
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String s = "babad";
        int start =0;
        int end = 0;

        for(int i =0 ; i < s.length(); i ++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.println(s.substring(start, end + 1));
            }
        }


    }

    private static int expandAroundCenter(String s, int left, int right){

        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        int len = right - left - 1; // 1 is subtracted to avoid index out of bound
        //System.out.println(s.substring(left+1, right)); // right is exclusive
        return len;
    }
}
