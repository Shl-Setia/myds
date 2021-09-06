package coursera.bst;

public class OneDimensionalRangeSearch {
    // Range search: find all keys between k1 and k2.
    // Range count: number of keys between k1 and k2.

    // Application. Database queries

    BST tree;



    // 1d range count. How many keys between lo and hi ?
    public int size(int lo, int hi)
    {
        if (tree.contains(hi))
            return tree.rank(hi) - tree.rank(lo) + 1;
        else return tree.rank(hi) - tree.rank(lo);
    }



}
