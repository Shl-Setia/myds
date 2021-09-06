package arrays.sum;

import java.util.Arrays;

// 2 sum problem
// sort first .
// then find K - a[i] using BS.
public class PairSumEqualToK {
    public static void main(String[] args) {
        int [] in = {1, 5, 7, -1, 5};
        int k = 6;

        int left = 0;
        int right = in.length - 1;
        Arrays.sort(in); // -1, 1,5,5,7

        while(left < right){
            if(in[left] + in[right] == k){
                System.out.println(in[left] + ", " + in[right]);
                left++;
                right--;
            }else if(in[left] + in[right] > k){
                right--;
            }else {
                left++;
            }
        }
    }

    // option is 2 is use map to check if n = k - a[i] exist for each i.
}
