package F_tree.trie;

import F_tree.binary_search_tree.TreeNode;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> map;
    boolean endOfString;

    public TrieNode(){
        map = new HashMap<>();
        endOfString = false;
    }
}
