package stringManipulation;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    // strs = ["eat","tea","tan","ate","nat","bat"]

    // option 1 : sort each string of array and use hashmap to store sortedString and input string.
    // complexity: N*KlogK. N is length of input array and K is length of each single string


    // option 2: used character count.
    //Two strings are anagrams if and only if their character counts (respective number of occurrences of each character) are the same.
    // For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total.
    // Complexity: NK.  N is length of input array and K is length of each single string
}
