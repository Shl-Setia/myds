package recursion.backtracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

public class LetterCombinationsPhoneNumber {

    public static void main(String[] digits) {

        List<String> list = letterCombinations("234");
        System.out.println(list);

    }


    public static List<String> letterCombinations1(String digits){


        return null;
    }

    public static List<String> letterCombinations(String digits) {

        Map<Character, List<Character>> keypad = new HashMap<>();
        keypad.put('2', Collections.unmodifiableList(Arrays.asList('a', 'b', 'c')));
        keypad.put('3', Collections.unmodifiableList(Arrays.asList('d', 'e', 'f')));
        keypad.put('4', Collections.unmodifiableList(Arrays.asList('g', 'h', 'i')));
        keypad.put('5', Collections.unmodifiableList(Arrays.asList('j', 'k', 'l')));
        keypad.put('6', Collections.unmodifiableList(Arrays.asList('m', 'n', 'o')));
        keypad.put('7', Collections.unmodifiableList(Arrays.asList('p', 'q', 'r', 's')));
        keypad.put('8', Collections.unmodifiableList(Arrays.asList('t', 'u', 'v')));
        keypad.put('9', Collections.unmodifiableList(Arrays.asList('w', 'x', 'y', 'z')));


        List<String> list = new ArrayList<>();

        if(digits.isEmpty()){
            return list;
        }

        if(digits.length() ==1){

            return keypad.get(digits.charAt(0)).stream().map(String::valueOf).collect(Collectors.toList());
        }

        if(digits.length() == 2){
            char[] chars = digits.toCharArray();
            Character first = chars[0];
            Character second = chars[1];
            List<Character> characterList1 = keypad.get(first);
            List<Character> characterList2 = keypad.get(second);
            for(int i=0; i<characterList1.size(); i++ ){
                for(int j=0; j<characterList2.size(); j++){
                    list.add(String.format("%c%c",characterList1.get(i), characterList2.get(j)));
                }
            }
        }

        if(digits.length() == 3){
            char[] chars = digits.toCharArray();
            Character first = chars[0];
            Character second = chars[1];
            Character third = chars[2];
            List<Character> characterList1 = keypad.get(first);
            List<Character> characterList2 = keypad.get(second);
            List<Character> characterList3 = keypad.get(third);
            for(int i=0; i<characterList1.size(); i++ ){
                for(int j=0; j<characterList2.size(); j++){
                    for(int k =0; k< characterList3.size(); k++){
                        list.add(String.format("%c%c%c",characterList1.get(i), characterList2.get(j), characterList3.get(k)));
                    }

                }
            }
        }

        return list;

    }

}
