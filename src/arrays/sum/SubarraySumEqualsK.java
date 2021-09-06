package arrays.sum;

import java.util.Arrays;
import java.util.HashMap;

// count of all sub-arrays where sum is K.
// Complexity : Medium to Difficult

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int k = 33;
        int ar [] = {9, 4, 20, 3, 10, 5};

        /*// 1,2,3,4
        int sumAr [] = new int[ar.length];

        int count = 0;
        for (int start = 0; start < ar.length; start++) {  // this is n*n solution
            int sum=0;
            for (int end = start; end < ar.length; end++) {
                sum= sum + ar[end];
                if (sum == k)
                    System.out.println(start + " " + end);
            }
        }*/


        // option 2
        /*int left =0;
        int right = 1;

        int sum =0;
        sum = sum + ar[left] + ar[right];
        while(left < ar.length && right < ar.length){ // this does not work when number are negative
            if( sum == k){
                System.out.println(left + " " + right);
                left++;
                right++;
                if(left < ar.length && right < ar.length)
                sum = sum  + ar[right] - ar[left-1];
            }else if(sum < k){
                right++;
                if(right < ar.length)
                sum = sum + ar[right];
            }else if(sum > k){
                left++;
                if(left < ar.length)
                sum = sum - ar[left-1];
            }
        }*/



        //option 3 is based on Hashmap
        //https://leetcode.com/problems/subarray-sum-equals-k/solution/

        // Good explanation here
        // https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/

        //

        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap<> ();
        //map.put(0, 1);
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
            if (sum == k)
                count++;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(Arrays.deepToString(map.entrySet().toArray()));
        System.out.println(count);


    }
}
