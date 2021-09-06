package binaryTree.bst;

import binaryTree.TreeNod;

//https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_776.java
public class SplitBST {

    public static void main(String[] args) {
        int bst [] = {4,2,6,1,3,5,7};
        int V = 2;

        TreeNod leaf1 = new TreeNod(1);
        TreeNod leaf3 = new TreeNod(3);
        TreeNod leaf5 = new TreeNod(5);
        TreeNod leaf7 = new TreeNod(7);

        TreeNod node2 = new TreeNod(2, leaf1, leaf3);
        TreeNod node6 = new TreeNod(6, leaf5, leaf7);

        TreeNod root = new TreeNod(4, node2, node6);


    }

}
