package recursion.permutation;


/*
* Approach: The idea is to try every permutation(rearrangement/reorder). For every position,
* there are 2 options, either ‘0’ or ‘1’.
 * Backtracking is used in this approach to try every possibility/permutation.*/


// When the order does matter it is a Permutation. Ex- Passwords, ids,
// Permutation with repeat. (n^r). where n is no. of things to choose from and we choose r of them.
// Permutation without repeat. Without repetition our choices get reduced each time.
// when choose all without repeat. ( n! - n factorial - 5*4*3*2*1).
// When choose r out of n without repeat.  ( n! / (n - r)!)

// When the order doesn't matter, it is a Combination.
// Repetition is Allowed: such as coins in your pocket (5,5,5,10,10)
// No Repetition: such as lottery numbers (2,14,15,27,30,33)
// No Repetition :
// we adjust our permutations formula to reduce it by how many ways the objects
// could be in order (because we aren't interested
// in their order any more): n! / (n - r)! * 1/r! = n! / r!(n - r)!

// TODO https://www.mathsisfun.com/combinatorics/combinations-permutations.html

// n! eventually grows faster than an exponential with a constant base (2^n and e^n),
// but n^n grows faster than n! since the base grows as n increases.

public class PrintBinaryOfNBits {

    // This problem is of type Permutation with repeat.
    // time complexity = n^r, where n is 2 (0,1) and r is 4 ( length of binary string).
    // hence time = 2^4.
    public static void main(String[] args) {

        int N = 4;
        int [] arr = new int[N];

        generateBinaryString(N, arr, 0);
        // 2 items and 4 spaces
    }

    static void generateBinaryString(int size, int [] arr,  int index) {
        if(size == index) {
            // print the array
            printArray(arr, size);
            return;
        }
        // First assign "0" at ith position
        // and try for all other permutations
        // for remaining positions
        arr[index] = 0;
        generateBinaryString(size, arr, index+1);

        // And then assign "1" at ith position
        // and try for all other permutations
        // for remaining positions
        arr[index] = 1;
        generateBinaryString(size, arr, index+1);


        // given position can be filled with 3rd possible val
        //arr[index] = 2;
        //generateBinaryString(size, arr, index+1);
    }

    static void printArray(int [] data, int size) {
        for (int i = 0; i < size; i++)
        {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }


}
