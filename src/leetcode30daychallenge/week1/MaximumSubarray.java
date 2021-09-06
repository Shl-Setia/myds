package leetcode30daychallenge.week1;


public class MaximumSubarray {
    public static void main(String[] args) {

        //int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int [] nums = {-2,1,-3};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int maxSumSoFar = nums[0];
        int currentSum = nums[0];

        int size = nums.length;

        //Algorithmic Paradigm: Dynamic Programming
        // kadanes algo
        for(int index=1; index<size; index++){
            int tmp = currentSum+nums[index];
            currentSum = Math.max(nums[index], tmp);
            System.out.println("max of " + nums[index] + ", " + tmp + ": " + currentSum);
            System.out.print("max of " + currentSum + ", " + maxSumSoFar);
            maxSumSoFar = Math.max(maxSumSoFar, currentSum);
            System.out.println(": " + maxSumSoFar);
        }

        return maxSumSoFar;
    }


}
