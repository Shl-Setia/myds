package arrays.sum;

// Kadane's algo

public class MaxSubArraySum {
    public static void main(String[] args) {

        int nums[]  = {-2,1,-3,4,-1,2,1,-5,4};
        int globalMaximaSum = nums[0];
        int currentSum = nums[0];

        int size = nums.length;

        for(int index=1; index<size; index++){
            // either add the new element to current sum or start new array from new element.
            currentSum = Math.max(nums[index], currentSum+nums[index]);
            globalMaximaSum = Math.max(globalMaximaSum, currentSum);
        }

        System.out.println(globalMaximaSum);
    }
}
