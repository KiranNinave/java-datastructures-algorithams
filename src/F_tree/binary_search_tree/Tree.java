package F_tree.binary_search_tree;

public class Tree {
    private TreeNode root;

    public Tree(){
        root = null;
    }

    public void insert(int data){
        if(this.root == null){
            System.out.println(data + " inserted as root");
            this.root = new TreeNode(data);
        }
        else {
            this.root.insert(data);
        }
    }

    public TreeNode get(int data){
        if(this.root != null){
            return this.root.get(data);
        }
        return null;
    }

    public void delete(int data){
        this.root = this.delete(this.root, data);
    }

    private TreeNode delete(TreeNode subtreeNode, int data){
        if(subtreeNode == null) return subtreeNode;

        if(data < subtreeNode.getData()){
            // search in left sub tree and update
            subtreeNode.setLeftChild(delete(subtreeNode.getLeftChild(), data));
        }
        else if(data > subtreeNode.getData()){
            subtreeNode.setRightChild(delete(subtreeNode.getRightChild(), data));
        }
        else {
            // values are equal so delete node
            if(subtreeNode.getLeftChild() == null){
                // left and right child is null or right child is present
                return subtreeNode.getRightChild();
            }
            else if(subtreeNode.getRightChild() == null){
                // left and right child is null or right child is present
                return subtreeNode.getLeftChild();
            }
            else {
                // node has two children
                // swap the values
                subtreeNode.setData(subtreeNode.getRightChild().min());

                // delete the leave node
                subtreeNode.setRightChild(delete(subtreeNode.getRightChild(), subtreeNode.getData()));
            }
        }

        return subtreeNode;
    }

    public int min(){
        if(this.root!=null)  return this.root.min();
        return -1;
    }

    public int max(){
        if(this.root != null) return this.root.max();
        return -1;
    }

    public void traverseInOrder(){
        if(this.root != null){
            this.root.traverseInOrder();
        }
    }

    public void morrisInOrder(){
        if(this.root != null){
            this.root.morrisInOrder();
        }
    }

    public void traversePreOrder(){
        if(this.root != null){
            this.root.traversePreOrder();
        }
    }

    public void morrisPreOrder(){
        if(this.root != null){
            this.root.morrisPreOrder();
        }
    }

    public void traversePostOrder(){
        if(this.root != null){
            this.root.traversePostOrder();
        }
    }

    public void stackPostOrder(){
        if(this.root != null){
            this.root.stackPostOrder();
        }
    }

    public void traverseLevelOrder(){
        if(this.root != null){
            this.root.traverseLevelOrder();
        }
    }


}
