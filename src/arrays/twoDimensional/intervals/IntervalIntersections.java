package arrays.twoDimensional.intervals;

// https://leetcode.com/problems/interval-list-intersections/

// Two pointer
public class IntervalIntersections {
    public static void main(String[] args) {
        int [][] A = {{0,2}, {5,10}, {13,23}, {24,25}};
        int [][] B = {{1,5}, {8,12}, {15,24}, {25,26}};

        int i =0, j=0; // i for A, j for B.

        while(i < A.length && j < B.length){

            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if(lo <= hi){ // there is intersection

                // next task is to find, out of i and j, which needs to be incremented.
                // This same like merge sort, where we merge two sorted array

                System.out.println(lo +"," + hi);
            }
            // Remove the interval with the smallest endpoint
            if(A[i][1] < B[j][1]){ // compare last element
                i++;
            }else {
                j++;
            }
        }
    }
}
