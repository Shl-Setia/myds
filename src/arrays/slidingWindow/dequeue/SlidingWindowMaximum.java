package arrays.slidingWindow.dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {


    // option 1, deque isize equal to window size
    /*public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        int [] arr = {1,3,-1,-3,5,3,6,7};
        int w = 3;

        int max = arr[0];
        int maxIndex = 0;
        deque.addLast(0);
        // first find the max and max_index from first w element
        for(int i= 1; i < w; i++){
            if(arr[i] >= max){
                max = arr[i];
                maxIndex = i;
            }
            deque.addLast(i); // not we are storing index not val.
        }

        System.out.println("-- " + max);

        // then, remove from front and add from back, and find the max w.r.t element removed/added
        // If list is ascending order, every new element added is max.
        // If list is descending then, every first element after removal is max.

        for(int i= w; i< arr.length; i++){
            int removedIndex = deque.removeFirst();
            // check if removed index is of max element
            if(removedIndex == maxIndex){
                // again find the max in remaining set
                // i - w is gone, find max from i - w + 1 to i -1
                max = arr[deque.peekFirst()];
                maxIndex = deque.peekFirst();

                for(int j = i - w + 2; j <= i -1; j++){
                    if(arr[j] >= max){
                        max = arr[j];
                        maxIndex = j;
                    }
                }

            }
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
            System.out.println("-- " + max);
            deque.addLast(i);

        }

    }*/

    // option 2
    // Further optimization, Queue size not need to be window size and it should
    // store only elements that need to be considered, i.e. right of max. Remove all elements left of max/
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        int [] arr = {1,3,1,2,0,5};
        int w = 3;
        int [] ans = new int[arr.length - w + 1];

        int maxIndex = 0;
        deque.addFirst(maxIndex); // not we are storing index not val.

        int left = 0;
        int right= 1;

        // first find the max and max_index from first w element
        for(; right < w; right++){
            if(arr[right] >= arr[deque.peekFirst()]){
                // remove all elements left of current max
                while(deque.size() != 0){
                    deque.removeFirst();
                }
            }
            deque.addLast(right);
        }


        System.out.println(arr[deque.peekFirst()]);
        ans[left] = arr[deque.peekFirst()];

        left++;

        for(; right< arr.length; right++, left++){
            if(left <= deque.peekFirst() ){
                // max is still part of window
                if(arr[right] >= arr[deque.peekFirst()]){
                    while(deque.size() != 0){
                        deque.removeFirst();
                    }
                    deque.addFirst(right);
                }else {
                    deque.addLast(right);
                }

            }else{
                // find new max
                while(deque.size() != 0){
                    deque.removeFirst();
                }
                int i = left;

                deque.addFirst(i);

                for(i = i+1; i <= right; i++){
                    if(arr[i] >= arr[deque.peekFirst()]){
                        // remove all elements left of current max
                        while(deque.size() != 0){
                            deque.removeFirst();
                        }
                    }
                    deque.addLast(i);
                }
            }
            System.out.println( arr[deque.peekFirst()]);
            ans[left] = arr[deque.peekFirst()];
        }
    }



}
