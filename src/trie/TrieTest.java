package trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("the");
        trie.insert("cattle");
        trie.insert("was");
        trie.insert("rattled");
        trie.insert("by");
        trie.insert("battery");
        System.out.println(trie.startsWith("bat"));
        System.out.println(trie.startsWith("rat"));

    }
}
