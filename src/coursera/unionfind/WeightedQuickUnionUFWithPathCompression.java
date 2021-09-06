package coursera.unionfind;


// Integer array id[] of length N.
// Interpretation: id[i] is parent of i.
// Root of i is id[id[id[...id[i]...]]].

public class WeightedQuickUnionUFWithPathCompression {

    private int [] id ; // value represent parent/root
    private int [] size; // value represent tree size of given parent/root
    private int count; // represent connected component in 2d.


    public WeightedQuickUnionUFWithPathCompression(int N) {
        this.id = new int[N];
        this.size = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    public WeightedQuickUnionUFWithPathCompression(int row, int col, int[][] grid) {
        int N = row * col;
        this.id = new int[N];
        this.size = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1) this.count++;
            }
        }
    }

    private int root(int i) {
        while(i != id[i]) {
            // this is for path compression.
            // Make every other node in path point to its
            // grandparent (thereby halving path length).
            id[i] = id[id[i]];

            i = id[i];
        }
        return i;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public int size () {
        return count;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        //Link root of smaller tree to root of larger tree.
        if(size[i] < size[j]) {
            id[i] = id[j]; // assign value of j(bigger) to i (smaller)--- smaller updated.
            size[j] = size[j] + size[i];
        }else {
            id[j] = id[i];
            size[i] = size[i] + size[j];
        }
        count--;
    }
}
