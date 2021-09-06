package arrays.leftRightPointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    //https://leetcode.com/problems/find-k-closest-elements/

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int  k = 4;
        int  pivot = 2;


        if(pivot <= list.get(0)){
            list.subList(0, k);
        }else if(pivot >= list.get(list.size()-1)){
            list.subList(list.size() - k, list.size());
        }else{
            int index = Collections.binarySearch(list, pivot);
            System.out.println(index);
            //int left = Math.max(0, index - k - 1);
            //int right = Math.min(list.size() - 1, index + k - 1);
            int left = index -1;
            int right = index + 1;
            int low = index;
            int high = index;

            while(true){
                if(high - low + 1== k){ // 1 is added in include index element
                    break;
                }
                if(left >= 0 && right < list.size()){
                    if(list.get(left) <= list.get(right)){
                        left--; // move to next lower
                        low--;  // include it in range
                    }else {
                        right++; // move pointer to next higher
                        high++; // include it in range
                    }
                }else if(left >=0){
                    left--; // move to next lower
                    low--;  // include it in range
                }else if(right < list.size()){
                    right++; // move pointer to next higher
                    high++; // include it in range
                }

            }

            System.out.println(Arrays.deepToString(list.subList(low, high+1).toArray()));

        }
    }
}
