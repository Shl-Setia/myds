package arrays.leftRightPointer;

public class TrappingRainWater {

    //https://leetcode.com/problems/trapping-rain-water/solution/
    // try to use 4th solution using the left and right

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        // atleast 3 elements required. 1, 0, 2.
        // for given index i, water stored = min(left_max(i), right_max(i)) - arr[i]

        int lIn = 0;
        int rIn = arr.length-1;

        int left_max = 0;
        int right_max = 0;

        int waterTrappeedSoFar = 0;

        while (lIn<=rIn){
            if(arr[lIn] < arr[rIn]){
                if(arr[lIn] > left_max){
                    // update max in left
                    left_max = arr[lIn];
                }else {
                    waterTrappeedSoFar = waterTrappeedSoFar +(left_max - arr[lIn]);
                }
                lIn++;
            }else {
                if(arr[rIn] > right_max){
                    // update max in right
                    right_max = arr[rIn];
                }else {
                    waterTrappeedSoFar = waterTrappeedSoFar + (right_max - arr[rIn]);
                }
                rIn--;
            }
        }

        System.out.println(waterTrappeedSoFar);

        solutionUsingExtraSpace();


    }



    private static void solutionUsingExtraSpace() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int[] left = new int[arr.length];

        int[] right = new int[arr.length];

        int lmax = arr[0];
        int rmax = arr[arr.length -1];

        for(int i=0; i< arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);
            left[i] = lmax;
        }

        for(int i=arr.length -1 ; i>=0; i--) {
            rmax = Math.max(rmax, arr[i]);
            right[i] = rmax;
        }

        int ans =0;

        for(int i = 0; i< arr.length; i++) {
            int x = Math.min(left[i], right[i]) - arr[i];
            ans += x;
        }

        System.out.println(ans);

    }



}
