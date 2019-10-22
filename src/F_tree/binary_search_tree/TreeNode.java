package F_tree.binary_search_tree;

import java.util.LinkedList;

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

    public void traversePreOrder(){
        System.out.print(this.data + ", ");
        if(this.leftChild != null) {
            this.leftChild.traverseInOrder();
        }

        if(this.rightChild != null){
            this.rightChild.traverseInOrder();
        }
    }

    public void traversePostOrder(){
        if(this.leftChild != null) {
            this.leftChild.traverseInOrder();
        }

        if(this.rightChild != null){
            this.rightChild.traverseInOrder();
        }
        System.out.print(this.data + ", ");
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
