package arrays.search;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstDuplicateByIndex {

    public static void main(String[] args) {
        int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};


        // option 1 is to use LinkedHashMap

        Map<Integer, Integer> valueToFrequency= new LinkedHashMap<>(); // it maintains order

        for(int i=0; i<arr.length; i++){
            if(valueToFrequency.containsKey(arr[i])){
                valueToFrequency.put(arr[i], valueToFrequency.get(arr[i])+1);
            }else {
                valueToFrequency.put(arr[i], 1);
            }

        }

        for(int i=0; i<arr.length; i++){
            if(valueToFrequency.get(arr[i]) > 1){
                System.out.println("first duplicate " + arr[i]);
                break;
            }

        }

        // Option 2

        // use hashset and move Right to Left, and update the min index

        // Initialize index of first repeating element
        int min = -1;

        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array from right to left
        for (int i=arr.length-1; i>=0; i--)
        {
            // If element is already in hash set, update min
            if (set.contains(arr[i]))
                min = i;

            else   // Else add element to hash set
                set.add(arr[i]);
        }

        // Print the result
        if (min != -1)
            System.out.println("The first repeating element is " + arr[min]);
        else
            System.out.println("There are no repeating elements");
    }
}
