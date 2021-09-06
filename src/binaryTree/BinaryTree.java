package binaryTree;

import java.util.*;

public class BinaryTree {

    TreeNode root;


    public static void main(String[] args) {

        //[3,9,20,null,null,15,7]
        //int [] vals = {3,9,20,-1,-1,15,7};

        BinaryTree bt = new BinaryTree();
        bt.createTree();
        //bt.levelOrderTranversal();
        //bt.InOrderTraversalNonRecursive();
        //bt.zigzagTranverse();
        bt.verticalOrderTraversal(bt.root);

        //lowestCommonAncestor();



    }

    void levelOrderTranversal(){
        // requires Queue
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = ((LinkedList<TreeNode>) queue).poll();
            System.out.println(current.val);
            if(current.left != null){
                ((LinkedList<TreeNode>) queue).add(current.left);
            }
            if(current.right != null){
                ((LinkedList<TreeNode>) queue).add(current.right);
            }
        }
    }

    void InOrderTraversalNonRecursive(){
        // requires stack
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return;
        }
        TreeNode cur = root;
        while(cur!= null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;

        }

    }

    // bfs zigzag
    void zigzagTranverse(){
        // zig zag requires 2 stacks
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root == null){
            return;
        }
        boolean left_right = true;
        stack1.push(root);

        while(!stack1.empty() || !stack2.empty()){
            if(left_right){
                while(!stack1.empty()){
                    TreeNode cur = stack1.pop();
                    System.out.println(cur.val);
                    if(cur.left != null)
                    stack2.push(cur.left);
                    if(cur.right != null)
                    stack2.push(cur.right);
                }
                left_right = false;
            }else {
                while (!stack2.empty()){
                    TreeNode cur = stack2.pop();
                    System.out.println(cur.val);
                    if(cur.right != null)
                    stack1.push(cur.right);
                    if(cur.left != null)
                    stack1.push(cur.left);
                }
                left_right = true;
            }
        }


    }


    private void verticalOrderTraversal(TreeNode root){
        Map<Integer, List<Integer>> map = new HashMap<>();
        verticalOrder(root, 0, map);
        System.out.println(map);

    }

    // preprocessing required to print in vertical order.
    // root node it at x= 0, its left = -1 and right = 1.
    private void verticalOrder(TreeNode root, int x, Map<Integer, List<Integer>> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(x)){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(x, list);
        }else {
            map.get(x).add(root.val);
        }
        verticalOrder(root.left, x-1, map);
        verticalOrder(root.right, x +1, map );
    }




// this is using array to represent the binary tree
    // this is using iterative approach not recursion


    // option 1 in single tranversal: https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

    TreeNode findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    TreeNode findLCA(TreeNode node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.val == n1 || node.val == n2)
            return node;

        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCA(node.left, n1, n2);
        TreeNode right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }


    private static TreeNode flag;

    public static void FlattenToLinkedList(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current.right != null){
                stack.push(current.right);
            }

            if(current.left != null){
                stack.push(current.left);
            }

            if(!stack.isEmpty()){
                current.right = stack.peek();
            }
            current.left = null;
        }
    }






    void createTree(){
        this.root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    }

    void createTree2(){
        TreeNode level1L = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode level1R = new TreeNode(5, null, new TreeNode(6));
        this.root = new TreeNode(1, level1L, level1R);
    }

    void createTree3(){
        TreeNode level1L = new TreeNode(3, new TreeNode(5, new TreeNode(6), null),  null);
        TreeNode level1R = new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7)));
        this.root = new TreeNode(1, level1L, level1R);
    }

    public int maxWidth(){
        if(root == null){
            return -1;
        }
        DecoratedNode node = new DecoratedNode(root, 1, 0);
        Queue<DecoratedNode> queue = new LinkedList<>();
        queue.add(node);

        int currdept = 0; int ans =0; int leftPostion = 1;
        while (!queue.isEmpty()){
            DecoratedNode node1 = queue.poll();
            if(node1.node != null){
                queue.add(new DecoratedNode(node1.node.left, node1.position * 2, node1.dept + 1 ));
                queue.add(new DecoratedNode(node1.node.right, (node1.position * 2) + 1, node1.dept + 1 ));
                if(currdept != node1.dept){
                    currdept = node1.dept;
                    leftPostion = node1.position;
                }

                ans = Math.max(ans, node1.position - leftPostion + 1);
            }


        }

        return ans;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public class DecoratedNode{
        TreeNode node;
        int position;
        int dept;

        public DecoratedNode(TreeNode node, int position, int dept) {
            this.node = node;
            this.position = position;
            this.dept = dept;
        }
    }
}
