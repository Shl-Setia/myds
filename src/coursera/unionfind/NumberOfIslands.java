package coursera.unionfind;

// using union find approach
public class NumberOfIslands {
    public static void main(String[] args) {
        int a[][] = {{1,1,1,1,0},
                     {1,1,0,1,0},
                     {1,1,0,0,0},
                     {0,0,0,0,0}};


        int b[][] = {{1,1,0,0,0},
                     {1,1,0,0,0},
                     {0,0,1,0,0},
                     {0,0,0,1,1}};
        int size = numOfIsland(b);
        System.out.println(size);
    }

    private static int numOfIsland(int grid[][]) {
        if(grid == null || grid.length ==0 || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        WeightedQuickUnionUFWithPathCompression uf = new WeightedQuickUnionUFWithPathCompression(row, col, grid);

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 0) continue;

                int p = i * col + j;

                // move right
                if(j < col-1 && grid[i][j+1] == 1) {
                    int q = i * col + j + 1;

                    uf.union(p,q);
                }

                //move down
                if(i<row -1 && grid[i+1][j] == 1) {
                    int q = (i + 1) * col + j;
                    uf.union(p,q);
                }

            }
        }

        return uf.size();
    }
}
