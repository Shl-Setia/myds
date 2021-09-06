package arrays;

// https://leetcode.com/problems/intersection-of-two-arrays/
// find solution in linear time, assuming arrays are sorted.

import java.util.Arrays;

public class IntersectionofTwoArrays {

    public static void main(String[] args) {
        int one [] = {4,9,5};
        int two [] = {9,4,9,8,4};

        Arrays.sort(one);  // 4,5,9
        Arrays.sort(two); // 4,4,8,9,9

        int left = 0; int right = 0;

        while(left < one.length && right < two.length){
            if(one[left] == two[right]){
                System.out.println(one[left]);
                left++;
                right++;
            }else if(one[left] > two[right]){
                while(one[left] > two[right]){
                    right++;
                }
            }else { // left < right
                while(one[left] < two[right]){
                    left++;
                }
            }
        }


    }
}
