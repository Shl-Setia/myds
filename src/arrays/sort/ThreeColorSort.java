package arrays.sort;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/
public class ThreeColorSort {
    public static void main(String[] args) {
        Integer arr [] = {2,0,2,1,1,0};

        int left = 0;
        //int right = arr.length-1;

        int zeroIndex =0;
        int twoIndex = arr.length-1;

        while(left < twoIndex){
            if(arr[left] == 0){
               int temp = arr[zeroIndex];
               arr[zeroIndex] = 0;
               arr[left] = temp;
               zeroIndex++;
            }else if(arr[left] == 2){
                int temp = arr[twoIndex];
                arr[twoIndex] = 2;
                arr[left]=temp;
                twoIndex--;
            }
            left++;
        }

        System.out.println(Arrays.deepToString(arr));

    }
}
