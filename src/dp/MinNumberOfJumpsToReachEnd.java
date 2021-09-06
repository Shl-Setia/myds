package dp;

// https://www.youtube.com/watch?v=cETfFsSTGJI

import java.util.Arrays;

public class MinNumberOfJumpsToReachEnd {

    public static void main(String[] args){
        Integer arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        //Integer arr[] = {1, 3, 6, 3, 2, 0, 6, 8, 9, 5};
        //Integer arr[] = {5, 4, 3, 2};
        //int i = minJumpsUsingRecursion(arr, 0, arr.length - 1);
        minJumpsUsingDP(arr, arr.length);
        //System.out.println(i);

    }

    // bottom up - DP


    static void minJumpsUsingDP(Integer arr[], int n){
        Integer jumps [] = new Integer[n];

        jumps[0] = 0;

        for(int i=1; i<n; i++){ // i represent TO
            jumps[i] = Integer.MAX_VALUE; // this is to avoid NPE
            for(int j=0; j<i; j++){ // j represent FROM

                if(i <= j + arr[j]){
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(jumps));
    }


    // method one using recursion.  Top down DFS

    /*static int minJumpsUsingRecursion(int arr[], int l, int h){

        System.out.println("method called for l and h and val -> "+ l + " , " + h + " , " + arr[l]);
        // Base case: when source
        // and destination are same
        if( l == h){
            System.out.println("end of array");
            return 0;
        }

        // When nothing is reachable
        // from the given source
        if(arr[l] == 0){
            System.out.println("nothing is reachable");
            return Integer.MAX_VALUE;
        }


        int min = Integer.MAX_VALUE;

        for(int i=l+1; i<=h && i<= l + arr[l]; i++ ){
            int jumps = minJumpsUsingRecursion(arr, i, h);
            if(jumps != Integer.MAX_VALUE && jumps +1 < min){
                min = jumps + 1;
            }
        }
        return min;

    }*/



}
