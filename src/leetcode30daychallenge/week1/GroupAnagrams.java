package leetcode30daychallenge.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams2(strs);
    }


    static public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }


    // Instead of sorting, we can also build the key string in this way

    static public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];

            for (char c : s.toCharArray()) ca[c - 'a']++;

            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
