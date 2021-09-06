package arrays.slidingWindow;

// SLiding window concept. Facebook
//https://www.youtube.com/watch?v=XFPHg5KjHoo
public class LargestSubArrayBySum {

    // Array and Number is given, find the largest subarray whose sum = Number
    // Idea is take two pointer left and right,  keep adding the next element until sum == number Or all elements
    // are not iterated. pop the element from left if sum > number
    //
    public static void main(String[] args) {

        int a[] = {1,2,3,7,5};
        int num = 12;


        int [] result = {0, 0};

        int left = 0;
        int right = 0;
        int sum =0;

        while(right < a.length){

            sum = sum + a[right];

            // this condition must come first
            if(sum > num){
                // pop from left while sum is greater than num
                while(left < right && sum > num){
                    sum = sum - a[left];
                    left++;
                }

            }

            if(sum == num ){
                int currentSubArraySize = right - left;

                int largestSubArrayBySumSoFar = result[1] - result[0];

                if(currentSubArraySize > largestSubArrayBySumSoFar){
                    result[0] = left;
                    result[1] = right;
                }
            }

            right++;
        }

        System.out.println(result[0] + "," + result[1]);

    }
}
