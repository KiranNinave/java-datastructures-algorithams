package F_tree.tree_problems;

// this is O(n^2) solution if we want O(n) then replace searching of root element with hashmap

public class InOrderAndPreOrderToTree {
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

    int nodePtr = 0; // we are making node pointer global and pointing to first element of preOrder array because preOrder first element is root element

    public TreeNode buid(int[] inOrder, int[] preOrder, int inOrderStart, int inOrderEnd){
        if(inOrderStart > inOrderEnd || nodePtr > preOrder.length-1) return null; // this will handle both null elements

        // creating root node
        TreeNode rootNode = new TreeNode(preOrder[nodePtr]);

        // finding root node postion in in order array
        int i;
        for(i=inOrderStart; i<=inOrderEnd; i++){
            if(inOrder[i] == preOrder[nodePtr]) break;
        }

        // we found root position so incrementing node pointer to find next root
        nodePtr++;

        // in in order everything left to the root element is left subtree and
        // everything right to the root element is right subtree
        // its pre order VLR so we give left element first priority

        rootNode.left = buid(inOrder, preOrder, inOrderStart, i-1);
        rootNode.right = buid(inOrder, preOrder, i+1, inOrderEnd);

        return rootNode;
    }

    public TreeNode buildTree(int[] inOrder, int[] preOrder){
        nodePtr = 0;
        return buid(inOrder, preOrder, 0, inOrder.length-1);
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
        int preOrder[] = {7, 2, 6, 5, 4, 1, 3 };

        InOrderAndPreOrderToTree inOrderAndPreOrderToTree = new InOrderAndPreOrderToTree();


        TreeNode tree = inOrderAndPreOrderToTree.buildTree(inOrder, preOrder);

        System.out.println("\n--------------in order---------------");
        inOrderAndPreOrderToTree.inOrder(tree);
        System.out.println("\n--------------in order---------------");

        System.out.println("\n--------------post order---------------");
        inOrderAndPreOrderToTree.postOrder(tree);
        System.out.println("\n--------------post order---------------");

        System.out.println("\n--------------pre order---------------");
        inOrderAndPreOrderToTree.preOrder(tree);
        System.out.println("\n--------------pre order---------------");
    }
}
