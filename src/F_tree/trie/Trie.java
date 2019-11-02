package F_tree.trie;

import F_tree.binary_search_tree.TreeNode;

import java.util.Stack;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void add(String string){
        TrieNode current = this.root;
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);
            TrieNode node = current.map.get(c);
            if(node == null){
                node = new TrieNode();
                current.map.put(c, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println(string + " inserted");
    }

    public boolean search(String string){
        // finding the word
        TrieNode current = this.root;
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);
            TrieNode node = current.map.get(c);
            if(node == null){
                // char does not exist
                System.out.println("item not found");
                return false;
            }
            current = node;
        }

        // success means string found so check for end of word
        if(current.endOfString){
            System.out.println(string + " found");
            return true;
        }else {
            System.out.println(string + " found as prefix");
            return false;
        }
    }

    public boolean delete(String string){
        if(this.search(string)){
            return this.delete(this.root, string);
        }
        return false;
    }

    private boolean delete(TrieNode root, String string){
        Stack<TrieNode> stack = new Stack<>();
        TrieNode current = root;
        for(int i=0; i<string.length(); i++){
            stack.push(current);
            char c = string.charAt(i);
            current = current.map.get(c);
        }

        while (!stack.isEmpty()){
            TrieNode currentNode = stack.pop();

        }
        return true;
    }


}
