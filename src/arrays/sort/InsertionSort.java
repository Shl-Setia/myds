package arrays.sort;


//https://www.youtube.com/watch?v=yCxV0kBpA6M

//https://leetcode.com/problems/find-median-from-data-stream/solution/

import java.util.Arrays;

//Which algorithm allows a number to be added to a sorted list of numbers
// and yet keeps the entire list sorted? Well, for one, insertion sort!
public class InsertionSort {
    // It works best when array is already sorted i.e. in ascending order. O(N)
    // Worsts case is when when array is in descending order. O(n^2)


    // we divide th list into two parts
    // 1. Sorted : a[0]
    // 2. Unsorted : a[1....n]

    // then take one element from unsorted list and INSERT it into correct place of sorted list.

    public static void main(String[] args) {

        Integer arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};

        System.out.println(Arrays.deepToString(arr));
        for(int i=1; i< arr.length; i++) {
            int next = arr[i];
            int nextIndex = i;

            System.out.println("iteration -> "+ next);
            for(int j= i-1; j>=0; j--) {
                if(arr[j] > next) {
                    // swap arr[j] and arr[i]
                    int temp = arr[nextIndex];
                    arr[nextIndex] = arr[j];
                    arr[j] = temp;
                    nextIndex = j;
                    //System.out.println(next);
                    System.out.println(Arrays.deepToString(arr));
                }
            }

            /*int j= i-1;
            while(j >= 0) {
                if(arr[j] > next) {
                    // swap
                    arr[i] = arr[j];
                    arr[j] = next;
                    //nextIndex = j;
                    System.out.println(Arrays.deepToString(arr));
                }
                j--;
            }*/
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
