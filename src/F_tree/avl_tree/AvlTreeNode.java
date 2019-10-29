package F_tree.avl_tree;

import java.util.LinkedList;

public class AvlTreeNode {
    int data;
    int height;
    int bf;

    AvlTreeNode left, right;

    public AvlTreeNode(int data){
        this.data = data;
        this.left= null;
        this.right = null;
    }

    public int getMin(){
        if(this.left == null) return this.data;
        return this.left.getMin();
    }

    public void traverseInOrder(){
        if(this == null) return;
        if(this.left != null) this.left.traverseInOrder();
        System.out.print("["+this.data+" | h:"+this.height+" | b:"+this.bf+" ]" + ", ");
        if(this.right != null) this.right.traverseInOrder();
    }

    public void traverseLevelOrder(){
        LinkedList<AvlTreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()){
            AvlTreeNode node =  queue.remove();
            System.out.print("["+node.data+" | h:"+node.height+" | b:"+node.bf+" ]" + ", ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
    }
}
