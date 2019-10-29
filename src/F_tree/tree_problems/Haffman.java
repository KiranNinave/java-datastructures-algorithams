package F_tree.tree_problems;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Haffman {
    class TreeNode{
        String data;
        int priority;
        TreeNode left, right;
        public TreeNode(String data, int priority){
            this.data = data;
            this.priority = priority;
            left = null;
            right=null;
        }

        public void traverseLevelOrder(){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()){
                TreeNode node =  queue.remove();
                System.out.print(node.data +"-"+ node.priority + ", ");
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

        }
    }

    class NodeComparator implements Comparator<TreeNode> {
        @Override
        public int compare(TreeNode treeNode, TreeNode t1) {
            if(treeNode.priority < t1.priority){
                return -1;
            }
            else if(treeNode.priority > t1.priority){
                return 1;
            }
            return 0;
        }
    }

    String bitTable[][];
    int couter = 0;

    public void getRequiredBits(TreeNode root, String bit){
        if(root.left != null){
            getRequiredBits(root.left, bit+"0");
        }
        if(root.data.length() == 1){
            System.out.println(root.data + " " + bit);
        }
        if(root.right != null){
            getRequiredBits(root.right, bit+"1");
        }
    }



    public int getCompressedBits(String table[][]){
        int result = 0, i;
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>(new NodeComparator());
        for(i=0; i<table.length; i++){
            priorityQueue.add( new TreeNode( table[i][0], Integer.parseInt(table[i][1])));
        }
        TreeNode root = null;
        while (true){
            TreeNode left = priorityQueue.remove();
            TreeNode right = priorityQueue.remove();
            root = new TreeNode( left.data+right.data, left.priority+right.priority );
            root.left = left;
            root.right = right;
            if(priorityQueue.isEmpty()) break;
            else priorityQueue.add(root);
        }

        root.traverseLevelOrder();
        bitTable = new String[table.length][table[0].length];
        couter=0;
        this.getRequiredBits(root, "");

        return result;
    }
    public static void main(String[] args) {
        String table[][] = { {"A", "7"}, {"B", "9"}, {"C", "11"}, {"D", "14"}, {"E", "18"},{"F","21"},{"G","27"},{"H", "29"},{"I", "35"},{"J", "40"} } ;
//        for(int i=0; i<table.length; i++){
//            for(int j=1;j<= Integer.parseInt(table[i][1]); j++){
//                System.out.print(table[i][0]);
//            }
//        }

        Haffman haffman = new Haffman();
        haffman.getCompressedBits(table);
    }
}
