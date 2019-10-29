package F_tree.tree_problems;


// this is O(n^2) solution if we want O(n) then replace searching of root element with hashmap

public class InOrderAndPostOrderToTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    int nodePtr = 0; // we are making pointer global always point to last element of post order because last element of post order is root

    public TreeNode build(int inOrder[], int postOrder[], int inOrderStart, int inOrderEnd){
        if(inOrderStart > inOrderEnd || nodePtr < 0 || inOrderStart<0) return null; // this will handle one sided tree as well

        // making last node of postOrder as root
        TreeNode root = new TreeNode(postOrder[nodePtr]);

        // iterating in inorder to find position of root node
        int i;
        for(i=inOrderStart; i<=inOrderEnd; i++){
            if(nodePtr >= 0 && inOrder[i] == postOrder[nodePtr]) break;
        }

        // we found root node postion so moving to next root or sub root node
        nodePtr--;

        // now every thing in left side of root element is left subtree
        // and every thing in right side of root element is right subtree
        // but as it is post order LRV so first called with right subtree

        root.right = build(inOrder, postOrder, i+1, inOrderEnd);
        root.left = build(inOrder, postOrder, inOrderStart, i-1);

        return root;
    }

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        nodePtr = postOrder.length-1;
        return build(inOrder, postOrder, 0, inOrder.length-1);
    }

    // for printing result
    public void inOrder(TreeNode root){
        if(root.left != null){
            inOrder(root.left);
        }
        System.out.print(root.val + ", ");
        if(root.right != null){
            inOrder(root.right);
        }
    }

    // for printing result
    public void postOrder(TreeNode root){
        if(root.left != null) {
            postOrder(root.left);
        }
        if(root.right != null){
            postOrder(root.right);
        }
        System.out.print(root.val + ", ");
    }

    // for printing result
    public void preOrder(TreeNode root){
        System.out.print(root.val + ", ");
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null) {
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        int inOrder[] = {7, 5, 6, 2, 3, 1, 4};
        int postOrder[] = {5, 6, 3, 1, 4, 2, 7};

        InOrderAndPostOrderToTree inOrderAndPostOrderToTree = new InOrderAndPostOrderToTree();


        TreeNode tree = inOrderAndPostOrderToTree.buildTree(inOrder, postOrder);

        System.out.println("\n--------------in order---------------");
        inOrderAndPostOrderToTree.inOrder(tree);
        System.out.println("\n--------------in order---------------");

        System.out.println("\n--------------post order---------------");
        inOrderAndPostOrderToTree.postOrder(tree);
        System.out.println("\n--------------post order---------------");

        System.out.println("\n--------------pre order---------------");
        inOrderAndPostOrderToTree.preOrder(tree);
        System.out.println("\n--------------pre order---------------");
    }
}
