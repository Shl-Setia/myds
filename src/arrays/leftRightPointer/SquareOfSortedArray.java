package arrays.leftRightPointer;

import java.util.Arrays;

public class SquareOfSortedArray {

    //https://leetcode.com/problems/squares-of-a-sorted-array/solution/

    //Input: [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]

    // Option 1. Square it and then sort it. Time NlogN

    // option2. Used left right pointer to place abs(element) at right place and square it. Time N.
    // trick: start adding elements from end of array

    public static void main(String[] args) {
        Integer [] input =  {-4,-1,0,3,10};
        //Output: [0,-1,3,-4,100]
        Integer [] out = new Integer[input.length];

        int left =0;
        int right = input.length-1;
        int i = input.length - 1;

        while(left <= right) {
            if(Math.abs(input[left])  > Math.abs(input[right])){
                out[i] = Math.abs(input[left]);
                left++;
            }else {
                out[i] = Math.abs(input[right]);
                right--;
            }
            i--;
        }
        System.out.println(Arrays.deepToString(out));

    }
}
