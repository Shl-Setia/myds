package leetcode30daychallenge.week1;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/

/*
Concept

        If we take XOR of zero and some bit, it will return that bit
        a XOR 0 = a
        If we take XOR of two same bits, it will return 0
        a XOR a = 0

        a XOR b XOR a = (a XOR a) XOR b = 0 XOR b = b

        So we can XOR all bits together to find the unique number.

*/

public class SingleNumber {

    public static void main(String[] args) {

        int arr[] = {4,16,37,58,4};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int size = nums.length;
        int a = 0;
        for(int index=0; index< size; index++){
            a ^= nums[index];
        }
        return a;
    }
}
