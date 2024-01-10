package middle;

public class T208_Trie {

    TrieNode parent;

    public T208_Trie() {
        parent = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = parent;
        for (char c : word.toCharArray()) {
            TrieNode child = cur.children[c - 'a'];
            if (child == null) {
                child = new TrieNode();
            }
            cur.children[c - 'a'] = child;
            cur = child;
        }
        cur.hasEnd = true;
    }

    public boolean search(String word) {
        TrieNode trieNode = find(word);
        return trieNode != null && trieNode.hasEnd;
    }

    private TrieNode find(String word) {
        TrieNode cur = parent;
        for (char c : word.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null) {
                return null;
            }
        }
        return cur;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    static class TrieNode {
        private TrieNode[] children;

        private boolean hasEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
