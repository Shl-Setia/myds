package arrays.median;

public class FindMedianFromStream {
    //https://leetcode.com/problems/find-median-from-data-stream/solution/


    // There are multi ways to solve this
    // Heaps and Self balancing BST tree(LLRB tree) is best

    // This class uses option 2 ie Keep the list sorted and then it easy to find median
    // When add the element, since list is already sorted use insertion sort using the binary search
    // and find the index where the new element is inserted and then swap the right elements

    // other way is to use heaps/priority queue



}
