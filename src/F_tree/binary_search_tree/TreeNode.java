package F_tree.binary_search_tree;

import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int data){
        if(data == this.data){
            throw new RuntimeException("duplicate value");
        }

        if(data < this.data){
            // got to left
            if(this.leftChild == null){
                System.out.println(data + " inserted left to " + this.data);
                this.leftChild = new TreeNode(data);
            }
            else {
                this.leftChild.insert(data);
            }
        }
        else {
            if(this.rightChild == null){
                System.out.println(data + " inserted right to " + this.data);
                this.rightChild = new TreeNode(data);
            }
            else {
                this.rightChild.insert(data);
            }
        }
    }

    public TreeNode get(int data){
        if(data == this.data) return this;
        if(this.leftChild != null && data < this.data) return this.leftChild.get(data);
        if(this.rightChild != null && data > this.data) return this.rightChild.get(data);
        return null;
    }

    public int min(){
        if(this.leftChild == null) return this.data;
        return this.leftChild.min();
    }

    public int max(){
        if(this.rightChild == null) return this.data;
        return this.rightChild.max();
    }

    public void traverseInOrder(){
        if(this.leftChild != null) {
            this.leftChild.traverseInOrder();
        }
        System.out.print(this.data + ", ");
        if(this.rightChild != null){
            this.rightChild.traverseInOrder();
        }
    }

    public void morrisInOrder(){
        TreeNode current = this, predecessor = null;
        while (current != null){
            // if left child is null then print it and move to right child
            if(current.getLeftChild() == null){
                System.out.print(current.getData() + ", ");
                current = current.getRightChild();
            }
            else {
                predecessor = current.getLeftChild();
                // finding rightest node
                while (predecessor.getRightChild() != null && predecessor.getRightChild() != current){
                    predecessor = predecessor.getRightChild();
                }

                // cheking rightest node pointing to null or current node
                if(predecessor.getRightChild() == null){
                    // rightest node pointing to null

                    // temperory pointing rightest node to current node
                    predecessor.setRightChild(current);

                    // changing current node to next left node
                    current = current.getLeftChild();
                }
                else {
                    // rightest node pointing to current node

                    // left side is done so print current node i.e V
                    System.out.print(current.getData()+", ");

                    // removing temperory node
                    predecessor.setRightChild(null);

                    // left and vertext is done so move to right part
                    current = current.getRightChild();
                }
            }
        }
    }

    public void traversePreOrder(){
        System.out.print(this.data + ", ");
        if(this.leftChild != null) {
            this.leftChild.traversePreOrder();
        }

        if(this.rightChild != null){
            this.rightChild.traversePreOrder();
        }
    }

    public void morrisPreOrder(){
        TreeNode node = this;
        while (node != null) {

            // If left child is null, print the current node data. Move to
            // right child.
            if (node.getLeftChild() == null) {
                System.out.print(node.data + " ");
                node = node.getRightChild();
            } else {

                // Find inorder predecessor
                TreeNode current = node.getLeftChild();
                while (current.getRightChild() != null && current.getRightChild() != node) {
                    current = current.getRightChild();
                }

                // If the right child of inorder predecessor
                // already points to this node
                if (current.getRightChild() == node) {
                    current.setRightChild(null);
                    node = node.getRightChild();
                }

                // If right child doesn't point to this node, then print
                // this node and make right child point to this node
                else {
                    System.out.print(node.data + " ");
                    current.setRightChild(node);
                    node = node.getLeftChild();
                }
            }
        }
    }

    public void traversePostOrder(){
        if(this.leftChild != null) {
            this.leftChild.traversePostOrder();
        }

        if(this.rightChild != null){
            this.rightChild.traversePostOrder();
        }
        System.out.print(this.data + ", ");
    }

    public void stackPostOrder(){
        Stack<TreeNode> stack = new Stack<>();
        // for iterating in tree
        TreeNode current = this;

        // to keep track of previous seen node
        TreeNode prev = null;

        // at some point stack and current node will become empty at that point we have seen all node
        while (!stack.empty() || current!= null){

            // giving left side first priority
            if(current != null){
                // if node in not empty push to stack
                stack.push(current);
                current = current.getLeftChild();
            }else {
                // left is null so get previous seen node from stack
                TreeNode peekNode = stack.peek();
                // checking for right side is there
                // if right side is not there or we have seen right side node so print root
                if(peekNode.getRightChild() == null || peekNode.getRightChild() == prev){
                    System.out.print(peekNode.getData() + ", ");
                    prev = stack.pop(); // removing printed node from stack
                    // don't do any thing program will automatically shift to next stack peek
                }
                else {
                    // the root node have right part
                    // so giving right part second priority
                    current = peekNode.getRightChild();
                }
            }
        }
    }

    public void traverseLevelOrder(){
        LinkedList <TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()){
           TreeNode node =  queue.remove();
            System.out.print(node.getData() + ", ");
            if(node.getLeftChild() != null) queue.add(node.getLeftChild());
            if(node.getRightChild() != null) queue.add(node.getRightChild());
        }

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }


    @Override
    public String toString() {
        return "data = " + this.data;
    }
}
