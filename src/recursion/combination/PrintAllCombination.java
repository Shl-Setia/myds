package recursion.combination;



// Method 1.for set with N values, there are 2^N combinations.

// Method 2. printing combination can also be done using printing binary number of
// size equal to values in the set i.e. N.  Printing binary come under permutation.

import java.util.Arrays;

public class PrintAllCombination {

    public static void main(String[] args) {
        // Method 2
        Integer N = 3;
        Integer [] arr = new Integer[N];
        print(N, arr, 0);
    }

    // Method 2
    static void print(int size, Integer arr[], int index) {
        if(index == size) {
            //System.out.println(Arrays.deepToString(arr));
            printCombination(arr, size);
            return;
        }

        arr[index] = 0;
        print(size, arr, index+1);

        arr[index] = 1;
        print(size, arr, index+1);
    }

    // Method 2
    static void printCombination(Integer arr[], int size) {
        for( int i =0 ; i < size; i++) {
            if(i == 0 && arr[i] == 1){
                System.out.print('a');
            }
            if(i == 1 && arr[i] == 1){
                System.out.print('b');
            }
            if(i == 2 && arr[i] == 1){
                System.out.print('c');
            }
        }
        System.out.println();
    }

    // not preferred
    void method1() {
        char [] set = new char[3];
        set[0] = 'a';
        set[1] = 'b';
        set[2] = 'c';
        //set[3] = 'd';
        /*set[4] = 'e';
        set[5] = 'f';
        set[6] = 'g';
        set[7] = 'h';
        set[8] = 'i';
        set[9] = 'j';*/



        int n = set.length;

        // Run a loop for printing all 2^n
        // x<<y means, x = x*2^y.
        // In this case (1<<3) = 1 * 2^3 = 8
        // subsets one by one

        double total = Math.pow(2, n);

        for (int i = 0; i < total; i++)
        {

            //System.out.print("{ ");


            // Print current subset
            for (int j = 0; j < n; j++) {

                /* Check if jth bit in the
                counter is set. If set, then
                print jth element from set */


                int k = (int) Math.pow(2, j); // == (1 << j)

                if ((i & k) > 0) { // if((i & (1 << j)) > 0)

                    System.out.print(set[j] + " ");
                }
            }

            // (1<<j) is a number with jth bit 1
            // so when we 'and' them with the
            // subset number, we get which numbers
            // are present in the subset and which
            // are not



            System.out.println();
        }
        // time complexity = n* 2^n.
    }


    // Method 2, using printing binary


}
