package F_tree.binary_search_tree;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        System.out.println("--------in order---------");
        tree.traverseInOrder();
        System.out.println("\n--------in order---------");

        System.out.println("\n--------morris in order---------");
        tree.morrisInOrder();
        System.out.println("\n--------morris in order---------");

        System.out.println("\n--------pre order---------");
        tree.traversePreOrder();
        System.out.println("\n--------pre order---------");

        System.out.println("\n--------morris pre order---------");
        tree.morrisPreOrder();
        System.out.println("\n--------morris order---------");
//
        System.out.println("\n--------post order---------");
        tree.traversePostOrder();
        System.out.println("\n--------post order---------");
//
        System.out.println("\n--------stack post order---------");
        tree.stackPostOrder();
        System.out.println("\n--------stack post order---------");
//
//        System.out.println("\n--------level order---------");
//        tree.traverseLevelOrder();
//        System.out.println("\n--------level order---------");
//
//        System.out.println("--------searching---------");
//        System.out.println(tree.get(27));
//        System.out.println(tree.get(88));
//        System.out.println("--------searching---------");
//
//        System.out.println("--------min and max---------");
//        System.out.println("min = "+tree.min());
//        System.out.println("max = " + tree.max());
//        System.out.println("--------min and max---------");
//
//        System.out.println("--------deleting---------");
//        tree.delete(25);
//        tree.traverseInOrder();
//        System.out.println("\n--------deleting---------");

    }


}
