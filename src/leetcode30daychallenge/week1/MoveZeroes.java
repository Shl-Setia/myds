package leetcode30daychallenge.week1;

public class MoveZeroes {

    // idea is to find first zero and then start swap. Swap can only start after finding first zero and then non zeros

    public static void main(String[] args) {

        int nums[] = {0,1,0,3,12};
        // 1,4,0,5,0
        // 1,4,5,0,0
        // 1,3,0,0,12
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
       int size = nums.length;
       Integer nextNumberIndex = null;
       for(int index=0; index<size; index++){

           if(nums[index] == 0 && nextNumberIndex == null){
               nextNumberIndex = index;
           }
           if(nums[index] != 0 && nextNumberIndex != null){
               nums[nextNumberIndex]  = nums[index];
               nums[index] = 0;
               nextNumberIndex++;
           }
       }
        System.out.println(nums);
    }
}
