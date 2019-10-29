package F_tree.avl_tree;

public class Main {
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(40);
        avlTree.insert(30);
        avlTree.insert(50);
        avlTree.insert(20);

        avlTree.delete(50);

        avlTree.traverseInorder();

        avlTree.traverseLevelOrder();
    }
}
