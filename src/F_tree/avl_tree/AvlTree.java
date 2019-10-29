package F_tree.avl_tree;

import F_tree.binary_search_tree.TreeNode;

public class AvlTree {
    AvlTreeNode root;

    public  AvlTree(){
        root = null;
    }

    public void insert(int data){
        root = insert(root, data);
    }

    public void delete(int data){
        root = delete(root, data);
    }

    private AvlTreeNode insert(AvlTreeNode root, int data){
        if(root == null) {
            root = new AvlTreeNode(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }

        if(data > root.data){
            root.right = insert(root.right, data);
        }


        // update height and balence factor
        root = updateHeightAndBalenceFactor(root);


        if(root.bf == 2){
            // left heavy avl tree
            if(root.left.bf >= 0 ){
                // left left operation
                System.out.println("performing left left for " + root.data);
                root = this.leftLeftRotation(root);

            }else {
                // left right operation
                System.out.println("performing left right for " + root.data);
                root = this.leftRightRotation(root);
            }
        }
        else if(root.bf == -2){
            // right heavy avl tree
            if(root.right.bf <= 0){
                // right right rotation
                System.out.println("performing right right for " + root.data);
                root = this.rightRightRotation(root);
            }
            else {
                // right left rotation
                System.out.println("performing right left for " + root.data);
                root = this.rightLeftRotation(root);
            }
        }

        return root;
    }


    private AvlTreeNode delete(AvlTreeNode root, int data){
        if(root == null) return root;

        if(data < root.data){
            root.left = delete(root.left, data);
        }
        else if(data > root.data){
            root.right = delete(root.right, data);
        }else {
            // we have match

            // this will work for both 0 or 1 child nodes
            // node with only right node
            if(root.left == null){
                return root.right;
            }
            // node with only one left node
            else if(root.right == null){
                return root.left;
            }
            else {
                // node have two children

                // finding minimum in right subtree
                int min = root.right.getMin();

                // swap data with minimum
                root.data = min;

                // delete minimum node from right tree
                root.right = delete(root.right, min);
            }
        }

        // update height and balence factor
        root = updateHeightAndBalenceFactor(root);


        if(root.bf == 2){
            // left heavy avl tree
            if(root.left.bf >= 0 ){
                // left left operation
                System.out.println("performing left left for " + root.data);
                root = this.leftLeftRotation(root);

            }else {
                // left right operation
                System.out.println("performing left right for " + root.data);
                root = this.leftRightRotation(root);
            }
        }
        else if(root.bf == -2){
            // right heavy avl tree
            if(root.right.bf <= 0){
                // right right rotation
                System.out.println("performing right right for " + root.data);
                root = this.rightRightRotation(root);
            }
            else {
                // right left rotation
                System.out.println("performing right left for " + root.data);
                root = this.rightLeftRotation(root);
            }
        }

        return root;
    }

    private AvlTreeNode updateHeightAndBalenceFactor(AvlTreeNode node){
        // cheking hight
        int leftHeight = node.left == null ? -1 : node.left.height;
        int rightHeight = node.right == null ? -1 : node.right.height;

        node.height = 1 + Math.max(leftHeight, rightHeight);

        // checking balance factor
        node.bf = leftHeight - rightHeight;
        return node;
    }

    private AvlTreeNode leftLeftRotation(AvlTreeNode node){
        node = rightRotation(node);
        return node;
    }

    private AvlTreeNode leftRightRotation(AvlTreeNode node){
        node.left = rightRightRotation(node.left);
        node = leftLeftRotation(node);
        return node;
    }

    private AvlTreeNode rightRightRotation(AvlTreeNode node){
        node = leftRotation(node);
        return node;
    }

    private AvlTreeNode rightLeftRotation(AvlTreeNode node){
        node.right = leftLeftRotation(node.right);
        node = rightRightRotation(node);
        return node;
    }



    private AvlTreeNode rightRotation(AvlTreeNode node){
        AvlTreeNode newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;

        // after change update height and balence factors
        node = updateHeightAndBalenceFactor(node);
        newNode = updateHeightAndBalenceFactor(newNode);
        return newNode;
    }

    private AvlTreeNode leftRotation(AvlTreeNode node){
        AvlTreeNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        node = updateHeightAndBalenceFactor(node);
        newRoot = updateHeightAndBalenceFactor(newRoot);

        return newRoot;
    }


    public void traverseInorder(){
        if(this.root != null){
            System.out.println("----------in order----------");
            this.root.traverseInOrder();
            System.out.println("\n----------in order----------");
        }
    }

    public void traverseLevelOrder(){
        if(this.root != null){
            System.out.println("----------level order----------");
            this.root.traverseLevelOrder();
            System.out.println("\n----------level order----------");
        }
    }


}
