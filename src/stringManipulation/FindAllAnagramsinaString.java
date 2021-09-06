package stringManipulation;

import java.util.HashMap;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        String s = "cbaebabacb";
        String a = "abc";

        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(; left < s.length(); left++){
            if(a.contains(s.substring(left, left+1))){
                /*if(map.containsKey(s.charAt(left) - 'a')){
                    map.remove(s.charAt(left) - 'a');
                }*/
                map.put(s.charAt(left) - 'a', left);
            }else{
                if(!map.isEmpty()){
                    map.clear();
                }
            }

            if(map.size() == a.length()){
                System.out.println(left-(a.length()-1));
                map.remove(s.charAt(left-(a.length()-1)) - 'a');
            }

        }
    }
}
