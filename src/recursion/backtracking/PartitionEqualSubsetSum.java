package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr [] = {1, 2, 3, 5};
        Arrays.sort(arr); // 1,5,5,11

        int sum =0;
        for(int a : arr){
            sum += a;
        }

        if(sum%2 == 1){ // odd number can not be divided into 2 parts.
            System.out.println("not possible");
            return;
        }

        int target = sum/2;

        canPartitionEqualSubsetSum(arr, 0, target);

    }
    static boolean canPartitionEqualSubsetSum(int arr[], int index, int target){

        if (target == 0) {
            System.out.println("yes");
            return true;
        }

        if(target < 0){
            System.out.println("no...");
            return false;
        }
        System.out.println();
        for(int i=index; i<arr.length; i++){
            if(canPartitionEqualSubsetSum(arr, index+1, target - arr[i])){
                return true;
            }
        }

        return false;
    }
}
