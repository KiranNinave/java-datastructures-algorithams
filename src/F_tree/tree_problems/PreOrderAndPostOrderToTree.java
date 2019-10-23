package F_tree.tree_problems;

// note: only full binary tree i.e node with 0 or 2 child can constructed with pre and post order
// how its works
// first we iterate same as in order and post order
// only diffrence is that for left tree we consider element between root node and next root node

public class PreOrderAndPostOrderToTree {
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

    int ptr; // we need global pointer that decrement on post order

    public TreeNode build(int A[], int B[], int start, int end){
        if(start > end || ptr<0 || ptr > B.length-1) return null;
        TreeNode rootNode = new TreeNode(B[ptr]);
        int i=-1,j=-1;
        for(i=start; i<=end; i++){
            // finding position of root node in pre order array
            if(A[i] == B[ptr]) break;
        }
        if(ptr > 0) {
            // finding next root node position
            // if not found then j=-1 means if will automatically return null i.e node doesn't have left child nodes
            for(j=start; j<=end; j++){
                if(A[j] == B[ptr-1]) break;
            }
        }
        // we found root node so moving to next root node
        // note: finding next root node to current doesn't effect to ptr
        ptr--;

        // the right tree is same as in order and post order
        rootNode.right = build(A, B, i+1, end);

        // the left tree will take elements between current root node and next root node
        // node preorder starts with root node so we start left with start
        // so the start automatically points to current root node and j to next root node
        rootNode.left = build(A, B, start, j-1);
        return rootNode;
    }

    public TreeNode buildTree(int pre[], int post[]){
        ptr = post.length-1; // ptr points to last node of post order i.e root node and for each iteration decrements to get next root node
        return build(pre, post, 0, pre.length-1);
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
        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

        PreOrderAndPostOrderToTree preOrderAndPostOrderToTree = new PreOrderAndPostOrderToTree();
        TreeNode tree = preOrderAndPostOrderToTree.buildTree(pre, post);

        System.out.println("\n--------------in order---------------");
        preOrderAndPostOrderToTree.inOrder(tree);
        System.out.println("\n--------------in order---------------");

        System.out.println("\n--------------post order---------------");
        preOrderAndPostOrderToTree.postOrder(tree);
        System.out.println("\n--------------post order---------------");

        System.out.println("\n--------------pre order---------------");
        preOrderAndPostOrderToTree.preOrder(tree);
        System.out.println("\n--------------pre order---------------");
    }
}
