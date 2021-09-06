package recursion.permutation;

/*
* A permutation, also called an “arrangement number” or “order”, is a rearrangement
* of the elements of an ordered list S into a one-to-one correspondence with S itself.
 * A string of length n has n! permutation.
 * Below are the permutations of string ABC.
 * “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB” */

import java.util.Arrays;

public class PrintAllPermutation {

    static Character [] data = new Character[3];
    static char [] input = {'A', 'B', 'C'};

    // 3 items and 3 spaces


    public static void main(String[] args) {
       //print2(0);
        //System.out.println("----");
        printPermutationWithoutRepeat(0);
        //printPermutationWithRepeat1(0);
    }


    // simple way of printing all permutation. without for loop
    // this is with repeat. Time = n^r = 3^3 = 27
    static void printPermutationWithRepeat1(int  index){

        if(3 == index){
            System.out.println(Arrays.deepToString(data));
            return;
        }
        data[index] = 'A';
        printPermutationWithRepeat1(index+1);

        data[index] = 'B';
        printPermutationWithRepeat1(index+1);

        data[index] = 'C';
        printPermutationWithRepeat1(index+1);
    }


    // same as above with for loop.
    static void printPermutationWithRepeat2(int index) {
        if(3 == index) {
            System.out.println(Arrays.deepToString(data));
            return;
        }

        for(int i=0; i<data.length; i++) {
            data[index] = input[i];
            printPermutationWithRepeat2(index+1);
        }

    }


    static boolean[] alpha = new boolean[26];

    // printing all permutation, without repeat. Time = n! = 3! = 3*2=6.
    static void printPermutationWithoutRepeat(int index) {

        if(3 == index){
            System.out.println(Arrays.deepToString(data));
            return;
        }


        for(int i=0; i<data.length; i++) {
            char ch = input[i];
            data[index] = ch;

            // If the character has not been used
            // then recursive call will take place.
            // Otherwise, there will be no recursive
            // call
            if(!alpha[ch - 'A']){
                alpha[ch - 'A'] = true;
                printPermutationWithoutRepeat(index+1);
                alpha[ch - 'A'] = false;
            }


        }

    }
}
