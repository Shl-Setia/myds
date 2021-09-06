package trie;

// Trie (Prefix tree)
// https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trieNode = searchPrefix(word);
        return null != trieNode && trieNode.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return null != searchPrefix(prefix);
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return null;
            }
        }
        return node;
    }
}
