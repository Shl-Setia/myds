package arrays.search;

import java.util.HashSet;

public class FirstFirstDuplicate2 {
    //First Duplicate for which second occurrence has minimal index, asked in Google. Elements in array of size N are from 1 to N
    // no extra space
    public static void main(String[] args) {

        int arr[] = {1,2,1,2,3,3};
        //int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};
        //2,1,3,5,3,2
        HashSet<Integer> set = new HashSet();
        int min_index = 100;

        for(int i=0; i< arr.length; i++){
            if(set.contains(arr[i])){

                min_index = Math.min(min_index, i);
            }else {
                set.add(arr[i]);
            }
        }

        System.out.println(arr[min_index]);




    }
}
