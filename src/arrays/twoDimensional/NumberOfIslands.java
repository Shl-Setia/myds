package arrays.twoDimensional;

//https://leetcode.com/problems/number-of-islands/

// https://www.geeksforgeeks.org/find-number-of-islands/
public class NumberOfIslands {

    public static void main(String[] args) {
        int a[][] = {{1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}};

        boolean visited [][] = new boolean[a.length][a[0].length];

        int count = 0;

        for(int row=0; row<a.length;row++){
            for(int col = 0; col < a[row].length; col++){
                if(a[row][col] == 1 && !visited[row][col] ){
                   findIsLand(row, col, a, visited);
                   count++;
                }
            }
        }

        System.out.println(count);

    }

    static void findIsLand(int x, int y, int [][] a, boolean visited [][]){
        if(x<0 || x >=a.length || y < 0 || y >=a[0].length || visited[x][y]){ // base condition
            return;
        }
        if(a[x][y] == 1 && !visited[x][y]){
            visited[x][y] = true;
            findIsLand(x+1, y, a,visited); //down
            findIsLand(x-1, y, a,visited); //up
            findIsLand(x, y+1, a,visited); //right
            findIsLand(x, y-1, a,visited); //left

        }
    }

    // time complexity = O(row * col)
}
