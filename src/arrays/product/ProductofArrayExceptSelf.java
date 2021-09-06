package arrays.product;

// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int a[] = {4,5,1,8,2};

        Integer out[] = new Integer[a.length];

        out[0] = 1;
        // first fill the out with  left product of element.
        for(int i=1; i< a.length; i++){
            out[i] = out[i-1]*a[i-1];
        }
        // out = {1, 4, 20, 20, 160}
        System.out.println(Arrays.deepToString(out));

        // then fill the out with  right product of element and multiply on the fly.

        int R =1;
        for(int j = a.length-2; j>=0; j--){
            R = R * a[j+1];
            out[j] = out[j]*R;
        }
        System.out.println(Arrays.deepToString(out));
    }
}
