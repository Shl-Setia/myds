package arrays.slidingWindow;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Given a string, find the length of the longest substring without repeating characters.

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        // pwwkew
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int ans =0;

        for(; right< s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                int existingElementIndex = map.get(s.charAt(right));
                left = existingElementIndex + 1;

            }
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);

    }
}
