class ImplementTrie {
    // Initialize your data structure here.
    public Map<Character, TrieNode> map;
    public boolean isEnd;
    public TrieNode() {
        map = new HashMap<Character, TrieNode>();
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new TrieNode());
            }
            curr = curr.map.get(c);
        }
        curr.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word.length() == 0) {
            return true;
        }
        
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }
        
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");