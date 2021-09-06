package stringManipulation;

// tag : sliding window, string

// https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
// Approach 3: Sliding Window Optimized
// When we find the duplicate, we skip the first duplicate char and all the chars before duplicate.

//Think of belwo inputs.
/* abcdefa
   abcdefb
   abcdefc
   abcdefd
   abcdefe
   abcdeff    */


import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdefgd"));
    }

    static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1); // this is to find ans
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }
}
