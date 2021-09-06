package recursion.backtracking;

//https://leetcode.com/problems/word-search/
//Given a 2D board and a word, find if the word exists in the grid.

// tag : 2D array, backtracking/recur
public class WordSearch {
    static boolean[][] visited = new boolean[3][4];

    public static void main(String[] args) {

        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B','C', 'D'} };

        char[]  wordChars = "AAB".toCharArray();
        int row = board.length;
        int col = board[0].length;
        System.out.println(row);
        System.out.println(col);

        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                 if(board[i][j] == wordChars[0]){
                     if(exist(board, wordChars, i, j, 0)){
                         System.out.println("word exist");
                     }
                 }
            }
        }


    }

    // done with the help of gfg
    static boolean existV2(char[][] board, char[] wordChars, int i, int j, int wordCharIndex){
        if(wordCharIndex == wordChars.length){
            // word found
            return true;
        }

        // Out of Boundary
      if(i < 0 || j < 0 || i > 2 || j >3){
          return false;
      }
      if(board[i][j] == wordChars[wordCharIndex]){
          char temp = board[i][j];
          board[i][j] = '#'; // mark the position visited. Not using extra space.

          // finding subpattern in 8 directions
          boolean res = existV2(board, wordChars, i-1, j, wordCharIndex+1) ||
                  existV2(board, wordChars, i+1, j, wordCharIndex+1) ||
                  existV2(board, wordChars, i, j-1, wordCharIndex+1) ||
                  existV2(board, wordChars, i, j+1, wordCharIndex+1) ||
                  existV2(board, wordChars, i+1, j+1, wordCharIndex+1) ||
                  existV2(board, wordChars, i-1, j-1, wordCharIndex+1) ||
                  existV2(board, wordChars, i+1, j-1, wordCharIndex) ||
                  existV2(board, wordChars, i-1, j+1, wordCharIndex);

          // mark unvisited
          board[i][j] = temp;
          return res;
      }
      return false; // no match
    }


    

    // done by me. no help
    static boolean exist(char[][] board, char[] wordChars, int i, int j, int wordCharIndex){

        int row = board.length;
        int col = board[0].length;

        if(i < 0 || j < 0 || i >= row || j >= col){
            return false;
        }

        if(board[i][j] == wordChars[wordCharIndex]){
            char temp = board[i][j];
            board[i][j] = '*'; // mark visited
            wordCharIndex++;
            if(wordCharIndex == wordChars.length){
                // word found
                System.out.println("word found");
                return true;
            }else {

                // finding subpattern in 4 directions
                boolean result = exist(board, wordChars, i-1, j, wordCharIndex) ||
                        exist(board, wordChars, i+1, j, wordCharIndex) ||
                        exist(board, wordChars, i, j-1, wordCharIndex) ||
                        exist(board, wordChars, i, j+1, wordCharIndex);

                board[i][j] = temp;
                return result;
                
            }
        }
        return false;
    }
}
