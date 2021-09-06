package binaryTree;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenToLinkedList {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree2();
        BinaryTree.FlattenToLinkedList(binaryTree.root);

        System.out.println(binaryTree);

    }



}
